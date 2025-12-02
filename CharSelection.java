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
    
    private void show() {
        window.getFrame().getContentPane().removeAll();
        window.getFrame().repaint();
        
        BufferedImage bgImage = loadImage("assets/backgrounds/title bg.png");
        
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
        
        selectionPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                if (x < 800) {
                    System.out.println("left");
                } else {
                    System.out.println("right");
                }
                new GameLoop(window);
            }
        });
        
        window.addComponent(selectionPanel);
        window.getFrame().revalidate();
    }
    
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            return null;
        }
    }
}
