package learn.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по дорогам.");
    }
}
