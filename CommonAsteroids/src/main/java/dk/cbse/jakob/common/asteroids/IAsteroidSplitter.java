package dk.cbse.jakob.common.asteroids;

import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.World;

public interface IAsteroidSplitter {
    void createSplitAsteroid(Entity e, World w);
}
