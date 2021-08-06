import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Canvas implements Runnable, KeyListener {

    public static final int GAME_WIDTH = 800;

    public static final int GAME_HEIGHT = 450;

    private boolean running = false;

    private Thread thread;

    public Game() {
    }

    public static void main(String[] args) {
        new Window(GAME_WIDTH, GAME_HEIGHT, "Dino Game", new Game());
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
