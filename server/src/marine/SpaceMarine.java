package marine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SpaceMarine implements Comparable<SpaceMarine>{
    private final Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final int health; //Значение поля должно быть больше 0
    private final Integer heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private final Boolean loyal; //Поле может быть null
    private final Weapon weaponType; //Поле не может быть null
    private final Chapter chapter; //Поле может быть null


    public SpaceMarine(int id, String name, Coordinates coordinates, LocalDateTime creationDate, int health, int heartCount, Boolean loyal, Weapon weaponType, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.heartCount = heartCount;
        this.loyal = loyal;
        this.weaponType = weaponType;
        this.chapter = chapter;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public Weapon getWeaponType() {
        return weaponType;
    }

    public Chapter getChapter() {
        return chapter;
    }

    @Override
    public int compareTo(SpaceMarine marine) {
        return Integer.compare(health, marine.getHealth());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
        return "id: " + id +
                "\nname: " + name +
                "\ncoordinates: {" +
                "\n\tx: " + coordinates.getX() +
                "\n\ty: " + coordinates.getY() +
                "\n}" +
                "\ncreationDate: " + creationDate.format(formatter) +
                "\nhealth: " + health +
                "\nheartCount: " + heartCount +
                "\nloyal: " + loyal +
                "\nweaponType: " + weaponType +
                "\nchapter: {" +
                "\n\tname: " + chapter.getName() +
                "\n\tparentLegion: " + chapter.getParentLegion() +
                "\n}";
    }
}