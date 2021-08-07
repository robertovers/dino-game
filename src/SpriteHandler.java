import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SpriteHandler {

    public static final BufferedImage standingDino =
            loadImage("assets/stand.png");

    public static final BufferedImage deadDino =
            loadImage("assets/dead.png");

    public static final BufferedImage[] obstacleSprites = {
            loadImage("assets/cactus1.png"),
            loadImage("assets/cactus2.png"),
            loadImage("assets/cacti.png")
    };

    public static final BufferedImage cloud =
            loadImage("assets/cloud.png");

    public static BufferedImage loadImage(String imgPath) {
        try {
            return ImageIO.read(new File(imgPath));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        return null;
    }

    public static BufferedImage getObstacleSprite() {
        return obstacleSprites[new Random().nextInt(obstacleSprites.length)];
    }
}
