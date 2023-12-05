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
import javax.swing.event.AncestorListener;


public class VentanaUpdate extends JFrame{
    
    private JButton btnAct;
    private JLabel jlTitulo;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaUpdate(){
        iniciarComponentes();
}
     private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("Actualizar Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTitulo = new JLabel("Actualizar Datos",SwingConstants.CENTER );
        jlTitulo.setBounds(150,40, 400,35);
        jlTitulo.setForeground(Color.RED);
        jlTitulo.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnAct = new JButton("Actualizar");
        btnAct.setFont(new Font("Arial", Font.BOLD, 12));
        btnAct.setBounds(290,360, 110,35);
        btnAct.setActionCommand("create");
        
        jpFondoInicial.add(btnAct);
        jpFondoInicial.add(jlTitulo);
        
     }   

     public void iniciarVentanaUpdate(){
             VentanaUpdate update = new VentanaUpdate(); 
             update.setVisible(true);
             dispose();

        }

}
   
