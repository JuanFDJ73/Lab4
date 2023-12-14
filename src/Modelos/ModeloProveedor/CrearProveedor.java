/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProveedor;

/**
 *
 * @author Usuario
 */
public class CrearProveedor {
    private String nombreProveedor;
    private String emailProveedor;
    private String RUT;
    
    public CrearProveedor(String nombreProveedor, String emailProveedor, String RUT) {
        this.nombreProveedor = nombreProveedor;
        this.emailProveedor = emailProveedor;
        this.RUT = RUT;
    }   
    
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombre(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    
    public String getRUT(){
        return RUT;
    }
    
    public void setRUT(String RUT){
        this.RUT = RUT;
    }
}
