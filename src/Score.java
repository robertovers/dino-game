import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Score {

    int curScore = 0;

    int hiScore = 0;

    private Font font;

    private long lastUpdate;

    public Score() {
        font = SpriteHandler.loadFont(SpriteHandler.fontPath, 12f);
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
        g.drawString("HI " + pad(hiScore), 590, 50);
        g.setColor(Color.black);
        g.drawString(pad(curScore), 700, 50);
    }

    public void clear() {
        if (curScore > hiScore) {
            hiScore = curScore;
        }
        curScore = 0;
    }

    public String pad(int score) {
        StringBuilder string = new StringBuilder(String.valueOf(score));
        while (string.length() < 5) {
            string.insert(0, "0");
        }
        return string.toString();
    }
}
