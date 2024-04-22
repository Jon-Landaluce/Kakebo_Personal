package modelo;

import java.time.LocalDate;

public class Ingreso extends Movimiento {
    public Ingreso (LocalDate fecha, String concepto, float valor, Enum<?>Categoria) {
        super(fecha, concepto, valor, Categoria);
        tipo = "I";
    }


    @Override
    public CategoriaIngreso getCategoria() {
            return (CategoriaIngreso) super.getCategoria();

    } 
}