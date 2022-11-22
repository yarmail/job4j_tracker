package learn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 12, 132, -14, 1043, -3323, -2);
        List<Integer> positive = numbers.stream().filter(
                number -> number > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
