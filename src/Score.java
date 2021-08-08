import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Score {

    int curScore = 0;

    int hiScore = 0;

    private Font font;

    private float fontSize = 12f;

    String fontPath = "assets/font.ttf";

    private long lastUpdate;

    public Score() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
        } catch (IOException | FontFormatException e) {
            System.out.println("Font failed to load.");
        }
    }

    public void tick() {
        if (System.currentTimeMillis() - lastUpdate > 100) {
            lastUpdate = System.currentTimeMillis();
            curScore += 1;
        }
    }

    public void render(Graphics g) {
        g.setFont(font);
        g.setColor(Color.gray);
        g.drawString("HI " + hiScore, 600, 50);
        g.setColor(Color.black);
        g.drawString(String.valueOf(curScore), 700, 50);
    }

    public void clear() {
        if (curScore > hiScore) {
            hiScore = curScore;
        }
        curScore = 0;
    }
}
