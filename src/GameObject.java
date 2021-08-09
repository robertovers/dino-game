import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class GameObject {

    protected float x, y;

    protected float dx, dy;

    protected BufferedImage sprite;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g, ImageObserver observer);

    public Rectangle getHitBox() {
        Rectangle hitBox = new Rectangle(sprite.getWidth(), sprite.getHeight());
        hitBox.setLocation((int) x, (int) y - sprite.getHeight());
        return hitBox;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

}
