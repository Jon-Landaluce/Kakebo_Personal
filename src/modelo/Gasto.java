package modelo;

import java.time.LocalDate;

public class Gasto extends Movimiento {
    public Gasto (LocalDate fecha, String concepto, float valor, Enum<?>Categoria) {
        super(fecha, concepto, valor, Categoria);
        tipo = "G";
    }

    @Override
    public CategoriaGasto getCategoria() {
            return (CategoriaGasto) super.getCategoria();

    } 
}
