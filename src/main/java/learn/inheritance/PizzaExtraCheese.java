package learn.inheritance;

public class PizzaExtraCheese extends Pizza {
    @Override
    public String name() {
        return super.name() + " + extra cheese";
    }
}
