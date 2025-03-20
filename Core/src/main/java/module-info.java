module Core {
    requires Common;
    requires CommonBullet;
    requires javafx.graphics;
    opens dk.cbse.jakob.main to javafx.graphics;
    uses dk.cbse.jakob.common.services.IGamePluginService;
    uses dk.cbse.jakob.common.services.IEntityProcessingService;
    uses dk.cbse.jakob.common.services.IPostEntityProcessingService;
}