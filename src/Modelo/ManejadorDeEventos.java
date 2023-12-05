/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ManejadorDeEventos implements ActionListener{
    
    VentanaUpdate nuevaVentanaUpdate = new VentanaUpdate();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (null != e.getActionCommand()) // Handle different buttons based on their action commands
        switch (e.getActionCommand()) {
            case "update" : { // Handle the update button click 
                System.out.println("Update button clicked");
                nuevaVentanaUpdate.iniciarVentanaUpdate();
                break;
            } 
            case "delete" : { // Handle the delete button click
                System.out.println("Delete button clicked");
                break;
            } 
            case "read" : { // Handle the read button click
                System.out.println("Read button clicked");
                break;
            }
            case "create" : { // Handle the create button click
                System.out.println("Create button clicked");
                break;
            } 
            default : {
                System.out.println("Default");
                break;
            } 
        }
    }
    
    
}
