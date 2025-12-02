import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameLoop {
    private ui.Window window;
    
    public GameLoop(ui.Window window) {
        this.window = window;
        show();
    }
    
    private void show() {
        window.getFrame().getContentPane().removeAll();
        window.getFrame().repaint();
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1600, 900));
        
        BufferedImage bgImage = loadImage("assets/backgrounds/dungeon unlit.png");
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, 1600, 900, null);
                }
            }
        };
        backgroundPanel.setBounds(0, 0, 1600, 900);
        backgroundPanel.setLayout(null);
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        
        int[] clickCount = {0};
        final JPanel whiteSquarePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 400, 400);
            }
        };
        whiteSquarePanel.setBounds(600, 250, 400, 400);
        whiteSquarePanel.setLayout(null);
        whiteSquarePanel.setOpaque(false);
        
        whiteSquarePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clickCount[0]++;
                if (clickCount[0] >= 10) {
                    layeredPane.remove(whiteSquarePanel);
                    
                    ui.Button nextButton = new ui.Button("next", 700, 400, 100, 50);
                    nextButton.addActionListener(event -> new GameLoop(window));
                    layeredPane.add(nextButton, Integer.valueOf(1));
                    layeredPane.repaint();
                }
            }
        });
        
        layeredPane.add(whiteSquarePanel, Integer.valueOf(1));
        
        window.addComponent(layeredPane);
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
