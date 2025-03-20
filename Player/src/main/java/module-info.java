import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Player{
    requires Common;
    requires CommonBullet;
    uses dk.cbse.jakob.common.bullet.BulletSPI;
    provides IGamePluginService with dk.cbse.jakob.Playersystem.PlayerPlugin;
    provides IEntityProcessingService with dk.cbse.jakob.Playersystem.PlayerControlSystem;
}