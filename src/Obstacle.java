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
}
