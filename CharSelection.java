import java.awt.*;
import java.awt.event.*;
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
        
        // create panel with background image
        JPanel selectionPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("assets/backgrounds/title bg.png");
                bgImage.paintIcon(this, g, 0, 0);
            }
        };
        selectionPanel.setPreferredSize(new Dimension(1600, 900));
        selectionPanel.setLayout(null);
        
        // handle left and right side clicks
        MouseAdapter selectionListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                System.out.println(x < 800 ? "left" : "right");
                new GameLoop(window);
            }
        };
        selectionPanel.addMouseListener(selectionListener);
        
        window.addComponent(selectionPanel);
        window.getFrame().revalidate();
    }
}
