package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Movimiento;

public class DetalleMovimiento extends JPanel  {

    private JLabel lblFecha;
    private JLabel lblConcepto;
    private JLabel lblCantidad;
    private JLabel lblCategoria;

    private JButton btn;
    private JButton taidaButton;

    private JTextField txtFecha;
    private JTextField txtConcepto;
    private JTextField txtCantidad; // Deberia ser un JSpinner
    private JTextField txtCategoria; // deberia ser un Combo

    private Movimiento movimiento;

    public void getUltimoMovimiento (Movimiento mov) {
        System.out.println("Me han pulsado, deberia pedir datos de la base de datos");
        //movimiento = new Ingreso(LocalDate.now(), "Un concepto", 10, CategoriaIngreso.EMPLEO);
        if (movimiento == null) {
            System.out.println("No hay movimientos en al base de datos");
            txtFecha.setText("");
            txtConcepto.setText("");
            txtCantidad.setText("");
            txtCategoria.setText("");

        } else {
            txtFecha.setText(movimiento.getFecha().toString());
            txtConcepto.setText(movimiento.getConcepto());
            txtCantidad.setText(String.format("%f", movimiento.getValor()));
            txtCategoria.setText(movimiento.getCategoria().name());   
        }
    }

    /* private ActionListener ultimoListener = new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent ev) {
            System.out.println("Soy este evento" + ev.getActionCommand());
        }
    }
 */
    public DetalleMovimiento () {
        
        setSize(200,300);
        setLayout(new GridLayout(5,2 ));

        lblFecha = new JLabel("Fecha");
        txtFecha = new JTextField(12);

        lblConcepto = new JLabel("Concepto");
        txtConcepto = new JTextField(12);

        lblCantidad = new JLabel("Cantidad");
        txtCantidad = new JTextField(12);

        lblCategoria = new JLabel("Categoria");
        txtCategoria = new JTextField(12);

        add(lblFecha);
        add(txtFecha);

        add(lblConcepto);
        add(txtConcepto);

        add(lblCantidad);
        add(txtCantidad);

        add(lblCategoria);
        add(txtCategoria);

        /* btn.addActionListener(e -> getUltimoMovimiento(e));
        add(btn); */
        btn = new JButton("Ultimo");
        // el elemento btn tiene de por si action listener se lo integramos
        btn.addActionListener(new ActionListener() {
            // tenemos que definirle este metodo
            @Override
            public void actionPerformed(ActionEvent ev) {
                // codigo de la accion a realizar
                System.out.println("Soy este evento " + ev.getActionCommand());
            }
        });

        taidaButton = new JButton("Primero");
       
        add(btn);
        add(taidaButton);
        
    }

    public void setActionListener (ActionListener listener) {
        btn.addActionListener(listener);
        //btn.add(ActionListener(listener));
        taidaButton.addActionListener(listener);
    }
    
}
