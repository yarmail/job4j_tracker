package learn.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет без пассажиров ");
    }

    @Override
    public void driveWithPass(int numOfPass) {
        System.out.println("Автобус едет с таким кол-вом пассажиров" + numOfPass);
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 44;
    }
}
