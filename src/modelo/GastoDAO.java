/* package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GastoDAO {

    private String path;

    public GastoDAO(String path) {
        this.path = path; 
    }

    public void insertarGasto(Gasto gasto) throws SQLException {

        String sql = "INSERT into movimientos(fecha,concepto,tipo_movimiento,cantidad,dni_usuario,id_categoria) values(?, ?, ?, ?,'DNIPORDEFECTO',?)";

        Connection conn = new Utilidades().getConnection(path);

        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));

        // Rescatamos el atributo usando el getter de la clase Ingreso y lo trasnformamos a String
        sentenciaSQL.setString(1,gasto.getFecha().toString());
        sentenciaSQL.setString(2, gasto.getConcepto());
        sentenciaSQL.setString(3, gasto.getTipo());
        sentenciaSQL.setDouble(4, gasto.getValor());
        sentenciaSQL.setInt(5, gasto.getCategoria().getId());

        sentenciaSQL.executeUpdate();
    
    }


    
}

 */