package modelo;

import java.time.LocalDate;



// Movimiento es el concepto mas nuclear 

public abstract class Movimiento {

    // Atrubutos
    private LocalDate fecha;
    private String concepto;
    private float valor;
    private Enum<?> categoria;
    protected String tipo; // solo deja acceder a la que heredan de esta clase

    // Constructor principal

    public Movimiento(LocalDate fecha, String concepto, float valor, Enum<?> categoria) {
        if (fecha == null) {
            this.fecha = LocalDate.now();
        }
        this.fecha = fecha;
        this.concepto = concepto;
        this.valor = valor;
        this.categoria = categoria;
    }

    /* public Movimiento (LocalDate fecha, String concepto, float valor, Enum<?> categoria) {
        this(LocalDate.now(), concepto, valor, categoria);
    } */

    public LocalDate getFecha() {
        return fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public float getValor() {
        return valor;
    }

    public Enum<?> getCategoria() {
        return categoria;
    }

    public String getTipo() {
        return tipo;
    }

    // Logica para guardar el movimiento en la base de datos aqui o en el dao?

    






    
}
