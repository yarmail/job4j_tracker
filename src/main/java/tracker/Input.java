package tracker;

/**
 * interface Input
 * Создает метод ask для реализацци его разными классами
 * Все интерфейсы имеют доступ public
 */
interface Input {

    /**
     * The ask method asks the user for information.
     * Метод ask запрашивает у пользователя информацию
     */
    String askStr(String question);
    int askInt(String question);
    int askInt(String question, int max);
}
