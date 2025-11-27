package Entity.block;

import javafx.scene.image.Image;
import Entity.Entity;

public class Portal extends Entity {
    public static boolean is_portal = false; // Tạo cổng nếu ng chơi thắng

    public Portal(int x, int y, Image img) {      
        super(x, y, img);
    }

    @Override
    public void update() {

    }
}