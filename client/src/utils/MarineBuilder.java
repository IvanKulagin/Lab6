package utils;

import exceptions.InvalidFieldException;
import request.MarineData;

public class MarineBuilder {
    private final Validator validator;
    private final ConsoleManager consoleManager;

    public MarineBuilder(ConsoleManager consoleManager) {
        validator = new Validator();
        this.consoleManager = consoleManager;
    }

    public String readName() {
        try {
            consoleManager.print("Введите имя: ");
            String name = consoleManager.read();
            validator.checkName(name);
            return name;
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readName();

        }
    }

    public Double readX() {
        try {
            consoleManager.print("Введите координату X: ");
            String x = consoleManager.read();
            validator.checkX(x);
            return Double.valueOf(x);
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readX();

        }
    }

    public Integer readY() {
        try {
            consoleManager.print("Введите координату Y: ");
            String y = consoleManager.read();
            validator.checkY(y);
            return Integer.valueOf(y);
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readY();

        }
    }

    public Integer readHealth() {
        try {
            consoleManager.print("Введите количество здоровья: ");
            String health = consoleManager.read();
            validator.checkHealth(health);
            return Integer.valueOf(health);
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readHealth();

        }
    }

    public Integer readHeartCount() {
        try {
            consoleManager.print("Введите количество сердец: ");
            String heartCount = consoleManager.read();
            validator.checkHeartCount(heartCount);
            return Integer.valueOf(heartCount);
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readHeartCount();
        }
    }

    public Boolean readLoyal() {
        try {
            consoleManager.print("Установите лояльность (true, false): ");
            String loyal = consoleManager.read().toLowerCase();
            validator.checkLoyal(loyal);
            return Boolean.valueOf(loyal);
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readLoyal();
        }
    }

    public String readWeaponType() {
        try {
            consoleManager.print("Выберите тип оружия (BOLTGUN, BOLT_PISTOL, FLAMER): ");
            String weaponType = consoleManager.read().toUpperCase();
            validator.checkWeapon(weaponType);
            return weaponType;
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readWeaponType();
        }
    }

    public String readChapterName() {
        try {
            consoleManager.print("Введите название отряда: ");
            String chapterName = consoleManager.read();
            validator.checkChapterName(chapterName);
            return chapterName;
        } catch (InvalidFieldException e) {
            consoleManager.println(e.getMessage());
            return readChapterName();
        }
    }

    public String readParentLegion() {
        consoleManager.print("Введите назнание легиона: ");
        String parentLegion = consoleManager.read();
        if (parentLegion.equals("")) {
            parentLegion = null;
        }
        return parentLegion;
    }

    public MarineData buildMarine() {
        return new MarineData(readName(), readX(), readY(), readHealth(), readHeartCount(), readLoyal(), readWeaponType(), readChapterName(), readParentLegion());
    }
}
