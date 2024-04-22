import javax.swing.JFrame;

import controlador.Controller;

import java.awt.FlowLayout;

// import vista.HolaMundoGUI;

import vista.DetalleMovimiento;;

public class PruebasVista {
    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        Controller controller = new Controller();

        ventana.setLayout(new FlowLayout());
        ventana.add(new DetalleMovimiento(controller));
        ventana.pack();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true); // hacer que la ventana sea visible
        // Minimo para inciar la aplicacion:
        // PSVM
        // Instanciar la clase donde le estamsod dando instrucciones
        // Hacerla visible

        Controller controlador = new Controller();
    }
}