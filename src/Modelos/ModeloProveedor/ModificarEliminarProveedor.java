/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProveedor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ModificarEliminarProveedor {
    private String nombreProveedorModificar;
    private String emailProveedorModificar;
    private String RUTModificar;
    private String nombreProductoProveedorModificar;
    
    File archivoProveedores;
    
    String rutaArchivoProveedores = "src/archivos/archivoProveedores"; 
    
    public String getNombreProveedorModificar() {
        return nombreProveedorModificar;
    }

    public void setNombreProveedorModificar(String nombreProveedorModificar) {
        this.nombreProveedorModificar = nombreProveedorModificar;
    }

    public String getEmailProveedor() {
        return emailProveedorModificar;
    }

    public void setEmailProveedor(String emailProveedorModificar) {
        this.emailProveedorModificar = emailProveedorModificar;
    }
    
    public String getRUTModificar(){
        return RUTModificar;
    }
    
    public void setRUTModificar(String RUTModificar){
        this.RUTModificar = RUTModificar;
    }
    
    public String getRutaArchivoProveedores() {
        return rutaArchivoProveedores;
    }

    public void setRutaArchivoProveedores(String rutaArchivoProveedores) {
        this.rutaArchivoProveedores = rutaArchivoProveedores;
    }
    
    public boolean actualizarProveedor(String RUTModificar) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProveedores))) {

            String line;
            ArrayList<String> updatedClientList = new ArrayList<>();
            boolean clientFound = false;

            while ((line = br.readLine()) != null) {
                String[] dataArray = line
                        .replaceAll("[\\[\\]]", "")
                        .split(", ");

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");

                    if (keyValue[0].trim().equals("Identificación") && keyValue[1].trim().equals(RUTModificar)) {
                        dataArray[0] = "Nombre: " + nombreProveedorModificar;
                        dataArray[1] = "RUT: " + RUTModificar;
                        dataArray[3] = "email: " + emailProveedorModificar;
                        clientFound = true;
                    }
                }

                updatedClientList.add(String.join(", ", dataArray));
            }

            if (clientFound) {
                // Escribe la lista actualizada en el archivo de texto
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoProveedores))) {
                    for (String updatedClient : updatedClientList) {
                        writer.write(updatedClient);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false; // Manejo de excepciones al escribir en el archivo
                }

                System.out.println("Cliente actualizado:");
                for (String entry : updatedClientList) {
                    System.out.println("Datos del cliente: " + entry);
                }

                return true; // Indica que se encontró la cédula y se actualizó el cliente
            } else {
                System.out.println("Cliente no encontrado.");
                return false; // Indica que no se encontró la cédula
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo de excepciones al leer el archivo
        }
    }
    
    public boolean eliminarProveedor(String RUTModificar) {
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
                    if (keyValue[1].trim().equals(RUTModificar)) {
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
