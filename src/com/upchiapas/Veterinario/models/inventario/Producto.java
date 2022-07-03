package com.upchiapas.Veterinario.models.inventario;

import java.util.Scanner;

public class Producto {
    protected String nombre;
    protected int folio;
    protected int cantidad;
    protected int precio;
    protected Producto(String nombre, int folio, int cantidad, int precio) {
        this.nombre = nombre;
        this.folio = folio;
        this.cantidad = cantidad;
        this.precio=precio;
    }

    public int getFolio() {return folio;}

    public int getPrecio() {
        return precio;
    }
}
