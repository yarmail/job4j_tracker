package learn.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        System.out.println(dic.engToRus("Программирование"));
    }
}
