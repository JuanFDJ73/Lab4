/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaCrear extends JFrame {
    
        private JButton btnCreate;
        private JLabel jlTituloWc;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaCrear(){
        iniciarComponentes();
}
     private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("Crear Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTituloWc = new JLabel("Crear Datos",SwingConstants.CENTER );
        jlTituloWc.setBounds(150,40, 400,35);
        jlTituloWc.setForeground(Color.WHITE);
        jlTituloWc.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondoRojo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnCreate = new JButton("Crear");
        btnCreate.setFont(new Font("Arial", Font.BOLD, 12));
        btnCreate.setBounds(295,360, 110,35);
        btnCreate.setActionCommand("create");
         
        jpFondoInicial.add(btnCreate);
        jpFondoInicial.add(jlTituloWc);

     }   

     public void iniciarVentanaCrear(){
             VentanaCrear crear = new VentanaCrear(); 
             crear.setVisible(true);
             dispose();

        }

}
   
    

