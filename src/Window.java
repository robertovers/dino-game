import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int w, int h, String title, Game game) {
        game.setPreferredSize(new Dimension(w, h));

        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}
