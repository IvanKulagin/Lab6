package utils;

import exceptions.InvalidFieldException;

import java.util.Arrays;

public class Validator {

    public void checkName(String str) throws InvalidFieldException {
        if (str.equals("")) {
            throw new InvalidFieldException("Поле не может быть пустым");
        }
    }

    public void checkX(String str) throws InvalidFieldException {
        double x;
        try {
            x = Double.parseDouble(str.replace(',', '.'));
        } catch (Exception e) {
            throw new InvalidFieldException("Значение должно быть десятичной дробью");
        }
        if (x <= -501) {
            throw new InvalidFieldException("Значение должно быть больше -501");
        }
    }

    public void checkY(String str) throws InvalidFieldException {
        try {
            Double.parseDouble(str.replace(',', '.'));
        } catch (Exception e) {
            throw new InvalidFieldException("Значение должно быть десятичной дробью");
        }
    }
    public void checkHealth(String str) throws InvalidFieldException {
        int health;
        try {
            health = Integer.parseInt(str);
        } catch (Exception e) {
            throw new InvalidFieldException("Значение должно быть целым числом");
        }
        if (health <= 0) {
            throw new InvalidFieldException("Значение должно быть больше нуля");
        }
    }

    public void checkHeartCount(String str) throws InvalidFieldException {
        Integer heartCount;
        try {
            heartCount = Integer.parseInt(str);
        } catch (Exception e) {
            throw new InvalidFieldException("Значение должно быть целым числом");
        }
        if (heartCount <= 0) {
            throw new InvalidFieldException("Значение должно быть больше нуля");
        }
        if (heartCount > 3) {
            throw new InvalidFieldException("Значение должно быть не больше 3");
        }
    }

    public void checkLoyal(String str) throws InvalidFieldException {
        try {
            Boolean.valueOf(str);
        } catch (Exception e) {
            throw new InvalidFieldException("Значением должно быть true или false");
        }
    }

    public void checkWeapon(String str) throws InvalidFieldException {
        if (!Arrays.asList("BOLTGUN", "BOLT_PISTOL", "FLAMER").contains(str)){
            throw new InvalidFieldException("Неверный тип оружия");
        }
    }

    public void checkChapterName(String str) throws InvalidFieldException {
        if (str.equals("")) {
            throw new InvalidFieldException("Название не может быть пустым");
        }
    }
}
