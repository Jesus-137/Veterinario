package com.upchiapas.Veterinario.models.inventario;

import com.upchiapas.Veterinario.models.inventario.Inventario;

import java.util.Scanner;

public class Venta {
    private int total=0;
    public int venderProducto(Inventario inventario, int folio, int cantidad){
        int subtotal=0, i=0;boolean bandera=false;
        do {
            if (inventario.getProductos().get(i).getFolio()==folio){
                inventario.getProductos().get(i).cantidad-=cantidad;
                subtotal=inventario.getProductos().get(i).getPrecio()*cantidad;
                this.total+=subtotal;
                bandera=true;
            }
            i++;
        }while (!bandera);
        return subtotal;
    }

    public int getTotal() {
        return total;
    }
}
