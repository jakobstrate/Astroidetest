module Core {
    requires Common;
    requires CommonBullet;
    requires javafx.graphics;
    requires Player;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    exports dk.cbse.jakob.main;
    opens dk.cbse.jakob.main to javafx.graphics,spring.core;
    uses dk.cbse.jakob.common.services.IGamePluginService;
    uses dk.cbse.jakob.common.services.IEntityProcessingService;
    uses dk.cbse.jakob.common.services.IPostEntityProcessingService;
}