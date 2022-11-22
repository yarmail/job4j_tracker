package learn.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionLam {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> listPoint = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listPoint.add(func.apply((double) i));
        }
        return listPoint;
    }
}
