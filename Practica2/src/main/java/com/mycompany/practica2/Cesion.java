package com.mycompany.practica2;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Cesion {
    private Moto moto;
    private Socio oldsocio, newsocio;
    
    
    public Cesion(Moto moto, Socio oldsocio, Socio newsocio){
        this.moto = moto;
        this.oldsocio = oldsocio;
        this.newsocio = newsocio;
    }
    
    public Moto getMoto(){
        return moto;
    }
    
    public Socio getOldSocio(){
        return oldsocio;
    }
    
    public Socio getNewSocio(){
        return newsocio;
    }
    
    public void printCesion(){
        System.out.println ("Moto cedida: ");
        moto.printMoto();
        System.out.println("Antiguo propietario: " + oldsocio.getNombreSocio());
        System.out.println("Nuevo propietario: " + newsocio.getNombreSocio());
    }
    
}
