package utils;

import marine.Chapter;
import marine.Coordinates;
import marine.SpaceMarine;
import marine.Weapon;
import request.MarineData;
import request.Request;

import java.io.IOException;
import java.time.LocalDateTime;

public class MarineReceiver {
    private final NetworkManager networkManager;

    public MarineReceiver(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }
    public SpaceMarine buildMarine(Integer id) throws IOException, ClassNotFoundException {
        networkManager.send(new Request());
        MarineData marineData = networkManager.receive().getMarineData();
        return new SpaceMarine(id,
                marineData.getName(),
                new Coordinates(marineData.getX(),
                        marineData.getY()),
                LocalDateTime.now(),
                marineData.getHealth(),
                marineData.getHeartCount(),
                marineData.getLoyal(),
                Weapon.valueOf(marineData.getWeaponType()),
                new Chapter(marineData.getChapterName(),
                        marineData.getParentLegion()));
    }

    public SpaceMarine buildMarine() throws IOException, ClassNotFoundException {
        return buildMarine(0);
    }
}
