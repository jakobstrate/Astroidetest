package dk.cbse.jakob.enemysystem;

import java.util.Random;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import dk.cbse.jakob.common.services.IGamePluginService;
public class EnemyPlugin implements IGamePluginService {
    private Random random = new Random();

    @Override
    public void start(GameData gameData, World world) {
        Entity enemy = createEnemy(gameData);
        world.addEntity(enemy);
    }


    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }


    private Entity createEnemy(GameData gameData) {
        Entity enemy = new Enemy();
        Random rnd = new Random();
        enemy.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemy.setX(random.nextInt(gameData.getDisplayWidth()));
        enemy.setY(random.nextInt(gameData.getDisplayHeight()));
        enemy.setRadius(8);
        enemy.setRotation(rnd.nextInt(90));
        return enemy;
    }

}
