package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import controlador.Controller;

//import modelo.DAOBBDD;

public class Main {
    public static void main(String[] args) {
        /* System.out.println("Aqui ira una aplicacion");

        // Comprobacion de archivos .jar para comunicacion

        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Conexion relizada con éxito");        
        } catch (ClassNotFoundException error) {
            System.out.println("SQLite JDBC no encontrado");
            error.printStackTrace();
        }

        // Solicitar ruta de la base de datos

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese ruta del archivo de la base de datos: ");
        String path = scanner.nextLine();

        // Obtener conexion

        DAOBBDD comm = new DAOBBDD();
        Connection getConn = comm.getConnection(path);
        System.out.println(getConn);

        
        // Informar tipo de movimiento

        comm.insertarTipoMovimiento("I","Ingreso_1", getConn);


        // Informar informar categoria
        

        Connection CloseConn = comm.closeConnection(conn); //??
        System.out.println(CloseConn); */
        System.out.println("Aqui ira una aplicacion");
        new Controller();


    }
}