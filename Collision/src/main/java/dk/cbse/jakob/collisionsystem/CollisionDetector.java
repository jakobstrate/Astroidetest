package dk.cbse.jakob.collisionsystem;

import dk.cbse.jakob.common.services.IPostEntityProcessingService;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;


public class CollisionDetector implements IPostEntityProcessingService{
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    world.removeEntity(entity1);
                    world.removeEntity(entity2);
                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

}