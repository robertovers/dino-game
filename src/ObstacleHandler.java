import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class ObstacleHandler {

    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    private Random random = new Random();

    private float dx = -3;

    private long lastObst;

    public ObstacleHandler() {
    }

    public void tick() {
        double rand = random.nextDouble();

        if (rand < 0.01 && System.currentTimeMillis() - lastObst > 500) {
            obstacles.add(new Obstacle());
            lastObst = System.currentTimeMillis();
        }

        for (Obstacle obstacle : obstacles) {
            obstacle.tick();

            if (obstacle.getHitBox().x < -50) {
                obstacles.remove(obstacle);
                break;
            }
        }

        setSpeed(dx);
    }

    public void render(Graphics g, ImageObserver observer) {
        for (Obstacle obstacle : obstacles) {
            obstacle.render(g, observer);
        }
    }

    public void clear() {
        obstacles.clear();
    }

    private void setSpeed(float dx) {
        for (Obstacle obstacle : obstacles) {
            obstacle.setDx(dx);
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        return new ArrayList<>(obstacles);
    }
}
