package dk.cbse.jakob.common.bullet;

import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;


public interface BulletSPI {
    Entity createBullet(Entity bullet, GameData gameData);
}
