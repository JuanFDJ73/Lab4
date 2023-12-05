/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaCrear extends JFrame {
    
     private JButton btnCrearD; 
    
   public PanelFondo jpFondoInicial;
    
     //Constructor
    public void VentanaCrear(){
        iniciarComponentes();
    }
    
    
     private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("Supermercado Univalle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        //setVisible(true); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
       
        btnCrearD = new JButton("Crear");
        btnCrearD.setFont(new Font("Arial", Font.BOLD, 15));
        btnCrearD.setBounds(230,250, 110,35);
        btnCrearD.setActionCommand("crear");
       
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
         jpFondoInicial.add(btnCrearD);
        
     }   

     public void iniciarVentanaCrear(){
             VentanaCrear crear = new VentanaCrear(); 
             crear.setVisible(true);
             dispose();

        }

}
   
    

