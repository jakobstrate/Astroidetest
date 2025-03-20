package dk.cbse.jakob.common.services;

import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;


public interface IPostEntityProcessingService {

    void process(GameData gameData, World world);
}