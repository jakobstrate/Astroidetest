package dk.cbse.jakob.bulletsystem;

import dk.cbse.jakob.common.bullet.Bullet;
import dk.cbse.jakob.common.bullet.BulletSPI;
import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import dk.cbse.jakob.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {
        double screenWidth = gameData.getDisplayWidth();
        double screenHeight = gameData.getDisplayHeight();

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));

            bullet.setX(bullet.getX() + changeX * 4);
            bullet.setY(bullet.getY() + changeY * 4);

            // Check if bullet is outside the view
            if (bullet.getX() < 0 || bullet.getX() > screenWidth ||
                    bullet.getY() < 0 || bullet.getY() > screenHeight) {
                world.removeEntity(bullet);
            }
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

        double changeX = Math.cos(Math.toRadians(shooter.getRotation()));
        double changeY = Math.sin(Math.toRadians(shooter.getRotation()));

        bullet.setX(shooter.getX() + changeX * 12);
        bullet.setY(shooter.getY() + changeY * 12);
        bullet.setRotation(shooter.getRotation());
        bullet.setRadius(1);

        return bullet;
    }
}