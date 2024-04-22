package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Movimiento;
import modelo.MovimientoDAO;
import vista.VentanaPrincipal;

public class Controller implements ActionListener {

    public Movimiento ultimo() {

        // Pedir el movimiento y comprobar que no est vacio 
        MovimientoDAO dao = new MovimientoDAO("./data/kakebo.sqlite");

        try{
            ArrayList<Movimiento> todos = dao.traeTodos();
            if(todos.size() > 0) {
                return todos.get(0);

            } else {
                return null;
            }
        } catch (SQLException err) {
            System.out.println("Error en acceso a movimientos");
            err.printStackTrace();
         }
        return null;
    }

    public Controller() {
        // pintar la ventana
        VentanaPrincipal ventana = new VentanaPrincipal();
        // Detectar el click del boton -> llamar a la funcion que he creado arriba
        ventana.setActionListener(this);
        
        
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Ultimo":
                Movimiento mov = ultimo();
                break;
            case "Primero":
                System.out.println("Soy el controlador y se que has pulsado el primero");
        }
          //Movimiento mov = ultimo();
    }
}
