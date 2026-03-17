import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FmrJuego extends JFrame {
    private Dado dado1 =new Dado();
    private Dado dado2 =new Dado();
    private Random r = new Random();
    private JLabel lblDado1, lblDado2, lblLanzamiento, lblCenas;

    private int lanzamiento, cenas;



    // metodo constructor
    public FmrJuego() {
        setSize(500, 270);
        setTitle("JUGUEMOS A LOS DADOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        String archivoImagen = "imagenes/3.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(archivoImagen));

        lblDado1 = new JLabel(imgDado);
        lblDado1.setBounds(10, 40, imgDado.getIconWidth(), imgDado.getIconHeight());
        add(lblDado1);

        lblDado2 = new JLabel(imgDado);
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 40, imgDado.getIconWidth(), imgDado.getIconHeight());
        add(lblDado2);

        JLabel lblTituloLanzamiento = new JLabel("LANZAMIENTO");
        lblTituloLanzamiento.setBounds(30 + 2 * imgDado.getIconWidth(), 10, 110, 25);
        lblTituloLanzamiento.setHorizontalAlignment(JLabel.CENTER);
        add(lblTituloLanzamiento);

        lblLanzamiento = new JLabel("0");
        lblLanzamiento.setBounds(30 + 2 * imgDado.getIconWidth(), 45, 100, 100);
        lblLanzamiento.setFont(new Font("impact", Font.BOLD, 72));
        lblLanzamiento.setHorizontalAlignment(JLabel.RIGHT);
        lblLanzamiento.setBackground(new Color(0, 0, 0));
        lblLanzamiento.setForeground(new Color(0, 255, 0));
        lblLanzamiento.setOpaque(true);
        add(lblLanzamiento);

        JLabel lblTituloCenas = new JLabel("CENAS");
        lblTituloCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 10, 110, 25);
        lblTituloCenas.setHorizontalAlignment(JLabel.CENTER);
        add(lblTituloCenas);

        lblCenas = new JLabel("0");
        lblCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 45, 100, 100);
        lblCenas.setFont(new Font("impact", Font.BOLD, 72));
        lblCenas.setHorizontalAlignment(JLabel.RIGHT);
        lblCenas.setBackground(new Color(0, 0, 0));
        lblCenas.setForeground(new Color(0, 255, 0));
        lblCenas.setOpaque(true);
        add(lblCenas);

        JButton btnIniciar = new JButton("INICIAR");
        btnIniciar.setBounds(40, 80+imgDado.getIconHeight(), 150, 25);
        add(btnIniciar);

        JButton btnLanzar = new JButton("LANZAR");
        btnLanzar.setBounds(260, 80 +imgDado.getIconHeight(), 150, 25);
        add(btnLanzar);

        //crear los eventos
        btnIniciar.addActionListener(evt ->{
             iniciarLanzamientos();
        });        
        btnLanzar.addActionListener(evt ->{
             lanzarDados();
            });
    }
    private void iniciarLanzamientos() {
        lanzamiento = 0;
        lblLanzamiento.setText(String.valueOf(lanzamiento));

        cenas = 0;
        lblCenas.setText(String.valueOf(cenas));
        
    }    
    private void lanzarDados() {
        dado1.lanzar(r);
        dado2.lanzar(r);

        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        lanzamiento++;
        lblLanzamiento.setText(String.valueOf(lanzamiento));

        if(dado1.getNumero() + dado2.getNumero() >= 11){
            cenas++;
            lblCenas.setText(String.valueOf(cenas));

        }

    }
}
