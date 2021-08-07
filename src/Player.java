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
}
