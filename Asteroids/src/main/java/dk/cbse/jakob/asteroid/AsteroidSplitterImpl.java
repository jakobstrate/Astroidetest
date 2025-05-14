package dk.cbse.jakob.asteroid;

import dk.cbse.jakob.common.asteroids.Asteroid;
import dk.cbse.jakob.common.asteroids.IAsteroidSplitter;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.World;

import java.util.Random;


public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        if (e.getRadius()<= 5){
            world.removeEntity(e);
        }
        else {
            float newSize = e.getRadius()/2;
            for (int i = 0; i < 3; i++){
                Entity smallerAsteriod = new Asteroid();
                smallerAsteriod.setPolygonCoordinates(newSize, -newSize, -newSize, -newSize, -newSize, newSize, newSize, newSize);
                smallerAsteriod.setX(e.getX());
                smallerAsteriod.setY(e.getY());
                smallerAsteriod.setRadius(newSize);
                smallerAsteriod.setRotation(new Random().nextInt(360));
                world.addEntity(smallerAsteriod);
            }
            world.removeEntity(e);
        }
    }


}
