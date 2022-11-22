package learn.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] != null && value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Элемент не найден в массиве");
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3", "4"};
        try {
            indexOf(array, "5");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}