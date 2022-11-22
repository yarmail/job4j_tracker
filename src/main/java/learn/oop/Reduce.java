package learn.oop;

public class Reduce {
    private int[] array;

    public void to(int[] array) {
        this.array = array;
    }

    public void print() {
        for (int j : array) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}