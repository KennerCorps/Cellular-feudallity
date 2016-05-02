import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

/**
 * Created by kenner on 30/04/2016.
 */
public class Interfaz extends JFrame implements ActionListener{

    private JPanel panelInicio = null;
    private JButton button_servidor;
    private JButton button_partida;

    private JPanel panel_atras = null;
    private JButton button_atras;

    private JPanel panelServidor = null;
    private JTextField textField_nombreServidor;
    private JButton button_crearServidor;
    private String nombre_servidor;

    private JPanel panelCliente = null;
    private JTextField textField_ip;
    private JButton button_buscar;
    private String ip;


    private void cambiarPanel(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel, new FlowLayout());
        getContentPane().doLayout();
        update(getGraphics());
        setVisible(true);
    }
    private void anadirPanel(JPanel panel){
        getContentPane().add(panel, new FlowLayout());
        getContentPane().doLayout();
        update(getGraphics());
        setVisible(true);
    }

    private void panel_atras(){
        if(panel_atras == null){
            panel_atras = new JPanel();
            button_atras = new JButton("<- Incio");
            button_atras.addActionListener(this);

            panel_atras.add(button_atras);
        }
        anadirPanel(panel_atras);
    }
    private void panelServidor(){
        if(panelServidor == null){
            panelServidor = new JPanel();
            Border borde = BorderFactory.createEmptyBorder(60, 10, 10, 10);
            panelServidor.setBorder(borde);

            JLabel label_nombreServidor = new JLabel("Nombre del server:");
            textField_nombreServidor = new JTextField("", 30);
            button_crearServidor = new JButton("Crear");
            button_crearServidor.addActionListener(this);

            panelServidor.add(label_nombreServidor);
            panelServidor.add(textField_nombreServidor);
            panelServidor.add(button_crearServidor);
        }
        cambiarPanel(panelServidor);
        panel_atras();
    }

    private void panelCliente(){
        if(panelCliente == null){
            panelCliente = new JPanel();
            Border borde = BorderFactory.createEmptyBorder(60, 10, 10, 10);
            panelCliente.setBorder(borde);

            JLabel label_ip = new JLabel("IP del server :");
            textField_ip = new JTextField("", 15);
            button_buscar = new JButton("Buscar");
            button_buscar.addActionListener(this);

            panelCliente.add(label_ip);
            panelCliente.add(textField_ip);
            panelCliente.add(button_buscar);
        }
        cambiarPanel(panelCliente);
        panel_atras();
    }

    private void panelInicio(){
        if(panelInicio == null) {
            panelInicio = new JPanel();
            Border borde = BorderFactory.createEmptyBorder(60, 10, 10, 10);
            panelInicio.setBorder(borde);

            button_servidor = new JButton("Crear Servidor");
            button_partida = new JButton("Unirse a una partida");

            button_servidor.addActionListener(this);
            button_partida.addActionListener(this);

            panelInicio.add(button_servidor);
            panelInicio.add(button_partida);
        }
        cambiarPanel(panelInicio);
    }

    public void createAndShowGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("MACS!");

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            updateComponentTreeUI(this); updateComponentTreeUI(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        panelInicio();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        setLocation(centerPoint.x - 300, centerPoint.y - 100);
        this.setSize(600, 200);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button_servidor){
            panelServidor();
            /*
            Servidor servidor = null;
            try {
                servidor = new Servidor();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("Iniciando Servidor\n");
            servidor.startServer();
            */
        }
        else if(e.getSource() == button_partida){
            panelCliente();
            /*
            try {
                Cliente cliente = new Cliente(); //Se crea el cliente
                System.out.println("Iniciando cliente\n");
                cliente.startClient(); //Se inicia el cliente
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            */
        }
        else if(e.getSource() == button_crearServidor){
            nombre_servidor = textField_nombreServidor.getText();
            if(!nombre_servidor.isEmpty()){
                System.out.println(nombre_servidor);
                try {
                    Servidor server = new Servidor();
                    server.startServer();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else{
                System.out.println("Nombre vacio");
            }

        }
        else if(e.getSource() == button_buscar){
            ip = textField_ip.getText();

            if(ip.length() > 6){
                try {
                    Juego juego = new Juego();

                    cambiarPanel(juego);
                    juego.paint(getGraphics());

                    Cliente cliente = new Cliente();
                    cliente.startClient();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }
        else if(e.getSource() == button_atras){
            //System.out.println("Atrás");
            panelInicio();
        }
    }
}
