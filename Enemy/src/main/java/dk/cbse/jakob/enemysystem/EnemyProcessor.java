package dk.cbse.jakob.enemysystem;

import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;

public class EnemyProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {


        for (Entity enemy : world.getEntities(Enemy.class)) {
            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));

            enemy.setX(enemy.getX() + changeX * 1);
            enemy.setY(enemy.getY() + changeY * 1);

            if (enemy.getX() < 0) {
                enemy.setX(enemy.getX() - gameData.getDisplayWidth());
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(enemy.getX() % gameData.getDisplayWidth());
            }

            if (enemy.getY() < 0) {
                enemy.setY(enemy.getY() - gameData.getDisplayHeight());
            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(enemy.getY() % gameData.getDisplayHeight());
            }

        }

    }
}
