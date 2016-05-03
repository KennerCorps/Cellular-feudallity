package Juego;

/**
 * Created by kenner on 03/05/2016.
 */
public class Juego {
    private Mundo mundo;
    private Jugador jugador;

    Juego(){
        mundo = new Mundo();
        jugador = new Jugador();
        jugador.radio = 0.1f;
    }

    public void renderizar(){
        Render.color(0.2f, 0.2f,0.5f);
        mundo.renderizar();
        Render.color(0.9f, 0.5f,0.5f);
        Render.celula(jugador);
    }

    public void mover(float x, float y){
        mundo.mover(x,y);
    }
}
