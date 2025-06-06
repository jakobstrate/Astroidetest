package dk.cbse.jakob.Playersystem;

import dk.cbse.jakob.common.data.Entity;
import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;
import dk.cbse.jakob.common.services.IGamePluginService;
import org.springframework.stereotype.Component;

@Component
public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }

    private Entity createPlayerShip(GameData gameData) {

        Entity playerShip = new Player();
        playerShip.setPolygonCoordinates(-6,-6,11,1,-6,6);
        playerShip.setX(gameData.getDisplayHeight()/2);
        playerShip.setY(gameData.getDisplayWidth()/2);
        playerShip.setRadius(8);
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

}
