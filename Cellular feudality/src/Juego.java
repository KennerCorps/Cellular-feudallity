import org.eclipse.swt.*;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import java.awt.*;

import static javafx.application.ConditionalFeature.SWT;


/**
 * Created by kenner on 02/05/2016.
 */
public class Juego implements GLEventListener{

    void runMain(Display display)
    {
        final Shell shell = new Shell(display);
        shell.setText("Q*bert 3D - OpenGL Exercise");
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;

        shell.setLayout(gridLayout);

        // this allows us to set particular properties for the GLCanvas
        GLCapabilities glCapabilities = new GLCapabilities();

        glCapabilities.setDoubleBuffered(true);
        glCapabilities.setHardwareAccelerated(true);

        // instantiate the canvas
        final GLCanvas canvas = new GLCanvas(glCapabilities);

        // we can't use the default Composite because using the AWT bridge
        // requires that it have the property of SWT.EMBEDDED
        Composite composite = new Composite(shell, SWT.EMBEDDED);
        GridData ld = new GridData(GridData.FILL_BOTH);
        composite.setLayoutData(ld);

        // set the internal layout so our canvas fills the whole control
        FillLayout clayout = new FillLayout();
        composite.setLayout(clayout);

        // create the special frame bridge to AWT
        java.awt.Frame glFrame = SWT_AWT.new_Frame(composite);
        // we need the listener so we get the GL events
        canvas.addGLEventListener(this);

        // finally, add our canvas as a child of the frame
        glFrame.add(canvas);

        // show it all
        shell.open();
        // the event loop.
        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
    }
    Ellipse2D circulo;

    public void paint(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;

        circulo.setFrameFromCenter(20f,50f, 50f, 80f);

        g2d.draw(circulo);
    }

}
