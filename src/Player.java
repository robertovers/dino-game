import java.awt.*;
import java.awt.image.ImageObserver;

public class Player extends GameObject {
   
    private boolean jumping = false;    

    public Player() {
        super(50, 250);
        setSpriteFromPath("assets/dino.png");
    }

    @Override
    public void tick() {
        x += dx;
        y += dy;
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight()*2, sprite.getWidth()*2, sprite.getHeight()*2, observer);
    }
}
