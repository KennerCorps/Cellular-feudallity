import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kenner on 01/05/2016.
 */
public class Cliente extends Conexion{
    public Cliente() throws IOException {super("cliente");}

    public void startClient(){ //Método para iniciar el cliente
        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            float array[] = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f , 6.6f ,7.7f};

            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            float position = 0.f;
            //Se enviarán dos mensajes
            for(int i = 0; i < 1000000; i++){
                position += 0.23423423411;
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Posicion: " + position + "\n");
                String respuesta = entrada.readLine();
                System.out.println(respuesta);
            }

            sc.close();//Fin de la conexión

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
