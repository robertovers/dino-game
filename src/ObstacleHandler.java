import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class ObstacleHandler {

    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private Random random = new Random();

    private float dx = -3;
    private float ddx = -0.001f;
    private long lastObst;

    public void tick() {
        double rand = random.nextDouble();

        if (rand < 0.01 && System.currentTimeMillis() - lastObst > 700) {
            obstacles.add(new Obstacle());
            lastObst = System.currentTimeMillis();
        }

        for (Obstacle obstacle : obstacles) {
            obstacle.dx = dx;
            obstacle.tick();

            if (obstacle.x < -100) {
                obstacles.remove(obstacle);
                break;
            }
        }
        dx += ddx;
    }

    public void render(Graphics g, ImageObserver observer) {
        for (Obstacle obstacle : obstacles) {
            obstacle.render(g, observer);
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        return new ArrayList<>(obstacles);
    }
}
