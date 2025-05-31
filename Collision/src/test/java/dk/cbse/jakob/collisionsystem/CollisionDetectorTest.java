package dk.cbse.jakob.collisionsystem;

import dk.cbse.jakob.common.asteroids.IAsteroidSplitter;
import dk.cbse.jakob.common.data.Entity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CollisionDetectorTest {

    private CollisionDetector collisionDetector;

    @Before
    public void setUp() {
        IAsteroidSplitter mockSplitter = mock(IAsteroidSplitter.class);
        collisionDetector = new CollisionDetector(mockSplitter);
    }

    @Test
    public void testEntitiesCollide() {
        Entity e1 = new Entity();
        e1.setX(0);
        e1.setY(0);
        e1.setRadius(5);

        Entity e2 = new Entity();
        e2.setX(3);
        e2.setY(4);
        e2.setRadius(2);

        assertTrue(collisionDetector.collides(e1, e2));
    }

    @Test
    public void testEntitiesDoNotCollide() {
        Entity e1 = new Entity();
        e1.setX(0);
        e1.setY(0);
        e1.setRadius(1);

        Entity e2 = new Entity();
        e2.setX(10);
        e2.setY(10);
        e2.setRadius(1);

        assertFalse(collisionDetector.collides(e1, e2));
    }
}