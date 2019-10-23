package com.mycompany.practica2;


import java.util.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */




public class Main {    
    public static void main (String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String nombre, opcion, descripcion, matricula, precio, oldSocio, newSocio, motoCes;
        Scanner sc = new Scanner(System.in);
        ArrayList<Socio> sociosdisponibles = new ArrayList<Socio>();
        ArrayList<Socio> lista_socios = new ArrayList<Socio>();
        ArrayList<Moto> lista_motos = new ArrayList<Moto>();
        ArrayList<Cesion> lista_cesiones = new ArrayList<Cesion>();
        BufferedWriter writer;
        
        do{
            System.out.println("Asociacion cultural de amigos de las motos antiguas.");
            System.out.println("M    E    N    U");
            System.out.println("1. Registrar nuevo miembro.");
            System.out.println("2. Registrar nueva motocicleta.");
            System.out.println("3. Registrar una cesion.");
            System.out.println("4. Lista de miembros con motos en posesion.");
            System.out.println("5. Lista de todas las motos.");
            System.out.println("6. Mostrar las cesiones realizadas.");
            System.out.println("0. Salir del programa.");

            opcion = sc.nextLine();
            switch(Integer.parseInt(opcion)){
                case 0://crear txt con historial de cesiones y socios
                    System.out.println("Saliendo del programa......");
                    
                    writer = new BufferedWriter(new FileWriter("salida.txt"));
                    
                    writer.write("-------------------------------------SOCIOS-----------------------------------------------\n");
                    for(Socio socio : lista_socios){
                        writer.write("Nombre: " + socio.getNombreSocio());
                    }
                    writer.write("\n///////////////////////////////////////////////////////////////////////////////////////////////////\n");
                    writer.write("-------------------------------------MOTOS-----------------------------------------------\n");
                    for (Moto moto : lista_motos){
                        writer.write("Descripcion de la moto: " + moto.getDescripion() + "\nMatricula: " + moto.getMatricula() + "  Precio: " + moto.getPrecio());
                    }
                    writer.write("\n///////////////////////////////////////////////////////////////////////////////////////////////////\n");
                    writer.write("-------------------------------------CESIONES-----------------------------------------------\n");
                    for (Cesion cesion : lista_cesiones){
                        writer.write("Moto cedida: " + cesion.getMoto() + "\nAntiguo propietario: " + cesion.getOldSocio() + "\nNuevo Propietario: " + cesion.getNewSocio());
                    }
                    writer.flush();
                    break;
                    
                case 1://crear un nuevo socio
                    System.out.println("Introduce el nombre del socio: ");
                    nombre = sc.nextLine();
                    Socio s = new Socio(nombre);
                    lista_socios.add(s);
                    System.out.println("Socio añadido a la lista de socios.\n");
                    break;
                    
                case 2: //crear una nueva moto (para que sea amigable tenemos que listar a los miembros (los que puedan) para poder elegir)
                    System.out.println("-------------------------------------");
                    System.out.println("Introduce una descripcion de la moto: ");
                    descripcion = sc.nextLine();
                    System.out.println("-------------------------------------");
                    System.out.println("Introduce la matricula de la moto: ");
                    matricula = sc.nextLine();
                    System.out.println("-------------------------------------");
                    System.out.println("Introduce el precio de la moto: ");
                    precio = sc.nextLine();
                    System.out.println("-------------------------------------");
                    
                    
                    for (int k = 0; k < lista_socios.size(); k++){
                        if(lista_socios.get(k).ImporteMotos() + Integer.parseInt(precio) < 6000){
                            System.out.println("-------------------------------------");
                            System.out.println(lista_socios.get(k).getNumSocio()+ " " + lista_socios.get(k).getNombreSocio());
                            sociosdisponibles.add(lista_socios.get(k));
                            System.out.println("-------------------------------------");
                        }
                    }
                    
                    if (sociosdisponibles.size() > 0){
                        System.out.println("-------------------------------------");
                        System.out.println("Introduce el numero del socio al que quieres asignar la moto: ");
                        nombre = sc.nextLine();
                        Moto m = new Moto(descripcion, Integer.parseInt(precio), Integer.parseInt(nombre), matricula);
                        lista_motos.add(m);
                        lista_socios.get(Integer.parseInt(nombre)).addMoto(m);
                        break;
                    }
                    
                    else{
                        System.out.println("No hay socios disponibles, por tanto no se ha podido agregar la moto. \n\n");
                        break;
                    }
                
                case 3: //crear una cesion
                    System.out.println("-------------------------------------");
                    System.out.println("Selecciona un socio para ceder una moto: ");
                    
                    //MUESTRA LOS SOCIOS DISPONIBLES
                    for (int k = 0; k < lista_socios.size(); k++){
                        if (lista_socios.get(k).ImporteMotos() > 0){
                            System.out.println(lista_socios.get(k).getNumSocio()+ " " + lista_socios.get(k).getNombreSocio());
                        }
                    }
                    oldSocio = sc.nextLine();
                    
                    System.out.println("-------------------------------------");
                    System.out.println("Selecciona una moto: ");
                    lista_socios.get(Integer.parseInt(oldSocio)).printMotos();
                    motoCes = sc.nextLine();
                    
                    System.out.println("-------------------------------------");
                    System.out.println("Selecciona un socio al que se le ceda una moto: ");
                    
                    //MUESTRA LOS SOCIOS DISPONIBLES
                    for (int t = 0; t < lista_socios.size(); t++){
                        if(lista_socios.get(Integer.parseInt(oldSocio)) != lista_socios.get(t)) 
                            System.out.println(lista_socios.get(t).getNumSocio()+ " " + lista_socios.get(t).getNombreSocio());
                    }
                    newSocio = sc.nextLine();
                    
                    Moto motoAux = lista_motos.get(Integer.parseInt(motoCes));
                    lista_socios.get(Integer.parseInt(oldSocio)).borrarMoto(motoAux); //Borramos la moto del primer socio
                    
                    lista_socios.get(Integer.parseInt(newSocio)).addMoto(motoAux); //Añadimos la moto al segundo socio
                    
                    Cesion c = new Cesion(motoAux, lista_socios.get(Integer.parseInt(oldSocio)), lista_socios.get(Integer.parseInt(newSocio)));
                    lista_cesiones.add(c);
                    
                    motoAux.setSocio(Integer.parseInt(newSocio));
                    
                    break;
                    
                case 4: //listar los socios con moto
                    for (int k = 0; k < lista_socios.size(); k++){
                        if (lista_socios.get(k).ImporteMotos() > 0){
                            System.out.println(lista_socios.get(k).getNumSocio()+ " " + lista_socios.get(k).getNombreSocio());
                            lista_socios.get(k).printMotos();
                        }
                    }
                    break;
                    
                case 5: //Lista de motos con sus dueños
                    for (int r = 0; r < lista_motos.size(); r++){
                        lista_motos.get(r).printMoto();
                    }
                    
                    break;
                    
                case 6: //Historial de cesiones
                    for (int i = 0; i < lista_cesiones.size(); i++){
                        lista_cesiones.get(i).printCesion();
                    }
                    
                    break;
                    
                default:
                    System.out.println("Solo se aceptan valores del 0 al 6 para el menu de opciones. ");
                    break;
            }
        }while(Integer.parseInt(opcion) != 0);
    }
}