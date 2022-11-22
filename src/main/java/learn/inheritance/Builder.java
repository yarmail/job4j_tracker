package learn.inheritance;

public class Builder extends Engineer {
    private String fieldOfBuilding;

    public Builder(String name, String surname, String educ, String birthday,
                   String fieldOfScience, String fieldOfBuilding) {
        super(name, surname, educ, birthday, fieldOfScience);
        this.fieldOfBuilding = fieldOfBuilding;
    }

    public void buildTheTower() {
    }
}
