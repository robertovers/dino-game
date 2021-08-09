import java.awt.*;
import java.awt.image.ImageObserver;

public class Player extends GameObject {
   
    private boolean jumping = false;

    public Player() {
        super(50, 250);

        sprite = SpriteHandler.standingDino;
    }

    @Override
    public void tick() {
        if (jumping && y + dy > Game.GROUND_HEIGHT) {
            y = Game.GROUND_HEIGHT;
            dy = 0;
            jumping = false;
        } else if (jumping) {
            dy += 0.25f;
        }
        x += dx;
        y += dy;
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(), observer);
    }

    public void jumpAction() {
        if (!jumping) {
            jumping = true;
            dy = -7;
        }
    }
}
