import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle extends GameObject {
   
    private ArrayList<String> spritePaths = new ArrayList<>();
    
    public Obstacle() {
        super(Game.GAME_WIDTH, 250);

        spritePaths.add("assets/cactus1.png");
        spritePaths.add("assets/cactus2.png");
        spritePaths.add("assets/cacti.png");

        setSpriteFromPath(spritePaths.get(new Random().nextInt(spritePaths.size())));
    }

    @Override
    public void tick() {
        x += dx;
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, (int) x, (int) y - sprite.getHeight()*2, sprite.getWidth()*2, sprite.getHeight()*2, observer);
    }
}
