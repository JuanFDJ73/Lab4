/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VentanaInicial;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class Principal {

    public static void main(String[] args) {
       
        VentanaInicial primeraVentana = new VentanaInicial();
      
    }
    
    
    /*static void crear(){
        String nombre = "src/texto.txt";
        File file = new File(nombre);
        FileWriter fw = null;   
        try {            
            fw = new FileWriter(file, false);         
            for (int i = 1; i < 30; i++) {
                fw.write("Hola : "  + i + "\n");
            }
            System.out.println("Archivo creado con éxito");          
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Mensaje : " + e.getMessage());
        } catch (IOException e){
            System.out.println("Mensaje : " + e.getMessage());
        }
    }
    */
}
