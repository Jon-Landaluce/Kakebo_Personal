package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import modelo.CategoriaGasto;
import modelo.CategoriaIngreso;
import modelo.Gasto;
//import modelo.GastoDAO;
import modelo.Ingreso;
import modelo.Movimiento;
//import modelo.IngresoDAO;
import modelo.MovimientoDAO;
import modelo.Utilidades;



public class TestDAO {

    // Verificamos que tenemos el archivo .jar en lib
    @Test
    public void testJDBCConecta() {

        boolean laClaseJDBCExiste = false;
        try{
            Class.forName("org.sqlite.JDBC");
            System.out.println("Todo ha ido bien");
            laClaseJDBCExiste = true;
        } catch (ClassNotFoundException error) {
            System.out.println("SQLite JDBC no encontrado");
            error.printStackTrace();
        }
        assertTrue(laClaseJDBCExiste);
    }
    
    // Verificamos que tenemos conexion con la base de datos
    @Test
    public void testCrearConexion() throws SQLException {

        // Instanciamos la clase donde creamos la conexion
        Utilidades utils = new Utilidades();

        // Guardamos el resultado de la funcion en una variable tipo connection
        Connection conn = utils.getConnection("./data/kakebo_tests.sqlite");
        
        // Verificamos que se ha asignado valor a la variable
        assertNotNull(conn);
        conn.close();

        // Verificamos que devuelve un null cuandoi la conexion no s epuede crear
        conn = utils.getConnection("./lolailololailo/kakebo_tests.sqlite");
        assertNull(conn);
    }

    //Verificamois que inserta Ingreso
    @Test
    public void testInsertarIngreso () throws SQLException {

        MovimientoDAO dao = new MovimientoDAO("./data/kakebo_tests.sqlite");

        Ingreso ingreso = new Ingreso(LocalDate.of(1970,1,1), "Cualquier concepto", 10, CategoriaIngreso.OTROS);

        /* Connection conn = new Utilidades().getConnection("./data/kakebo_tests.sqlite"); */

        dao.insertarMovimiento(ingreso);

        // Hacer consulta a la base de datos y comprobar columna a columna

        //Creamos las variables de la consulta para almacenar los valores del resultado
        // de la query 1 por 1 ya que despues haremos asserts sobre ellas

        String fecha = "";
        String concepto = "";
        String tipo_movimiento = "";
        String dni_usuario = "";
        int id_categoria = -1;
        double cantidad = 0;

      
        // Ordenamos la consulta y con limit accedemos solo al ultimo registro
        String sql = "SELECT id, fecha, concepto, cantidad, tipo_movimiento, id_categoria, dni_usuario FROM movimientos ORDER BY id desc LIMIT(1);";
        Connection conn = new Utilidades().getConnection("./data/kakebo_tests.sqlite");
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        if (resultado.next()) {
            fecha = resultado.getString("fecha");
            concepto = resultado.getString("concepto");
            tipo_movimiento = resultado.getString("tipo_movimiento");
            dni_usuario = resultado.getString("dni_usuario");
            id_categoria = resultado.getInt("id_categoria");
            cantidad = resultado.getDouble("cantidad");
        }
        conn.close();
        // Comprobaciones
        assertEquals("1970-01-01", fecha);
        assertEquals("Cualquier concepto", concepto);
        assertEquals("I", tipo_movimiento);
        assertEquals(5, id_categoria);
        assertEquals(10, cantidad, 0.00001);
    
    }

    //Verificamois que inserta Gasto
    @Test
    public void testInsertarGasto () throws SQLException {

        MovimientoDAO dao = new MovimientoDAO("./data/kakebo_tests.sqlite");

        Gasto gasto = new Gasto(LocalDate.of(1980,2,2), "Concepto Gasto",20, CategoriaGasto.OCIO);

        Connection conn = new Utilidades().getConnection("./data/kakebo_tests.sqlite");

        dao.insertarMovimiento(gasto);

        String fecha = "";
        String concepto = "";
        String tipo_movimiento = "";
        String dni_usuario = "";
        int id_categoria = -1;
        double cantidad = 0;

        String sql = "SELECT id, fecha, concepto, cantidad, tipo_movimiento, id_categoria, dni_usuario FROM movimientos ORDER BY id desc LIMIT(1);";

        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        if (resultado.next()) {
            fecha = resultado.getString("fecha");
            concepto = resultado.getString("concepto");
            tipo_movimiento = resultado.getString("tipo_movimiento");
            dni_usuario = resultado.getString("dni_usuario");
            id_categoria = resultado.getInt("id_categoria");
            cantidad = resultado.getDouble("cantidad");
        }
        conn.close();

        // Comprobaciones
        assertEquals("1980-02-02", fecha);
        assertEquals("Concepto Gasto", concepto);
        assertEquals("G", tipo_movimiento);
        assertEquals(2, id_categoria);
        assertEquals(20, cantidad, 0.00001);
    
        }

