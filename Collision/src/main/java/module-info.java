import dk.cbse.jakob.common.services.IPostEntityProcessingService;
module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonBullet;
    requires spring.context;
    provides IPostEntityProcessingService with dk.cbse.jakob.collisionsystem.CollisionDetector;
    uses dk.cbse.jakob.common.asteroids.IAsteroidSplitter;
}