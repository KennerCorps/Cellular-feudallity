import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kenner on 01/05/2016.
 */
public class Conexion {
    private final int PUERTO = 1151;
    private final String HOST = "localhost";
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket sc;
    protected DataOutputStream salidaServidor, salidaCliente;

    public Conexion(String tipo) throws IOException{
        if(tipo.equalsIgnoreCase("servidor")){
            ss = new ServerSocket(PUERTO);
            sc = new Socket();
        }else{
            sc = new Socket(HOST, PUERTO);
        }
    }
}
