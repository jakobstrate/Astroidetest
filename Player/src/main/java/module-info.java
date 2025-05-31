import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Player{
    requires Common;
    exports dk.cbse.jakob.Playersystem;
    requires CommonBullet;
    requires java.desktop;
    requires javafx.graphics;
    requires spring.context;
    uses dk.cbse.jakob.common.bullet.BulletSPI;
    provides IEntityProcessingService with dk.cbse.jakob.Playersystem.PlayerControlSystem;
    provides IGamePluginService with dk.cbse.jakob.Playersystem.PlayerPlugin;

}