import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.services.IGamePluginService;

module Enemy {
    requires Common;
    provides IGamePluginService with dk.cbse.jakob.enemysystem.EnemyPlugin;
    provides IEntityProcessingService with dk.cbse.jakob.enemysystem.EnemyProcessor;
}