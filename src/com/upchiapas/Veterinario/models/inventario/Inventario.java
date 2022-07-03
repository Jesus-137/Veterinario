package com.upchiapas.Veterinario.models.inventario;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos= new ArrayList<>();
    public void agregarLimpieza(Limpieza limpieza){
        productos.add(limpieza);
    }
    public void agregarAccesorio(Accesorio accesorio){
        productos.add(accesorio);
    }
    public void agregarMedicamento(Medicamento medicamento){productos.add(medicamento);}
    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
