package com.mycompany.practica2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Moto {
    private String descripcion, matricula;
    private int precio;
    private int socio;
    private int idMoto;
    private static int cont = 0;
    
    public Moto(String descripcion, int precio, int socio, String matricula){
        this.descripcion = descripcion;
        this.precio = precio;
        this.socio = socio;
        this.matricula = matricula;
        idMoto = cont++;
    }

    public int getPrecio(){
        return precio;
    }
    
    public int getSocio(){
        return socio;
    }
    
    public void setSocio(int socio){
        this.socio = socio;
    }

    public String getMatricula(){
        return matricula;
    }
    
    public String getDescripion(){
        return descripcion;
    }
    
    public int getIdMoto(){
        return idMoto;
    }
    
    public void printMoto(){
           System.out.println("Matricula: " + matricula);
           System.out.println("Descripcion: " + descripcion);
           System.out.println("Precio: " + precio);
           System.out.println("Socio propietario: " + socio);
           System.out.println("");
           System.out.println("-------------------------------------");
    }
    
 }
