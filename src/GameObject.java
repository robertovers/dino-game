import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class GameObject {

    protected float x, y;

    protected float dx, dy;

    protected BufferedImage sprite;

    protected Rectangle hitBox;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
        x += dx;
        y += dy;
    };

    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight() * 2, sprite.getWidth() * 2, sprite.getHeight() * 2, observer);

        /*
        draw hit boxes:

        hitBox.setLocation((int) x, (int) y - image.getHeight() * 2);
        g.setColor(Color.BLUE);
        g.drawRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
        */
    }

    public void setSprite(String pathname) {
        this.sprite = Utils.loadImage(pathname);
    }

    public Rectangle getHitBox() {
        hitBox = new Rectangle(sprite.getWidth() * 2, sprite.getHeight() * 2);
        hitBox.setLocation((int) x, (int) y - sprite.getHeight() * 2);
        return hitBox;
    }

}
