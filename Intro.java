import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Intro {
    private ui.Window window;
    
    public Intro(ui.Window window) {
        this.window = window;
        show();
    }
    
    // display intro screen with layered background and ui images
    private void show() {
        // create panel with two layered images
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // draw background first, then ui on top
                ImageIcon bgImage = new ImageIcon("assets/backgrounds/title bg.png");
                ImageIcon uiImage = new ImageIcon("assets/ui/title.png");
                
                bgImage.paintIcon(this, g, 0, 0);
                uiImage.paintIcon(this, g, 0, 0);
            }
        };
        imagePanel.setPreferredSize(new Dimension(1600, 900));
        imagePanel.setLayout(null);
        
        // clicking anywhere transitions to character selection
        MouseAdapter introListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new CharSelection(window);
            }
        };
        imagePanel.addMouseListener(introListener);
        
        window.addComponent(imagePanel);
    }
}
