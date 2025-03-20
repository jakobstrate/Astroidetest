package dk.cbse.jakob.common.services;

import dk.cbse.jakob.common.data.GameData;
import dk.cbse.jakob.common.data.World;

public interface IGamePluginService {

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}

