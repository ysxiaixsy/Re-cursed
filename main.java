
public class main {
    private static ui.Window window;
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Create window
            window = new ui.Window("Re-cursed");
            new Intro(window);
            // Make window visible
            window.setVisible(true);
        });
    }
}
