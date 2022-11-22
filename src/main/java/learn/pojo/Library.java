package learn.pojo;

public class Library {

    public static void main(String[] args) {
        Book warAndPeace = new Book("WarAndPeace", 1300);
        Book crimeAndPunishment = new Book("CrimeAndPunishment", 400);
        Book alphabetBook = new Book("AlphabetBook", 20);
        Book cleanCode = new Book("Clean code", 150);
        Book[] array = new Book[]{warAndPeace, crimeAndPunishment,
                alphabetBook, cleanCode};
        showBook(array);
        Book tmp = array[0];
        array[0] = array[3];
        array[3] = tmp;
        showBook(array);
        showBook(array, "Clean code");
    }

    public static void showBook(Book[] array) {
        for (Book j : array) {
            System.out.println("Книга под названием: " + j.getName() + "- число страниц - "
                    + j.getNumberOfPages());
        } System.out.println("----------");
    }

    public static void showBook(Book[] array, String name) {
        for (Book j : array) {
            if (name.equals(j.getName())) {
                System.out.println("Книга под название: " + j.getName() + "- число страниц - "
                        + j.getNumberOfPages());

            }
        } System.out.println("----------");
    }
}
