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
import javax.swing.JTextField;

public class VentanaUpdate2 extends JFrame {
    
        private JButton btnReturn;
        private JButton btnComplete;
        private JLabel jlTituloWc;
        private JTextField[] camposTexto;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaUpdate2(){
        iniciarComponentes();
    }
    
    
    private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("VentanaEliminar2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTituloWc = new JLabel("VentanaEliminar2",SwingConstants.CENTER );
        jlTituloWc.setBounds(150,40, 400,35);
        jlTituloWc.setForeground(Color.WHITE);
        jlTituloWc.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondoRojo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnReturn = new JButton("Return");
        btnReturn.setFont(new Font("Arial", Font.BOLD, 12));
        btnReturn.setBounds(205,360, 110,35);
        btnReturn.setActionCommand("Prueba1");
        
        btnComplete = new JButton("Complete");
        btnComplete.setFont(new Font("Arial", Font.BOLD, 12));
        btnComplete.setBounds(385,360, 110,35);
        btnComplete.setActionCommand("Prueba2");
        
        
        // Agregar etiquetas y campos de texto
        String[] nombresCampos = {"NombreProveedor", "RUT", "emailProveedor", "nombreProductoProveedor"};
        agregarLabelsYCamposTexto(nombresCampos);
        
        
        jpFondoInicial.add(btnReturn);
        jpFondoInicial.add(btnComplete);
        jpFondoInicial.add(jlTituloWc);

    }   

    
    private void agregarLabelsYCamposTexto(String[] nombresCampos) {
        int numCampos = nombresCampos.length;
        JLabel[] labels = new JLabel[numCampos];
        camposTexto = new JTextField[numCampos];

        for (int i = 0; i < numCampos; i++) {
            labels[i] = new JLabel(nombresCampos[i] + ":");
            labels[i].setFont(new Font("Arial", Font.PLAIN, 12));
            labels[i].setBounds(100, 100 + i * 40, 80, 25);
            camposTexto[i] = new JTextField();
            camposTexto[i].setBounds(200, 100 + i * 40, 150, 25);

            jpFondoInicial.add(labels[i]);
            jpFondoInicial.add(camposTexto[i]);
        }
    }
    
    
    
    public void iniciarVentanaCrear(){
             VentanaCrear crear = new VentanaCrear(); 
             crear.setVisible(true);
             dispose();

        }

}