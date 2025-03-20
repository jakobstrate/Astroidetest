package dk.cbse.jakob.common.services;

import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;

public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
