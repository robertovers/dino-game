import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Cloud extends GameObject {

    public Cloud() {
        super(Game.GAME_WIDTH, (new Random()).nextInt(150)+40);
        sprite = SpriteHandler.cloud;
        dx = -1;
    }

    @Override
    public void tick() {
        x += dx;
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(), observer);
    }
}