    @Test
    public void testInsertarMovimiento() throws SQLException {

        MovimientoDAO dao = new MovimientoDAO("./data/kakebo_tests.sqlite");
        
        Ingreso ing = new Ingreso(LocalDate.of(1990,1,1), "Soy un ingreso", 10, CategoriaIngreso.EMPLEO);
        Gasto gasto = new Gasto(LocalDate.of(1990,1,2), "Soy un gasto", 12, CategoriaGasto.NECESIDAD);

        dao.insertarMovimiento(ing);
        dao.insertarMovimiento(gasto);

        //

        String fecha = "";
        String concepto = "";
        String tipo_movimiento = "";
        String dni_usuario = "";
        int id_categoria = -1;
        double cantidad = 0;

        String sql = "SELECT id, fecha, concepto, cantidad, tipo_movimiento, id_categoria, dni_usuario FROM movimientos ORDER BY id desc LIMIT(2);";
        Connection conn = new Utilidades().getConnection("./data/kakebo_tests.sqlite");
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        if (resultado.next()) {
            fecha = resultado.getString("fecha");
            concepto = resultado.getString("concepto");
            tipo_movimiento = resultado.getString("tipo_movimiento");
            dni_usuario = resultado.getString("dni_usuario");
            id_categoria = resultado.getInt("id_categoria");
            cantidad = resultado.getDouble("cantidad");
        }
        

        // Comprobaciones
        // al seleccionar las 2 ultimas tenemos que invertir el orden de las comproibaciones

        assertEquals("1990-01-02", fecha);
        assertEquals("Soy un gasto", concepto);
        assertEquals("G", tipo_movimiento);
        assertEquals(1, id_categoria);
        assertEquals(12, cantidad, 0.00001);

        if (resultado.next()) {
            fecha = resultado.getString("fecha");
            concepto = resultado.getString("concepto");
            tipo_movimiento = resultado.getString("tipo_movimiento");
            dni_usuario = resultado.getString("dni_usuario");
            id_categoria = resultado.getInt("id_categoria");
            cantidad = resultado.getDouble("cantidad");
        }
        conn.close();

        assertEquals("1990-01-01", fecha);
        assertEquals("Soy un ingreso", concepto);
        assertEquals("I", tipo_movimiento);
        assertEquals(1, id_categoria);
        assertEquals(10, cantidad, 0.00001);
        
    }
    
    @Test

    public void testConsultarTodosMovimientos() throws SQLException {
        //Preparacion test
        // 1. Borrar todos los movimientos

        String sql = "DELETE FROM movimientos";

        Connection conn = new Utilidades().getConnection("./data/kakebo_tests.sqlite");

        Statement sentenciaSQL = conn.createStatement();

        sentenciaSQL.executeUpdate(sql);

        conn.close();

        // 2. Insertar 2-3 movimientos dao.insertar

        MovimientoDAO dao = new MovimientoDAO("./data/kakebo_tests.sqlite");

        Ingreso ing = new Ingreso(LocalDate.of(2024,4,1), "Sueldo", 1000, CategoriaIngreso.EMPLEO);
        Gasto gasto = new Gasto(LocalDate.of(2024,4,4), "Factura del agua", 43, CategoriaGasto.NECESIDAD);

        dao.insertarMovimiento(ing);
        dao.insertarMovimiento(gasto);

        ing = new Ingreso(LocalDate.of(2024,4,2), "Clases de ingles", 140, CategoriaIngreso.OTROS);
        gasto = new Gasto(LocalDate.of(2024,4,3), "Cine", 70, CategoriaGasto.OCIO);

        dao.insertarMovimiento(ing);
        dao.insertarMovimiento(gasto);


        // 3. Usar dao .traetodos 

        ArrayList<Movimiento> movimientos = dao.traeTodos();

        // 4. con aserciones comprobar los movimientos bioen ordenados por fecha descendente

        // Comprobar longitud del Array
        assertEquals(4, movimientos.size());
        // Comprobar la fecha accediento a la instancia de movimeinto del arraylist
        assertEquals(LocalDate.of(2024, 4, 4), movimientos.get(0).getFecha());
        assertEquals(43, movimientos.get(0).getValor(), 0.00001);
        // .... etc
        
        assertEquals(LocalDate.of(2024, 4, 3), movimientos.get(1).getFecha());
        assertEquals(LocalDate.of(2024, 4, 2), movimientos.get(2).getFecha());
        assertEquals(LocalDate.of(2024, 4, 1), movimientos.get(3).getFecha());

        assertInstanceOf(Gasto.class, movimientos.get(0));
        assertInstanceOf(Gasto.class, movimientos.get(1));
        assertInstanceOf(Ingreso.class, movimientos.get(2));
        assertInstanceOf(Ingreso.class, movimientos.get(3));

        assertEquals(CategoriaGasto.NECESIDAD, movimientos.get(0).getCategoria());
        assertEquals(CategoriaGasto.OCIO, movimientos.get(1).getCategoria());
        assertEquals(CategoriaIngreso.OTROS, movimientos.get(2).getCategoria());
        assertEquals(CategoriaIngreso.EMPLEO, movimientos.get(3).getCategoria());

    }

}
