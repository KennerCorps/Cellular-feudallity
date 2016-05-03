package Juego;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;


/**
 * Created by kenner on 02/05/2016.
 */
public class VentanaJuego {

    private long window;
    private float mouseX, mouseY;
    private float ultimoMouseX, ultimoMouseY;
    private float centroX, centroY;
    float ratio;

    Juego juego;
    Jugador jugador;

    public void ejecutarJuego(){

        iniciarJuego();
        loop();

        Display.destroy();
    }

    public void iniciarJuego(){
        int ANCHO = 900;
        centroX = ANCHO /2;
        int ALTO  = 900;
        centroY = ALTO /2;
        ratio = ANCHO / ALTO;

        try{
            Display.setDisplayMode(new DisplayMode(ANCHO, ALTO));
            Display.create(new PixelFormat(0, 8, 0, 4));

        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glClearColor(0.98f, 0.98f, 0.98f, 1.f);

        juego = new Juego();
        jugador = new Jugador();
    }

    private void loop() {

        while(!Display.isCloseRequested()){
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            movimiento();

            render();

            Display.update();
        }
    }
    private void movimiento(){
        float mouseX = (float)Mouse.getX();
        float mouseY = (float)Mouse.getY();

        float incX = (mouseX - centroX) / 10000.f;
        float incY = (mouseY - centroY) / 10000.f;

        juego.mover(incX, incY);


    }

    private void render(){

        juego.renderizar();
    }

}
