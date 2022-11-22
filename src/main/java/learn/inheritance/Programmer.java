package learn.inheritance;

public class Programmer extends Engineer {
    private String programLang;

    public Programmer(String name, String surname, String educ, String birthday,
                      String fieldOfScience, String programLang) {
        super(name, surname, educ, birthday, fieldOfScience);
        this.programLang = programLang;
    }

    public void writeAwesomeProgram() {
        System.out.println("Write a program...");
        System.out.println("Compilation...");
        System.out.println("-----------");
        System.out.println("---BUILD FAILURE---");
        System.out.println("---3312 ERROR IN BUILD---");
    }
}
