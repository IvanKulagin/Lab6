package request;

import java.io.Serializable;

public class MarineData implements Serializable {

    private static final long serialVersionUID = 5295143740513912116L;
    private final String name;
    private final double x;
    private final double y;
    private final int health;
    private final Integer heartCount;
    private final Boolean loyal;
    private final String weaponType;
    private final String chapterName;
    private final String parentLegion;

    public MarineData(String name, double x, double y, int health, int heartCount, Boolean loyal, String weaponType, String chapterName, String parentLegion) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.heartCount = heartCount;
        this.loyal = loyal;
        this.weaponType = weaponType;
        this.chapterName = chapterName;
        this.parentLegion = parentLegion;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public Integer getHeartCount() {
        return heartCount;
    }

    public Boolean getLoyal() {
        return loyal;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getChapterName() {
        return chapterName;
    }

    public String getParentLegion() {
        return parentLegion;
    }
}
