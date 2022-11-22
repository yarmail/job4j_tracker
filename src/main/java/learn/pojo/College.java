package learn.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Семенов Вячеслав Михайлович");
        student.setGroup("2A");
        student.setDate("01.09.2022");
        System.out.println("Студент с именем " + student.getFio() + " из группы "
                + student.getGroup() + " поступил " + student.getDate() + " числа.");
    }
}
