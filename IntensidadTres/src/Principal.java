
import org.tecnm.intled.controller.Controlador;
import org.tecnm.intled.model.Modelo;
import org.tecnm.intled.view.Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jacqu
 */
public class Principal {
    public static void main (String[] args)
    {
        Vista view = new Vista();
        Modelo model = new Modelo();
        Controlador controller = new Controlador(model, view);
        
        view.setVisible(true);
    }
}
