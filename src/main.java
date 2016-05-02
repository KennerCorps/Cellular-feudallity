import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kenner on 30/04/2016.
 */
public class main{

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interfaz interfaz = new Interfaz();
                interfaz.createAndShowGUI();
            }
        });
    }

}
