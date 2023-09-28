/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program1;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author Stephanie Pocci
 */
public class Program1 {

    /**
     * @param args the command line arguments
     */
    
    
    public void start() {
        try {
            createWindow();
            initGL();
            render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initGL() { // initialization
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 0, 480, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
    
    public void drawCircle (int centerX, int centerY, int radius) {
        glBegin(GL_LINE_LOOP);
        glColor3f(0f,0f,1.0f); // set color blue for circle
        int segments = 36;
        for (int i=0; i < segments; i++){
            double theta = 2 * Math.PI * i / segments;
            int x = (int) (centerX + radius * Math.cos(theta));
            int y = (int) (centerY + radius * Math.sin(theta));
            glVertex2f(x,y);
        }
        glEnd();
    }
    
    public void drawEllipse (int centerX, int centerY, int radiusX, int radiusY) {
        glBegin(GL_LINE_LOOP);
        glColor3f(0f,1f,0f); // green for ellipses
        int segments = 36;
        double deltaTheta = 2 * Math.PI / segments;
        for (int i=0; i < segments; i++) {
            double theta = i * deltaTheta;
            int x = (int) (centerX + radiusX * Math.cos(theta));
            int y = (int) (centerY + radiusY * Math.sin(theta));
            glVertex2f(x,y);
        }
        glEnd();
    }
    
    private void render() { // this is the loop
        try {
            Keyboard.create();
        } catch (Exception e) {}
        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_Q)) {
            // quits the program if Q is pressed
            try {
                glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
                glLoadIdentity();
                // glPointSize(10);
                
                /*glBegin(GL_POINTS);
                glColor3f(1.0f, 1.0f, 0.0f);
                glVertex2f(350.0f, 150.0f);
                glVertex2f(50.0f, 50.0f);
                glEnd();*/
                
                glBegin(GL_LINES);
                glColor3f(1f,0f,0f); // set line color red
                glVertex2f(10,380);
                glVertex2f(380,10);
                
                glVertex2f(350,50);
                glVertex2f(500,70);
                glEnd();
                
                drawCircle(50, 50, 100);
                drawCircle(320, 100, 54);
                
                drawEllipse(100, 100, 45, 80);
                drawEllipse(450, 250, 75, 35);
                
                //glBegin(GL_CIRCLE);
                //glEnd();
                
                Display.update();
                Display.sync(60);
                
            } catch (Exception e) {}
        }
        Display.destroy();
        Keyboard.destroy();
    }
    private void createWindow() throws Exception { // creates display
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(640,480));
        Display.setTitle("OpenGL is pog");
        Display.create();
    }
    
    
    public static void main(String[] args) {
        Program1 program1 = new Program1();
        program1.start();
    }
    
}
