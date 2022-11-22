package learn.inheritance;

public class Dantist extends Doctor {
    private int numberOfRemovedTeeth;

    public Dantist(String name, String surname, String educ, String birthday,
                   int numberOfPatientsInMount, int i) {
        super(name, surname, educ, birthday, numberOfPatientsInMount);
        numberOfRemovedTeeth = i;
    }

    public void enablingDrill() {
    }
}
