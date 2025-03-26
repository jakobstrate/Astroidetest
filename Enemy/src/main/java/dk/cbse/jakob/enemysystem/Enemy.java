package dk.cbse.jakob.enemysystem;

import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;

public class Enemy extends Entity {

    @Override
    public void onCollision(World world, GameData gameData) {
        EnemyPlugin addEnemy = new EnemyPlugin();
        world.addEntity(addEnemy.createEnemy(gameData));
    }


}
