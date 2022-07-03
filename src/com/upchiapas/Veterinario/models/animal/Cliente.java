package com.upchiapas.Veterinario.models.animal;

import com.upchiapas.Veterinario.models.inventario.Inventario;
import com.upchiapas.Veterinario.models.inventario.Venta;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
    private String nombre;
    private ArrayList<Animal>mascotas=new ArrayList<>();
    private Venta venta=new Venta();
    private int telefono;
    private int id;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int comprarProducto(Inventario producto, int folio,int cantidad){
        System.out.println("Su total es: "+venta.venderProducto(producto, folio, cantidad));
        return venta.venderProducto(producto, folio, cantidad);
    }
    public void agregarAereo(Aereo aereo){
        mascotas.add(aereo);
    }
    public void agregarAcuatico(Acuatico acuatico){
        mascotas.add(acuatico);
    }
    public void agregarTerrestre(Terrestre terrestre){
        mascotas.add(terrestre);
    }

    public int getId() {return id;}
    public int buscarMascota(String mascota){
        boolean bandera=false;
        int i=0, j=-1;
        Iterator<Animal> iterator = mascotas.iterator();
        while (iterator.hasNext()&&!bandera){
            if (mascotas.get(i).getNombre().equals(mascota)) {
                bandera = true;
                j=i;
            }
            i++;
            iterator.next();
        }
        return j;
    }

    public String nombreMascota(int i) {
        return mascotas.get(i).getNombre();
    }
    public String tipoMascota(int i){
        return mascotas.get(i).getTipo();
    }

    public ArrayList<Animal> getMascotas() {return mascotas;}
}
