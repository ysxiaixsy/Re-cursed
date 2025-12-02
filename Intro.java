import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Intro {
    private ui.Window window;
    
    public Intro(ui.Window window) {
        this.window = window;
        show();
    }
    
    // display intro screen with layered background and ui images
    private void show() {
        // load background and ui images
        BufferedImage bgImage = loadImage("assets/backgrounds/title bg.png");
        BufferedImage uiImage = loadImage("assets/ui/title.png");
        
        // create panel with two layered images
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // draw background first, then ui on top
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, 1600, 900, null);
                }
                if (uiImage != null) {
                    g.drawImage(uiImage, 0, 0, 1600, 900, null);
                }
            }
        };
        imagePanel.setPreferredSize(new Dimension(1600, 900));
        imagePanel.setLayout(null);
        
        // clicking anywhere transitions to character selection
        imagePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new CharSelection(window);
            }
        });
        
        window.addComponent(imagePanel);
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
