import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener {

    public static final int GAME_WIDTH = 800;

    public static final int GAME_HEIGHT = 400;

    public static final int GROUND_HEIGHT = 250;

    private enum State {
        PLAYING,
        NOT_PLAYING,
        GAME_OVER
    }

    private boolean running = false;

    private Thread thread;

    private State state = State.NOT_PLAYING;

    private Player player;

    private ObstacleHandler obstacleHandler;

    private CloudHandler cloudHandler;

    private Score score;

    private ResetButton resetButton;

    public Game() {

        player = new Player();
        obstacleHandler = new ObstacleHandler();
        cloudHandler = new CloudHandler();
        score = new Score();
        resetButton = new ResetButton();

        addKeyListener(this);
    }

    public static void main(String[] args) {
        new GameWindow(GAME_WIDTH, GAME_HEIGHT, "Dino Game", new Game());
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
            obstacleHandler.tick();
            cloudHandler.tick();
            score.tick();
        }
        detectCollisions();
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

        cloudHandler.render(g, this);
        obstacleHandler.render(g, this);
        score.render(g);
        player.render(g, this);

        if (state == State.GAME_OVER) {
            resetButton.render(g, this);
        }

        g.dispose();
        bs.show();
    }

    private void detectCollisions() {
        for (Obstacle obstacle : obstacleHandler.getObstacles()) {
            if (player.getHitBox().intersects(obstacle.getHitBox())) {
                state = State.GAME_OVER;
                player.setSprite(SpriteHandler.deadDino);
                break;
            }
        }
    }

    private void reset() {
        player = new Player();
        obstacleHandler = new ObstacleHandler();
        cloudHandler = new CloudHandler();
        state = State.NOT_PLAYING;
        score.clear();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (state == State.NOT_PLAYING && (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP)) {
            state = State.PLAYING;
        } else if (state == State.PLAYING && (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP)) {
            player.jumpAction();
        } else if (state == State.GAME_OVER && (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP)) {
            reset();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
