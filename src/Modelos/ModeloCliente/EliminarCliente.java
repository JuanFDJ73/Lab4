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
    

    public boolean eliminarCliente(String id){
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/archovos/archivoClientes"))) {

        String line;
        ArrayList<String> clientList = new ArrayList<>();

        // Lee el archivo y almacena cada línea en el ArrayList
        while ((line = br.readLine()) != null) {
            clientList.add(line);
        }

        // Busca la cédula en el ArrayList
        for (int i = 0; i < clientList.size(); i++) {
            
            String clientData = clientList.get(i);
            String[] dataArray = clientData
                    .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                    .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[0].trim().equals("Identificación") && keyValue[1].trim().equals(id)) {
                        // Elimina el cliente del ArrayList
                        clientList.remove(i);

                        // Escribe el ArrayList actualizado en el archivo de texto
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/archivos/archivosClientes"))) {
                            
                            for (String updatedClient : clientList) {
                                writer.write(updatedClient);
                                writer.newLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Cliente eliminado:");
                            for (String entry : dataArray) {
                                
                                System.out.println("Datos del cliente: " + entry);


                            }
                            
                            this.nombreClienteEliminado = dataArray[0];
                            this.apellidoClienteEliminado = dataArray[1];
                            this.idClienteEliminado = dataArray[2];
                            this.emailClienteEliminado = dataArray[3];

                            return true; // Indica que se encontró la cédula y se eliminó el cliente
                        }
                    }
                }

                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    return false; // Indica que no se encontró la cédula
        }catch (IOException e) {
            e.printStackTrace();
        return false; // Manejo de excepciones
    }
}
}
