package dk.cbse.jakob.asteroid;

import dk.cbse.jakob.common.asteroids.Asteroid;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import dk.cbse.jakob.common.services.IGamePluginService;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class AsteroidPlugin implements IGamePluginService {
    int num_asteroids = 10;

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
        int size = rnd.nextInt(5,20);
        asteroid.setPolygonCoordinates(0, 14, 18, 0, 37, 14, 30, 37, 7, 37);
        asteroid.setX(rnd.nextInt(gameData.getDisplayWidth()));
        asteroid.setY(rnd.nextInt(gameData.getDisplayHeight()));
        asteroid.setRadius(size);
        asteroid.setRotation(rnd.nextInt(360));
        return asteroid;
    }
}