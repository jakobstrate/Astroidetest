import dk.cbse.jakob.common.bullet.BulletSPI;
import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Enemy {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IGamePluginService with dk.cbse.jakob.enemysystem.EnemyPlugin;
    provides IEntityProcessingService with dk.cbse.jakob.enemysystem.EnemyProcessor;

}