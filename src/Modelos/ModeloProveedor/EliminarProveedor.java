/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProveedor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class EliminarProveedor {
    private String nombreProveedorEliminado;
    private String emailProveedorEliminado;
    private String RUTEliminado;
        
    String rutaArchivoProveedores = "src/archivos/archivoProveedores"; 
    
    public String getNombreProveedor() {
        return nombreProveedorEliminado;
    }

    public void setNombre(String nombreProveedorEliminado) {
        this.nombreProveedorEliminado = nombreProveedorEliminado;
    }

    public String getEmailProveedor() {
        return emailProveedorEliminado;
    }

    public void setEmailProveedor(String emailProveedorEliminado) {
        this.emailProveedorEliminado = emailProveedorEliminado;
    }
    
    public String getRUT(){
        return RUTEliminado;
    }
    
    public void setRUT(String RUTEliminado){
        this.RUTEliminado = RUTEliminado;
    }
    
    public String getRutaArchivoProveedores() {
        return rutaArchivoProveedores;
    }

    public void setRutaArchivoProveedores(String rutaArchivoProveedores) {
        this.rutaArchivoProveedores = rutaArchivoProveedores;
    }

    public boolean eliminarProveedor(String RUT) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/archivoProveedores"))) {

            String line;
            ArrayList<String> dealerList = new ArrayList<>();

            // Lee el archivo y almacena cada línea en el ArrayList
            while ((line = br.readLine()) != null) {
                dealerList.add(line);
            }

            // Usar un iterador para recorrer la lista y eliminar elementos de manera segura
            Iterator<String> iterator = dealerList.iterator();
            while (iterator.hasNext()) {
                String dealerData = iterator.next();
                String[] dataArray = dealerData
                        .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                        .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[1].trim().equals(RUT)) {
                        // Elimina el proveedor usando el iterador
                        int result = JOptionPane.showConfirmDialog(null, "Se eliminaran los datos del usuario, ¿Está de acuerdo?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                           iterator.remove(); 
                        }else {
                            break;
                        }

                        // Escribe el ArrayList actualizado en el archivo de texto
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/textFiles/dealersData"))) {
                            for (String updatedDealer : dealerList) {
                                writer.write(updatedDealer);
                                writer.newLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return true; // Indica que se encontró la cédula y se eliminó el proveedor
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
            return false; // Indica que no se encontró la cédula
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo de excepciones
        }
    }
}
