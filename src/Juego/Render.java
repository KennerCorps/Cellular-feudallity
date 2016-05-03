package Juego;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by kenner on 02/05/2016.
 */
public final class Render {

    static float colorR = 1.f, colorG = 1.f, colorB = 1.f;

    public static void celula(Celula celula){
        DrawCircle(celula.x, celula.y, celula.radio, 32);
    }
    public static void celulaDesplazamiento(Celula celula, float x, float y){
        if(celula.interseccionCelulaRectangulo(-0.5f, -0.5f, 0.5f, 0.5f, x, y)){
            color(0,1,0);
            DrawCircle(celula.x + x, celula.y + y, celula.radio, 32);
        }
    }
    public static void color(float r,float g,float b){
        colorR = r;
        colorG = g;
        colorB = b;
    }

    private static void DrawCircle(float cx, float cy, float r, int num_segments) {
        float theta = (float) (2 * 3.1415926 / (float)num_segments);
        float tangetial_factor = (float)Math.tan(theta);//calculate the tangential factor

        float radial_factor = (float)Math.cos(theta);//calculate the radial factor

        float x = r;//we start at angle = 0

        float y = 0;

        glColor3f(colorR, colorG, colorB);
        glBegin(GL_POLYGON);
        for(int ii = 0; ii < num_segments; ii++){
            glVertex2f(x + cx, y + cy);//output vertex

            //calculate the tangential vector
            //remember, the radial vector is (x, y)
            //to get the tangential vector we flip those coordinates and negate one of them

            float tx = -y;
            float ty = x;

            //add the tangential vector

            x += tx * tangetial_factor;
            y += ty * tangetial_factor;

            //correct using the radial factor

            x *= radial_factor;
            y *= radial_factor;
        }
        glEnd();
    }

}
