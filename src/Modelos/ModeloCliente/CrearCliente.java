/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class CrearCliente {
    
    private String nombre;
    private String apellido;
    private String id;
    private String email;
    private List<String> productos = new ArrayList<>();
    File archivoClientes;

       
    String rutaArchivoClientes = "src/archivos/archivoClientes";
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getProductoss() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
    
    
     //Metodo para crear un archivo y establecerlo en una ruta especificada
    //------------------------------------------------------------------------------------------------
    public void crearArchivoTexto(){
        
        try{
            
            archivoClientes = new File(rutaArchivoClientes);
            
            if(!archivoClientes.exists()){
                
                archivoClientes.createNewFile();
                System.out.println("archivo creado, la ruta es: " + archivoClientes.getAbsolutePath());
            }
        }
        
        catch(IOException e){
            
            System.err.println("Error al crear o escribir archivo " + e.getMessage());
            
        }
    
    }
    
    //Metodo para agregar los datos de los clientes a una coleccion y al archivo de texto
   public void agregarColeccionClientes() {

        ArrayList<ArrayList<String>> principalClientArray = new ArrayList<>();
        ArrayList<String> ArrayDatosClientes = new ArrayList<>();
        

        ArrayDatosClientes.add(this.nombre);
        ArrayDatosClientes.add(this.apellido);
        ArrayDatosClientes.add(this.id);
        ArrayDatosClientes.add(this.email);
        ArrayDatosClientes.add("Productos: " +String.valueOf(productos));

        // Verificar si la cédula ya existe en el archivo
        if (esCedulaUnica(this.id)) {
            principalClientArray.add(ArrayDatosClientes);
            System.out.println("Los siguientes datos fueron guardados " + principalClientArray);

            // Escribir en el archivo solo si la cédula es única
            try {
                FileWriter fileWriter = new FileWriter(rutaArchivoClientes, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(String.valueOf(ArrayDatosClientes));
                bufferedWriter.newLine();  // Agregar una nueva línea para cada usuario
                bufferedWriter.close();
                JOptionPane.showMessageDialog(null,"Datos del cliente almacenados");

            } catch (IOException e) {
                System.err.println("Error al añadir texto al archivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null,"La cédula ya existe. No se puede agregar el usuario.");
        }
    }

    // Método para verificar si la cédula ya existe en el archivo
    private boolean esCedulaUnica(String cedula) {

        try (Scanner scanner = new Scanner(new File(rutaArchivoClientes))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Verificar si la línea está vacía antes de intentar procesarla
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Convertir la línea a una lista de Strings
                List<String> userData = Arrays.asList(line.substring(1, line.length() - 1).split(","));

                // Verificar si hay al menos 4 elementos en la lista antes de acceder a userData.get(3)
                if (userData.size() >= 4) {
                    String existingCedula = userData.get(2).trim(); // Obtener la cédula
                    if (existingCedula.equals(cedula)) {
                        return false; // Cédula duplicada
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Manejar la excepción si el archivo no existe (puede ser la primera vez que se ejecuta)
            System.err.println("El archivo no existe, se creará uno nuevo.");
        }
        return true; // Cédula única
    }
    
}
