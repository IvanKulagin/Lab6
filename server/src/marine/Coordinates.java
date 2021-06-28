package marine;

public class Coordinates {
    private final double x; //Значение поля должно быть больше -501
    private final double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
