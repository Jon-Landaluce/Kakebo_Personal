package vista;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.Movimiento;

public class VentanaPrincipal extends JFrame {

    private DetalleMovimiento panelMovimiento;

    public VentanaPrincipal() {
        super("KAKEBIN");
        panelMovimiento = new DetalleMovimiento();
        setLayout(new FlowLayout());
        add(panelMovimiento);
        pack(); // solo funciona con Flow LAyout

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        
    }
    
    public void setActionListener (ActionListener listener) {
        panelMovimiento.setActionListener(listener);
    }

    public void recojoMovimiento(Movimiento mov) {
        panelMovimiento.getUltimoMovimiento(mov);
    }
}
