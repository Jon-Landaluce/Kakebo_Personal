package modelo;

public enum CategoriaGasto {

    NECESIDAD(1),
    OCIO(2),
    CULTURA(3),
    EXTRA(4);
    

    public int getId() {
        return id;
    }

    private int id;

    // Cuando llamamos al enum inicia el constructor y asigna la clave a la seleccion
    private CategoriaGasto(int id) {
        this.id = id;
    }
}