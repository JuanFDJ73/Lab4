/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloCompra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Compra {

    
    public boolean comprar(String id, String quantity){
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/archivoProveedores"))) {
            
            String line;
            
            while ((line = br.readLine()) != null) {
                
                // Verificar si la línea comienza y termina con corchetes
                
                if (line.startsWith("[") && line.endsWith("]")) {
                
                    // Eliminar corchetes y espacios, luego dividir por comas
                    
                    String[] keyValuePairs = line.substring(1, line.length() - 1).split(", ");

                    // Buscar la cédula en los pares clave-valor
                    
                    for (String pair : keyValuePairs) {
                       
                        String[] keyValue = pair.split(": ");
                        
                        String[] keyValue1 = pair.split(", ");
                        
                        if (keyValue.length == 2 && keyValue[0].trim().equals("Identificacion") && keyValue[1].trim().equals(id)) {
                            
                            System.out.println(keyValue[0]);
                            
                            if (keyValue1.length == 4 && keyValue1[0].trim().equals("so")){
                                
                                System.out.println(":D");
                                System.out.println(keyValue1); // Imprime la línea que contiene la cédula
                                
                            }else {
                                
                                System.out.println("waaah");
                                
                            }
                            

                            return true; // Indica que se encontró la cédula
                        }
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Distribuidor no encontrado.");
            return false; // Indica que no se encontró la cédula
            
        }   catch (IOException e) {
                e.printStackTrace();
            }
            return false; // Manejo de excepciones
    }
    }
