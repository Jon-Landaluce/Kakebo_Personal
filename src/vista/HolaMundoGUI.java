package vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class HolaMundoGUI extends JFrame {
    
    JLabel texto; // Asignar el tipo de varibale que es el nombre del framework
    JButton btn;  // Asignar el tipo de varibale que es el nombre del framework

    // Tenemos que agregarle la funcion de accionar
    // y al que le llema la funcion de escuchador
    
    private void btnClick(ActionEvent ev) {
        this.texto.setText("Adios");
    }
    
    public HolaMundoGUI(String title) {
        // Disposicion de la ventana
        super(title); // tenemos que heredar por como funciona JFrame
        setSize(600,400);
        // Tipo de disposicion de los elementos en la ventana
        setLayout(new FlowLayout());

        texto = new JLabel("Hola Mundo");
        btn = new JButton("Pulsame");
        // Asociamos la accion de que al pulsar el boton envie un orden
        // Y se lanza btnClick (arriba) es una funcion dentro de una funcion
        btn.addActionListener(e -> btnClick(e));


        /* btn.addAnctionListener(new ActionListener() {
            @Override
            public void actionPerformed() {
                texto.setText("Adios");
            }
        }); */

        add(texto);
        add(btn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tumbar aplicacion
        setVisible(true);
    }

    public HolaMundoGUI(){
        this("No me has puesto titulo");
    }

    public HolaMundoGUI(String title, int version) {
        this(String.format("%s v%d.0", title, version));
    }

}
