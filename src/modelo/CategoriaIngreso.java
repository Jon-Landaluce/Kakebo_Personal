package modelo;

public enum CategoriaIngreso {

    EMPLEO(1),
    PASIVOS(2),
    NEGOCIOS(3),
    PENSIONES(4),
    OTROS(5);

    //Metemeos una clave al Enum y accedemos a el con id

    public int getId() {
        return id;
    }

    private int id;

    // Cuando llamamos al enum inicia el constructor y asigna la clave a la seleccion
    private CategoriaIngreso(int id) {
        this.id = id;
    }

    //public CategoriaIngreso setId (int id) {
        // Se podriua con un bucle recorriendo el enum y cuando coincida devuelvo
        // Unir tablas en SQL 

        //CategoriaIngreso.valueOf()

        /* 
        "SELECT fecha, concepto, cantidad, tipo_movimiento, 
        id_categoria, descripcion 
        
        FROM movimientos join categorias
        
        on movimientos.tipo_movimientos = categorias.tipo_movimiento
        and movimientos.id_categoria=categorias.id
        where fecha > "2024-04-01"
        order by fecha desc;"
        */

    //}


}
    
    
