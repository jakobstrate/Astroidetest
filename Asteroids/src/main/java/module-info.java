import dk.cbse.jakob.common.asteroids.IAsteroidSplitter;
import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    requires spring.context;
    requires CommonAsteroids;
    provides IGamePluginService with dk.cbse.jakob.asteroid.AsteroidPlugin;
    provides IEntityProcessingService with dk.cbse.jakob.asteroid.AsteroidProcessor;
    provides IAsteroidSplitter with dk.cbse.jakob.asteroid.AsteroidSplitterImpl;
}