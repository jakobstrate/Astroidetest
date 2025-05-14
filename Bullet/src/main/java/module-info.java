import dk.cbse.jakob.common.bullet.BulletSPI;
import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Bullet {
    requires spring.context;
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with dk.cbse.jakob.bulletsystem.BulletPlugin;
    provides BulletSPI with dk.cbse.jakob.bulletsystem.BulletControlSystem;
    provides IEntityProcessingService with dk.cbse.jakob.bulletsystem.BulletControlSystem;
}