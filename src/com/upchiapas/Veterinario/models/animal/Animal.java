package com.upchiapas.Veterinario.models.animal;

import java.util.Scanner;

public class Animal {
    protected String nombre;
    protected String tipo;
    protected Cartilla cartilla;
    protected Animal(String nombre, String tipo, Cartilla cartilla){
        this.nombre=nombre;
        this.tipo=tipo;
        this.cartilla=cartilla;
    }

    public String getNombre() {return nombre;}

    public String getTipo() {return tipo;}

    public void setCartilla(Cartilla cartilla) {this.cartilla = cartilla;}

    public int citas() {
        return cartilla.getNumeroCitas();
    }
    public int vacunas(){
        return cartilla.getVacunas();
    }
}
