package dk.cbse.jakob.enemysystem;
import java.util.Random;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import dk.cbse.jakob.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {
     int num_enemies = 4;

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i<num_enemies; i++) {
            Entity enemy = createEnemy(gameData);
            world.addEntity(enemy);
        }
    }


    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }


    public Entity createEnemy(GameData gameData) {
        Entity enemy = new Enemy();
        Random rnd = new Random();
        enemy.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemy.setX(rnd.nextInt(gameData.getDisplayWidth()));
        enemy.setY(rnd.nextInt(gameData.getDisplayHeight()));
        enemy.setRadius(8);
        enemy.setRotation(rnd.nextInt(360));
        return enemy;
    }

}
