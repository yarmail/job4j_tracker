package learn.inheritance;

public class Surgeon extends Doctor {
    private int numberOfOperationInMount;

    public Surgeon(String name, String surname, String educ, String birthday,
                   int numberOfPatientsInMount, int i) {
        super(name, surname, educ, birthday, numberOfPatientsInMount);
        numberOfOperationInMount = i;
    }

    public void operation() {
    }
}
