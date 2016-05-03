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
