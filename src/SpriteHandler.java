import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SpriteHandler {

    private Font font;

    public static String fontPath =
            "assets/font.ttf";

    public static final BufferedImage standingDino =
            loadImage("assets/stand.png");

    public static final BufferedImage deadDino =
            loadImage("assets/dead.png");

    public static final BufferedImage[] obstacleSprites = {
            loadImage("assets/cactus1.png"),
            loadImage("assets/cactus2.png"),
            loadImage("assets/cactus3.png")
    };

    public static final BufferedImage cloud =
            loadImage("assets/cloud.png");

    public static final BufferedImage resetButton =
            loadImage("assets/resetbutton.png");

    public static BufferedImage loadImage(String imgPath) {
        try {
            return ImageIO.read(new File(imgPath));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        return null;
    }

    public static Font loadFont(String fontPath, float fontSize) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
        } catch (IOException | FontFormatException e) {
            System.out.println("Font failed to load.");
        }
        return null;
    }

    public static BufferedImage getObstacleSprite() {
        return obstacleSprites[new Random().nextInt(obstacleSprites.length)];
    }
}
