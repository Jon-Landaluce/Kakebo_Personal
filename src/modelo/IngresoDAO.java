/* package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngresoDAO {

    private String path;

    public IngresoDAO (String path) {
        this.path = path;
    }

    public void insertarIngreso(Ingreso ing) throws SQLException {

        Connection conn = new Utilidades().getConnection(path);

        String sql = "INSERT into movimientos(fecha,concepto,tipo_movimiento,cantidad,dni_usuario,id_categoria) values(?, ?, ?, ?,'DNIPORDEFECTO',?)";

        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));

        // Rescatamos el atributo usando el getter de la clase Ingreso y lo trasnformamos a String
        sentenciaSQL.setString(1,ing.getFecha().toString());
        sentenciaSQL.setString(2, ing.getConcepto());
        sentenciaSQL.setString(3, ing.getTipo());
        sentenciaSQL.setDouble(4, ing.getValor());
        sentenciaSQL.setInt(5, ing.getCategoria().getId());

        sentenciaSQL.executeUpdate();
        conn.close();
 */

        // Una manera de hacerlo pero es preferible definir la funcionalidad 
        // de get categoria directaemnte en la clase ingreso
        /* CategoriaIngreso cat = (CategoriaIngreso)ing.getCategoria();
        sentenciaSQL.setInt(5, cat.getId()); */
    
/*     }


    
}
 */
