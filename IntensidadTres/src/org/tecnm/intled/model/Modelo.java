/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.tecnm.intled.model;

import panamahitek.Arduino.PanamaHitek_Arduino;


/**
 *
 * @author jacqu
 */
public class Modelo {
    boolean encendido;
    int intensidad = 0;
    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    
    public boolean encender(){ //getter consulta
        return encendido;
    }
    public void setEncendido (boolean encendido) //setter establece
    {
        this.encendido = encendido;
    }
    
    public int obtenerIntensidad ()
    {
        return intensidad;
    }
    public void setIntensidad(int intensidad){
        this.intensidad = intensidad;
    }
    
}
