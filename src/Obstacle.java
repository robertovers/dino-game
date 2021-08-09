import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle extends GameObject {
    
    public Obstacle() {
        super(Game.GAME_WIDTH, 250);

        sprite = SpriteHandler.getObstacleSprite();
    }

    @Override
    public void tick() {
        x += dx;
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(), observer);
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
