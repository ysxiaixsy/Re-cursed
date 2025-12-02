public class main {
    private static ui.Window window;
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            window = new ui.Window("Re:cursed", "assets/ui/skull.png");
            new Intro(window);
            window.setVisible(true);
        });
    }
}
