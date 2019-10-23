package com.mycompany.practica2;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Socio {
    private String nombre;
    private int num_socio;
    private int importe_motos = 0;
    private ArrayList<Moto> lista_motos = new ArrayList<Moto>();
    private static int cont = 0;
    
    
    public Socio (String nombre){
        this.nombre = nombre;
        this.num_socio = cont++;
    }
    
    public int ImporteMotos(){
        
        for (int i = 0; i < lista_motos.size(); i++){
            importe_motos += lista_motos.get(i).getPrecio();
        }
    
        return importe_motos; 
   }
    
    public int getNumMotos (){
        return lista_motos.size();
    }
    
    public int getNumSocio(){
        return num_socio;
    }
    
    public String getNombreSocio() {
        return nombre;
    }
   
    public void addMoto(Moto m){
        lista_motos.add(m);
    }
    
    public ArrayList<Moto> getListaMotos(){
        return lista_motos;
    }
    
    public void printMotos(){
        for (int i = 0; i < lista_motos.size(); i++){
            System.out.println("-------------------------------------");
            System.out.println("ID: " + lista_motos.get(i).getIdMoto() + "\nDescripcion: " + " "+ lista_motos.get(i).getDescripion());
            System.out.println("Matricula: " + lista_motos.get(i).getMatricula() +"\nPrecio: " +lista_motos.get(i).getPrecio());
            System.out.println("-------------------------------------");
        }
    }
    
    public void borrarMoto(Moto m){
        lista_motos.remove(m);
        importe_motos = importe_motos - m.getPrecio();
    }
}
    

