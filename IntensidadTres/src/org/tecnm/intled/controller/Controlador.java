/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.tecnm.intled.controller;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.tecnm.intled.model.Modelo;
import org.tecnm.intled.view.Vista;
import panamahitek.Arduino.PanamaHitek_Arduino;

/**
 *
 * @author jacqu
 */
public class Controlador {
    
    private final Modelo model;
    private final Vista view;
    private final PanamaHitek_Arduino arduino;
    
    
    public Controlador(Modelo model, Vista view)
    {
        this.view = view;
        this.model = model;
        this.arduino = new PanamaHitek_Arduino();
        this.view.sliderIntensidad(e -> regularLed());
        this.view.botonEncender(e -> encenderLed());
        this.view.botonApagar(e -> apagarLed());
        iniciarConexion();
    }
    
    private void iniciarConexion(){
        
        try {
            arduino.arduinoTX("COM3", 9600);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void encenderLed()
    {
        model.setEncendido(true);
        enviarAccion("e");
    }
    private void apagarLed(){
        model.setEncendido(false);
        enviarAccion("a");
    }
    private void regularLed(){
        int intensidad = view.valorSlider();
        String salidaI = String.format("%03d", intensidad);//formatear a tres digitos
        /*if(intensidad<10){
            salidaI = salidaI + "00" + intensidad;
        } else if(intensidad < 100){
            salidaI = salidaI + "0" + intensidad;
        } else{
            salidaI = salidaI + intensidad;
        }*/
        model.setIntensidad(intensidad);
        enviarAccion("i");
        regularIntensidad(salidaI) ;
    }
    private void enviarAccion(String evento)
    {
        try {
            arduino.sendData(evento);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void regularIntensidad(String salidaI){
        try {
            arduino.sendData(salidaI + "\n");//enviar una nueva linea
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
