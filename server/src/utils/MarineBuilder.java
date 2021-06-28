package utils;

import marine.*;
import request.MarineData;

import java.io.IOException;
import java.time.LocalDateTime;

public class MarineBuilder {
    private Integer id;
    private String name;
    private double x;
    private double y;
    private LocalDateTime creationDate;
    private int health;
    private Integer heartCount;
    private Boolean loyal;
    private Weapon weaponType;
    private String chapterName;
    private String parentLegion;

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(String x) {
        this.x = Double.parseDouble(x);
    }

    public void setY(String y) {
        this.y = Double.parseDouble(y);
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = LocalDateTime.parse(creationDate);
    }

    public void setHealth(String health) {
        this.health = Integer.parseInt(health);
    }

    public void setHeartCount(String heartCount) {
        this.heartCount = Integer.valueOf(heartCount);
    }

    public void setLoyal(String loyal) {
        this.loyal = Boolean.valueOf(loyal);
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = Weapon.valueOf(weaponType);
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }

    public SpaceMarine buildMarine() {
        return new SpaceMarine(id, name, new Coordinates(x, y), creationDate, health, heartCount, loyal, weaponType, new Chapter(chapterName, parentLegion));
    }
}
