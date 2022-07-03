package com.upchiapas.Veterinario;

import com.upchiapas.Veterinario.models.animal.*;
import com.upchiapas.Veterinario.models.inventario.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static Inventario inventario=new Inventario();
    private static ArrayList<Cliente> clientes =new ArrayList<>();
    private static Venta venta=new Venta();
    private static Cartilla cartilla=new Cartilla();
    private static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void agregarProductos(){
        String nombre;
        int opcion, folio, cantidad, precio;
        System.out.println("Menu");
        System.out.println("1- Medicamentos");
        System.out.println("2- Accesorios");
        System.out.println("3- Limpieza");
        opcion=scanner.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Ingrese el nombre del producto");
                nombre=scanner.next();
                System.out.println("Ingrese el folio del producto");
                folio=scanner.nextInt();
                System.out.println("Ingrese la catidad del producto");
                cantidad=scanner.nextInt();
                System.out.println("Ingrese el precio");
                precio=scanner.nextInt();
                Medicamento medicamento=new Medicamento(nombre, folio, cantidad, precio);
                inventario.agregarMedicamento(medicamento);
                break;
            case 2:
                System.out.println("Ingrese el nombre del producto");
                nombre=scanner.next();
                System.out.println("Ingrese el folio del producto");
                folio=scanner.nextInt();
                System.out.println("Ingrese la catidad del producto");
                cantidad=scanner.nextInt();
                System.out.println("Ingrese el precio");
                precio=scanner.nextInt();
                Accesorio accesorio=new Accesorio(nombre, folio, cantidad, precio);
                inventario.agregarAccesorio(accesorio);
                break;
            case 3:
                System.out.println("Ingrese el nombre del producto");
                nombre=scanner.next();
                System.out.println("Ingrese el folio del producto");
                folio=scanner.nextInt();
                System.out.println("Ingrese la catidad del producto");
                cantidad=scanner.nextInt();
                System.out.println("Ingrese el precio");
                precio=scanner.nextInt();
                Limpieza limpieza =new Limpieza(nombre, folio, cantidad, precio);
                inventario.agregarLimpieza(limpieza);
                break;
            default:
                System.out.println("opcion no valida");
        }
    }
    public static void registrarCliente(){
        Cliente cliente=new Cliente(); String telefono; int cel=0;
        System.out.println("Ingrese el nombre del cliente");
        cliente.setNombre(scanner.next());
        do {
            System.out.println("Ingrese el numero telefonico del cliente");
            telefono=scanner.next();
            if (telefono.length()==10){
                cel=Integer.parseInt(telefono);
                cliente.setTelefono(cel);
            }
        }while (cel==0);
        System.out.println("Asignar un id al cliente");
        cliente.setId(scanner.nextInt());
        clientes.add(cliente);
    }
    public static void menu(){
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1- Vender");
            System.out.println("2- Registrar mascota");
            System.out.println("3- Total ganado");
            System.out.println("4- Agregar producto");
            System.out.println("5- Registar cliente");
            System.out.println("6- Modificar cartilla");
            System.out.println("7- Mostrar mascotas");
            System.out.println("8- mostrar cartilla");
            System.out.println("9- Salir");
            opcion=scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el folio del producto");
                    int folio=scanner.nextInt();
                    System.out.println("Ingrese la cantidad del producto");
                    int cantidad=scanner.nextInt();
                    System.out.println("Su total es: "+venta.venderProducto(inventario, folio, cantidad));
                    break;
                case 2:
                    opciones(buscarCliente());
                    break;
                case 3:
                    System.out.println("El total es: "+venta.getTotal());
                    break;
                case 4:
                    agregarProductos();
                    break;
                case 5:
                    registrarCliente();
                    break;
                case 6:
                    modificarCartilla(buscarCliente());
                    break;
                case 7:
                    mostrarMascota(buscarCliente());
                    break;
                case 8:
                    System.out.println("ingrese el nombre de la mascota");
                    String nombre=scanner.next();
                    int j = buscarCliente();
                    mostrarCartilla(clientes.get(j).buscarMascota(nombre), j);
                    break;
                case 9:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }while (opcion!=9);
    }
    public static void opciones(int i){
        String nombre, especie;
        int opcion;
        System.out.println("Menu");
        System.out.println("1 Terestre");
        System.out.println("2 Acuatico");
        System.out.println("3 Aéreo");
        opcion=scanner.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Ingrese el nombre de la mascota");
                nombre=scanner.next();
                System.out.println("Ingrese la especie de la mascota");
                especie=scanner.next();
                Terrestre terrestre =new Terrestre(nombre, especie, cartilla);
                clientes.get(i).agregarTerrestre(terrestre);
                break;
            case 2:
                System.out.println("Ingrese el nombre de la mascota");
                nombre=scanner.next();
                System.out.println("Ingrese la especie de la mascota");
                especie=scanner.next();
                Acuatico acuatico =new Acuatico(nombre, especie, cartilla);
                clientes.get(i).agregarAcuatico(acuatico);
                break;
            case 3:
                System.out.println("Ingrese el nombre de la mascota");
                nombre=scanner.next();
                System.out.println("Ingrese la especie de la mascota");
                especie=scanner.next();
                Aereo aereo=new Aereo(nombre, especie, cartilla);
                clientes.get(i).agregarAereo(aereo);
                break;
            default:
                System.out.println("opcion no valida");
        }
    }
    public static int buscarCliente(){
        boolean bandera=false;
        int i=0, id, j=-1;
        Iterator<Cliente> iterator=clientes.iterator();
        do {
            System.out.println("Ingrese la id del cliente");
            id=scanner.nextInt();
            do {
                if (iterator.next().getId()==id) {
                    bandera = true;
                    j=i;
                }
                i++;
            }while (iterator.hasNext()||!bandera);
        }while (j==-1);
        return j;
    }
    public static void modificarCartilla(int i){
        String nombre;
        System.out.println("Ingrese el nombre de la mascota");
        nombre=scanner.next();
        if(clientes.get(i).buscarMascota(nombre)!=-1) {
            System.out.println("Cantidad de vacunas recibidas");
            cartilla.setVacunas(scanner.nextInt());
            System.out.println("numero de citas asistidas");
            cartilla.setNumeroCitas(scanner.nextInt());
            clientes.get(i).getMascotas().get(i).setCartilla(cartilla);
        }
    }
    public static void mostrarMascota(int i){
        int j=0;
        ArrayList<Animal> animales;
        animales=clientes.get(i).getMascotas();
        Iterator<Animal> iterator=animales.iterator();
        while (iterator.hasNext()){
            System.out.println("El nombre del animal es: "+clientes.get(i).nombreMascota(j));
            System.out.println("El tipo de animal es: "+clientes.get(i).tipoMascota(j));
            iterator.next();
            j++;
        }
    }
    public static void mostrarCartilla(int i, int j){
        System.out.println("numero de vacunas y citas: "+clientes.get(j).getMascotas().get(i).vacunas()+" "+clientes.get(j).getMascotas().get(i).citas());
    }
}