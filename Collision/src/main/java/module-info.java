import dk.cbse.jakob.common.services.IPostEntityProcessingService;
module Collision {
    requires Common;
    provides IPostEntityProcessingService with dk.cbse.jakob.collisionsystem.CollisionDetector;
}