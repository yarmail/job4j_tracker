package learn.inheritance;

public class Engineer extends Profession {
    private String fieldOfScience;

    public Engineer(String name, String surname, String educ, String birthday,
                    String fieldOfScience) {
        super(name, surname, educ, birthday);
        this.fieldOfScience = fieldOfScience;
    }

    public void calculation() {
    }
}
