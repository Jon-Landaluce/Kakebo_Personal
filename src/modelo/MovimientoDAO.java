package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class MovimientoDAO {
    private String path;

    public MovimientoDAO(String path) {
        this.path = path;
    }

    public void insertarMovimiento (Movimiento mov) throws SQLException {
        String sql = "INSERT into movimientos(fecha,concepto,tipo_movimiento,cantidad,dni_usuario,id_categoria) values(?, ?, ?, ?,'DNIPORDEFECTO',?)";

        Connection conn = new Utilidades().getConnection(path);

        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));

        sentenciaSQL.setString(1,mov.getFecha().toString());
        sentenciaSQL.setString(2, mov.getConcepto());
        sentenciaSQL.setString(3, mov.getTipo());
        sentenciaSQL.setDouble(4, mov.getValor());

        /* if (mov.getTipo()) */
        if (mov instanceof Ingreso) {
            sentenciaSQL.setInt(5, ((Ingreso) mov).getCategoria().getId());
        } else {
            sentenciaSQL.setInt(5, ((Gasto) mov).getCategoria().getId());
        } 
        // estaria bien meter un mensaje de error
        

        sentenciaSQL.executeUpdate();
        conn.close();

    }

    public ArrayList<Movimiento> traeTodos() throws SQLException {

        String sql = " select fecha, concepto, cantidad, movimientos.tipo_movimiento, id_categoria, descripcion from movimientos join categorias on movimientos.tipo_movimiento = categorias.tipo_movimiento and movimientos.id_categoria = categorias.id order by fecha desc;";

        /*
         select fecha, concepto, cantidad, movimientos.tipo_movimiento, id_categoria, descripcion
                 from movimientos join categorias
                                            on movimientos.tipo_movimiento = categorias.tipo_movimiento
											   and movimientos.id_categoria = categorias.id
                 order by fecha desc;
          
         */
        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        ArrayList<Movimiento> listaMov = new ArrayList<>();

        while (resultado.next()) {
            // Si resultado es de tipo I, crear un Ingreso
            // si es de tipo G crear un gasto
            String tipo = resultado.getString("tipo_movimiento");
            Movimiento nuevo;
            if (tipo.equals("I")) {
                nuevo = new Ingreso(LocalDate.parse(resultado.getString("fecha")),
                                               resultado.getString("concepto"),
                                               resultado.getFloat("cantidad"),
                                               CategoriaIngreso.valueOf(resultado.getString("descripcion")));
            } else {

                nuevo = new Gasto(LocalDate.parse(resultado.getString("fecha")),
                                               resultado.getString("concepto"),
                                               resultado.getFloat("cantidad"),
                                               CategoriaGasto.valueOf(resultado.getString("descripcion")));
            }
            listaMov.add(nuevo);
        }
        return listaMov;

        }
}