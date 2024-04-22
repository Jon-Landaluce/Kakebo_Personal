package tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import modelo.CategoriaIngreso;
import modelo.Gasto;
import modelo.Ingreso;
import modelo.CategoriaGasto;

public class TestModelos {

    @Test

    public void testCrearCategoriaIngreso() {
        CategoriaIngreso cati = CategoriaIngreso.OTROS;
        assertEquals(CategoriaIngreso.OTROS, cati);
    }
    // test resto de categorias

    @Test

    public void testCrearCategoriaGasto() {
        CategoriaGasto catg = CategoriaGasto.EXTRA;
        assertEquals(CategoriaGasto.EXTRA, catg);
    }
    //test resto de categorias

    @Test 

    public void testCrearIngreso() {
        Ingreso ing = new Ingreso(LocalDate.of(2023, 05, 24), "Nomina", 2000, CategoriaIngreso.EMPLEO);

        assertEquals(LocalDate.of(2023, 05, 24), ing.getFecha());
        assertEquals("Nomina", ing.getConcepto());
        assertEquals(2000, ing.getValor(), 0.00001);
        assertEquals(CategoriaIngreso.EMPLEO, ing.getCategoria());
        //assertEquals("I", ing.getTipo());

    }

    @Test
    public void testIngresoTieneTipoI() {
        Ingreso ing = new Ingreso(LocalDate.of(2024, 1, 1), "Soy un ingreso", 1200, CategoriaIngreso.PASIVOS);

        assertEquals("I", ing.getTipo());
    }

    @Test 

    public void testCrearGasto() {
        Gasto gast = new Gasto (LocalDate.of(2021, 07, 12), "Cine", 25, CategoriaGasto.OCIO);

        assertEquals(LocalDate.of(2021, 07, 12), gast.getFecha());
        assertEquals("Cine", gast.getConcepto());
        assertEquals(25, gast.getValor(), 0.00001);
        assertEquals(CategoriaGasto.OCIO, gast.getCategoria());
        assertEquals("G", gast.getTipo());
    }

    @Test
    public void testCategoriaIngresosConIdsAsociados() {

        CategoriaIngreso empleo = CategoriaIngreso.EMPLEO;
        CategoriaIngreso negocios = CategoriaIngreso.NEGOCIOS;
        CategoriaIngreso pasivos = CategoriaIngreso.PASIVOS;
        CategoriaIngreso pensiones = CategoriaIngreso.PENSIONES;
        CategoriaIngreso otros = CategoriaIngreso.OTROS;

        assertEquals(empleo.getId(), 1);
        assertEquals(negocios.getId(), 3);
        assertEquals(pasivos.getId(), 2);
        assertEquals(pensiones.getId(), 4);
        assertEquals(otros.getId(), 5);
    }

    @Test
    public void testIngresoDevuelveCategoriaIngreso() {
        Ingreso ing = new Ingreso(LocalDate.now(),  "null", 0, CategoriaIngreso.NEGOCIOS);

        assertEquals(3, ing.getCategoria().getId());
        
    }

    @Test
    public void testGastoDevuelveCategoriaGasto() {
        Gasto gasto = new Gasto(LocalDate.of(1980,2,2), "Concepto Gasto",20, CategoriaGasto.OCIO);

        assertEquals(2, gasto.getCategoria().getId());
        
    }

    /* @Test 

    public void testCrearCategoriaIngresoById () {
        CategoriaIngreso cat = new CategoriaIngreso.setId(3);
        assertEquals(CategoriaIngreso.NEGOCIOS, cat);
    } */
    
}
