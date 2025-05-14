package dk.cbse.jakob.collisionsystem;

import dk.cbse.jakob.common.asteroids.Asteroid;
import dk.cbse.jakob.common.asteroids.IAsteroidSplitter;
import dk.cbse.jakob.common.bullet.Bullet;
import dk.cbse.jakob.common.services.IPostEntityProcessingService;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import org.springframework.stereotype.Component;

import java.util.ServiceLoader;

@Component
public class CollisionDetector implements IPostEntityProcessingService{
    private final IAsteroidSplitter splitter = ServiceLoader.load(IAsteroidSplitter.class)
            .findFirst().orElseThrow(()-> new IllegalStateException("cant find splitter"));
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
                if (entity1.getClass().equals(Asteroid.class) && entity2.getClass().equals(Asteroid.class)){
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    if (entity1.getClass().equals(Asteroid.class) && entity2.getClass().equals(Bullet.class)){
                        world.removeEntity(entity2);
                        splitter.createSplitAsteroid(entity1,world);
                    }
                    if (entity1.getClass().equals(Bullet.class) && entity2.getClass().equals(Asteroid.class)){
                        world.removeEntity(entity1);
                        splitter.createSplitAsteroid(entity2,world);
                    }else {
                        world.removeEntity(entity1);
                        world.removeEntity(entity2);
                        entity1.onCollision(world, gameData);
                        entity2.onCollision(world, gameData);
                    }
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