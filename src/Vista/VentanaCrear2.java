package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrear2 extends JFrame {
    
        private JButton btnPrueba1;
        private JButton btnPrueba2;
        private JLabel jlTituloWc;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaCrear2(){
        iniciarComponentes();
    }
    
    
    private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("VentanaCrear2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTituloWc = new JLabel("VentanaCrear2",SwingConstants.CENTER );
        jlTituloWc.setBounds(150,40, 400,35);
        jlTituloWc.setForeground(Color.WHITE);
        jlTituloWc.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondoRojo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnPrueba1 = new JButton("Boton1");
        btnPrueba1.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrueba1.setBounds(205,360, 110,35);
        btnPrueba1.setActionCommand("Prueba1");
        
        btnPrueba2 = new JButton("Boton2");
        btnPrueba2.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrueba2.setBounds(385,360, 110,35);
        btnPrueba2.setActionCommand("Prueba2");
         
        jpFondoInicial.add(btnPrueba1);
        jpFondoInicial.add(btnPrueba2);
        jpFondoInicial.add(jlTituloWc);

     }   

     public void iniciarVentanaCrear(){
             VentanaCrear crear = new VentanaCrear(); 
             crear.setVisible(true);
             dispose();

        }

}