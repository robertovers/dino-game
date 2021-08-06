import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    public static BufferedImage loadImage(String imgPath) {
        try {
            return ImageIO.read(new File(imgPath));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        return null;
    }
}
