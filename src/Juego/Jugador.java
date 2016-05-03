package Juego;



/**
 * Created by kenner on 02/05/2016.
 */
public class Jugador extends Celula{

    float velocidad = 10.f;

    void mover(float incX, float incY) {
        x += incX;
        y += incY;
    }
}
