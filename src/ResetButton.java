import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class ResetButton extends GameObject {

    private Font font;

    public ResetButton() {
        super(380, 200);
        sprite = SpriteHandler.resetButton;
        font = SpriteHandler.loadFont(SpriteHandler.fontPath, 12f);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(), observer);
        g.setFont(font);
        g.drawString("GAME OVER", 340, 170);
    }
}