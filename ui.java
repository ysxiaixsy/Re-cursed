import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ui {
    
    public static class Panel extends JPanel {
        private int width;
        private int height;
        
        public Panel(int width, int height) {
            this.width = width;
            this.height = height;
            setPreferredSize(new Dimension(width, height));
            setLayout(null);
        }
        
        public void addComponent(JComponent component) {
            add(component);
        }
        
        public int getPanelWidth() {
            return width;
        }
        
        public int getPanelHeight() {
            return height;
        }
    }
    
    public static class Window {
        private static final int WINDOW_WIDTH = 1600;
        private static final int WINDOW_HEIGHT = 900;
        
        private JFrame frame;
        
        public Window(String title, String iconPath) {
            initializeWindow(title, iconPath);
        }
        
        private void initializeWindow(String title, String iconPath) {
            frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            
            try {
                frame.setIconImage(ImageIO.read(new File(iconPath)));
            } catch (Exception e) {
                System.err.println("Error loading window icon, " + e.getMessage());
            }
        }
        
        public void setVisible(boolean visible) {
            frame.setVisible(visible);
        }
        
        public JFrame getFrame() {
            return frame;
        }
        
        public void addComponent(JComponent component) {
            frame.add(component);
        }
    }
    
    public static class Button extends JButton {
        private int x;
        private int y;
        private int width;
        private int height;
        
        public Button(String text, int x, int y, int width, int height) {
            super(text);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            
            setBounds(x, y, width, height);
            setLayout(null);
        }
        
        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
            setBounds(x, y, width, height);
        }
        
        public void setSize(int width, int height) {
            this.width = width;
            this.height = height;
            setBounds(x, y, width, height);
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getWidth() {
            return width;
        }
        
        public int getHeight() {
            return height;
        }
    }
}
