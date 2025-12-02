
public class main {
    private static ui.Window window;
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // create window
            window = new ui.Window("Re-cursed");
            new Intro(window);
            // make window visible
            window.setVisible(true);
        });
    }
}
