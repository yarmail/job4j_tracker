package learn.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит в воздухе.");
    }
}
