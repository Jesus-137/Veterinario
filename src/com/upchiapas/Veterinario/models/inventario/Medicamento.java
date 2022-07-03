package com.upchiapas.Veterinario.models.inventario;

import com.upchiapas.Veterinario.models.inventario.Producto;

public class Medicamento extends Producto {
    public Medicamento(String nombre, int folio, int cantidad, int precio){
        super(nombre, folio, cantidad, precio);
    }
}
