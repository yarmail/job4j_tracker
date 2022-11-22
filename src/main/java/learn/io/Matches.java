package learn.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches;
            try {
                matches = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводить можно только числа!");
                continue;
            }
            if (matches < 1 || matches > 3 || matches > count) {
                System.out.println("Введите корректное число!");
                continue;
            }
            turn = !turn;
            count -= matches;
            System.out.println("Осталось спичек на столе: " + count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}