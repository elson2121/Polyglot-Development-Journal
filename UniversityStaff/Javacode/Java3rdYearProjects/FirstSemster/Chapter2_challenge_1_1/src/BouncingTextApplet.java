import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

// BouncingTextApplet is a deprecated technology exploration
public class BouncingTextApplet extends Applet implements Runnable {
    
    // Instance variables
    private Thread thread = null;
    private String nameText = "Samuel Diriba"; 
    private int xPos = 0; 
    private final int yPos = 50; 
    private final int step = 5; 
    private boolean running = false;
    
    // 1. init(): Set size and background, initialize text
    @Override
    public void init() {
        // Set the size of the applet window
        setSize(400, 100); 
        // Set the background color
        setBackground(Color.LIGHT_GRAY);
        // Note: nameText is already initialized above.
    }
    
    // 2. start(): Create and start a new thread
    @Override
    public void start() {
        if (thread == null) {
            // 'this' refers to the BouncingTextApplet instance, which implements Runnable
            thread = new Thread(this);
            running = true;
            thread.start();
        }
    }
    
    // 3. run() method: The thread's code for animation
    @Override
    public void run() {
        // High-level loop for the animation
        while (running) {
            
            // a. Update the x-coordinate of the text
            xPos += step;
            
            // b. If the text hits the right edge, reset its position
            // getWidth() gets the width of the applet window
            if (xPos > getWidth()) {
                xPos = -50; // Reset just off the left edge for a smoother loop
            }
            
            // c. Call repaint() to request the browser/appletviewer to redraw
            repaint();
            
            // d. Pause the animation
            try {
                // Wait for 100 milliseconds
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                // If the thread is interrupted, stop the loop
                running = false; 
            }
        }
    }

    // 4. paint(Graphics g): Draw the text
    @Override
    public void paint(Graphics g) {
        // Set the text color
        g.setColor(Color.BLUE);
        // Draw the text at the current xPos and constant yPos
        g.drawString(nameText, xPos, yPos);
    }
    
    // 5. stop(): Stop the thread
    @Override
    public void stop() {
        running = false; // Signal the run() loop to stop
        if (thread != null) {
            // Nullify the thread reference
            thread = null; 
        }
    }
}
