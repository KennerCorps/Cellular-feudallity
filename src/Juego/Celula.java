package Juego;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/**
 * Created by kenner on 03/05/2016.
 */
public class Celula {
    float x = 0, y = 0;
    float radio;
    float area = 1;

    Celula(){
        radio = 0.05f;
    }

    public void setPosicion(float inx, float iny){
        x = inx;
        y = iny;
    }
    void calcularRadio(){
        radio = (float)sqrt(area / PI);
    }
    boolean interseccionCelulaRectangulo(float siX, float siY, float idX, float idY, float x, float y){
        siX += x; idX += x;
        siY += y; idY += y;
        if(x + radio >= siX && x - radio <= idX && y - radio <= idY && y + radio >= siY){
            return true;
        }
        return false;
    }
}
