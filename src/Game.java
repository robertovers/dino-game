import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    public static final int GAME_WIDTH = 800;

    public static final int GAME_HEIGHT = 450;

    public static final int GROUND_HEIGHT = 250;

    private boolean running = false;

    private Thread thread;

    private enum State {
        PLAYING,
        MENU,
        END
    }

    private State state = State.MENU;

    private Player player;

    public Game() {
        player = new Player();
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
        long lastTime = System.nanoTime();
        double amountOfTicks = 100.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("fps: " + frames + " ticks: " + updates);
                frames = 0;
                updates = 0;
            }
        }    
    }

    private void tick() {
        if (state == State.PLAYING) {
            player.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.white);
        g.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        g.setColor(Color.black);
        g.drawLine(0, GROUND_HEIGHT, GAME_WIDTH, GROUND_HEIGHT);

        player.render(g, this);

        g.dispose();
        bs.show();
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
