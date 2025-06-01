package dk.cbse.jakob.enemysystem;

import dk.cbse.jakob.common.bullet.BulletSPI;
import dk.cbse.jakob.common.services.IEntityProcessingService;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;
@Component  
public class EnemyProcessor implements IEntityProcessingService {
    private double random;
    @Override
    public void process(GameData gameData, World world) {
        random = Math.random();

        for (Entity enemy : world.getEntities(Enemy.class)) {
            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));

            enemy.setX(enemy.getX() + changeX * 1);
            enemy.setY(enemy.getY() + changeY * 1);

            if (enemy.getX() < 0) {
                enemy.setX(enemy.getX() + gameData.getDisplayWidth());
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(enemy.getX() % gameData.getDisplayWidth());
            }

            if (enemy.getY() < 0) {
                enemy.setY(enemy.getY() + gameData.getDisplayHeight());

            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(enemy.getY() % gameData.getDisplayHeight());

            }
            if (random < 0.06)
            getBulletSPIs().stream().findFirst().ifPresent(
                    spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
            );

        }

    }
    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
