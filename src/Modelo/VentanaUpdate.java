/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Modelo.PanelFondo;
import Modelo.PanelFondo;
import Modelo.VentanaInicial;


/**
 *
 * @author w10
 */
public class VentanaUpdate extends JFrame{
    
    public PanelFondo jpFondoInicial;
    private JLabel jlNombre;
    private JLabel jlTitulo;
    private JTextField txtNombre;
    private JButton btnCrear; 
    private JButton btnUpdate;
    private JButton btnRead;
    private JButton btnDelete;
    
    //Método constructor
    public VentanaUpdate(){
        iniciarComponentes();
}
     private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("Supermercado Univalle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
       
        
    
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
     }   

     public void iniciarVentanaUpdate(){
             VentanaUpdate update = new VentanaUpdate(); 
             update.setVisible(true);
             dispose();
        }

}
   
