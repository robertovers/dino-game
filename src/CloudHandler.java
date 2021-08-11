import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class CloudHandler {

    private ArrayList<Cloud> clouds = new ArrayList<>();

    private long lastCloud;

    private Random random = new Random();

    public void tick() {
        double rand = random.nextDouble();

        if (rand < 0.01 && System.currentTimeMillis() - lastCloud > 3000) {
            lastCloud = System.currentTimeMillis();
            clouds.add(new Cloud());
        }

        for (Cloud cloud : clouds) {
            cloud.tick();

            if (cloud.x < -50) {
                clouds.remove(cloud);
                break;
            }
        }
    }

    public void render(Graphics g, ImageObserver observer) {
        for (Cloud cloud : clouds) {
            cloud.render(g, observer);
        }
    }
}