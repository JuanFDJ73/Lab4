/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloCliente;
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
public class EliminarCliente {
    
    String rutaArchivoClientes = "src/archivos/archivoClientes";
    
    private String nombreClienteEliminado;
    private String apellidoClienteEliminado;
    private String idClienteEliminado;
    private String emailClienteEliminado;

    public String getNombreClienteEliminado() {
        return nombreClienteEliminado;
    }

    public void setNombreClienteEliminado(String nombreClienteEliminado) {
        this.nombreClienteEliminado = nombreClienteEliminado;
    }

    public String getApellidoClienteEliminado() {
        return apellidoClienteEliminado;
    }

    public void setApellidoClienteEliminado(String apellidoClienteEliminado) {
        this.apellidoClienteEliminado = apellidoClienteEliminado;
    }

    public String getIdClienteEliminado() {
        return idClienteEliminado;
    }

    public void setIdClienteEliminado(String idClienteEliminado) {
        this.idClienteEliminado = idClienteEliminado;
    }

    public String getEmailClienteEliminado() {
        return emailClienteEliminado;
    }

    public void setEmailClienteEliminado(String emailClienteEliminado) {
        this.emailClienteEliminado = emailClienteEliminado;
    }

    public String getRutaArchivoClientes() {
        return rutaArchivoClientes;
    }

    public void setRutaArchivoClientes(String rutaArchivoClientes) {
        this.rutaArchivoClientes = rutaArchivoClientes;
    }
    

    public boolean deleteDealer(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/archivoClientes"))) {

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
                    if (keyValue[1].trim().equals(id)) {
                        // Elimina el proveedor usando el iterador
                        int result = JOptionPane.showConfirmDialog(null, "Se eliminaran los datos del cliente, ¿Está de acuerdo?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
