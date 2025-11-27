package Entity.block;

import javafx.scene.image.Image;
import Entity.Entity;
import Graphics.Sprite;

import static GameRunner.RunBomberman.list_kill;
import static GameRunner.RunBomberman.block;

public class Brick extends Entity {

    public Brick(int x, int y, Image img) {     
        super(x, y, img);
    }

    private void checkHidden() { 
        for (Entity entity : block) {
            if (entity instanceof Brick)//Xem xem nó có phải gạch không
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4) { //Nếu là gạch và là ô nổ thì sẽ nổ gạch đi 
                    entity.setImg(Sprite.grass.getFxImage());
                }
        }
    }

    @Override
    public void update() {
        checkHidden();
    }
}