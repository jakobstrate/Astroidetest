package dk.cbse.jakob.asteroid;

import dk.cbse.jakob.common.asteroids.Asteroid;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import dk.cbse.jakob.common.services.IGamePluginService;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    int num_asteroids = 4;

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < num_asteroids; i++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }

    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();
        Random rnd = new Random();
        int size = rnd.nextInt(10);
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        asteroid.setX(rnd.nextInt(gameData.getDisplayWidth()));
        asteroid.setY(rnd.nextInt(gameData.getDisplayHeight()));
        asteroid.setRadius(size);
        asteroid.setRotation(rnd.nextInt(90));
        return asteroid;
    }
}