import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameLoop {
    private ui.Window window;
    
    public GameLoop(ui.Window window) {
        this.window = window;
        show();
    }
    
    // displays the game loop screen with background and interactive white square
    private void show() {
        // clear previous components from window
        window.getFrame().getContentPane().removeAll();
        window.getFrame().repaint();
        
        // create layered pane to stack panels on top of each other
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1600, 900));
        
        // load and display background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("assets/backgrounds/dungeon unlit.png");
                bgImage.paintIcon(this, g, 0, 0);
            }
        };
        backgroundPanel.setBounds(0, 0, 1600, 900);
        backgroundPanel.setLayout(null);
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        
        // track clicks on white square
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
        
        // handle clicks on white square
        MouseAdapter whiteSquareListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clickCount[0]++;
                // when white square is clicked 10 times, remove it and show next button
                if (clickCount[0] >= 10) {
                    layeredPane.remove(whiteSquarePanel);
                    
                    // create next button to restart game loop
                    ui.Button nextButton = new ui.Button("next", 700, 400, 100, 50);
                    nextButton.addActionListener(event -> new GameLoop(window));
                    layeredPane.add(nextButton, Integer.valueOf(1));
                    layeredPane.repaint();
                }
            }
        };
        whiteSquarePanel.addMouseListener(whiteSquareListener);
        
        layeredPane.add(whiteSquarePanel, Integer.valueOf(1));
        
        window.addComponent(layeredPane);
        window.getFrame().revalidate();
    }
}
