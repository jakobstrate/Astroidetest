import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    requires CommonAsteroids;
    provides IGamePluginService with dk.cbse.jakob.asteroid.AsteroidPlugin;
    provides IEntityProcessingService with dk.cbse.jakob.asteroid.AsteroidProcessor;
}