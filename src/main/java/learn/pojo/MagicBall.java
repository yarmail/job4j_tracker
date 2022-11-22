package learn.pojo;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        String res = input.nextLine();
        int answer = new Random().nextInt(3);
        String response = switch (answer) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
        };
        System.out.println("Ваш вопрос - " + res + ". Мой ответ - " + response);
        }
}
