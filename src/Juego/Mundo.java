package Juego;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kenner on 03/05/2016.
 */
public class Mundo {
    float posX = 0.f, posY = 0.f;
    ArrayList<Jugador> jugadores = new ArrayList<>();
    ArrayList<Comida> comidas = new ArrayList<>();

    Mundo(){
        sembrarComidas();
    }

    public void anadir(Jugador jugador){
        jugadores.add(jugador);
    }
    public void sembrarComidas(){
        Random random = new Random();
        for(int i = 0; i < 10000; i++){
            Comida comida = new Comida();
            comida.setPosicion(random.nextFloat() * 100, random.nextFloat() * 100);
            comidas.add(comida);
        }
    }
    public void mover(float x, float y){
        posX -= x;
        posY -= y;
    }
    public void renderizar(){
        for(int i = 0; i < comidas.size(); i++){
            Render.celulaDesplazamiento(comidas.get(i), posX, posY);
        }
        for(int i = 0; i < jugadores.size(); i++){
            Render.celulaDesplazamiento(jugadores.get(i), posX, posY);
        }

    }

}
