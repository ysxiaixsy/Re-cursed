import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CharSelection {
    private ui.Window window;
    
    public CharSelection(ui.Window window) {
        this.window = window;
        show();
    }
    
    // display character selection screen where player picks left or right
    private void show() {
        // clear previous components from window
        window.getFrame().getContentPane().removeAll();
        window.getFrame().repaint();
        
        // load background image
        BufferedImage bgImage = loadImage("assets/backgrounds/title bg.png");
        
        // create panel with background image
        JPanel selectionPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, 1600, 900, null);
                }
            }
        };
        selectionPanel.setPreferredSize(new Dimension(1600, 900));
        selectionPanel.setLayout(null);
        
        // handle left and right side clicks
        MouseAdapter selectionListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                // left side is x less than 800
                if (x < 800) {
                    System.out.println("left");
                } else {
                    System.out.println("right");
                }
                // transition to game loop screen
                new GameLoop(window);
            }
        };
        selectionPanel.addMouseListener(selectionListener);
        
        window.addComponent(selectionPanel);
        window.getFrame().revalidate();
    }
    
    // load image from file path
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            return null;
        }
    }
}
