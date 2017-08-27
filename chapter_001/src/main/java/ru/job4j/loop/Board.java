package ru.job4j.loop;
/**
 * Class Max. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Board {

    /**
     * @value result is board.
     */
    private StringBuilder result = new StringBuilder("");
    /**
     * @param width - размер поля.
     * @param height - размер поля.
     * @return result - форматированная строка.
     */
    public String paint(int width, int height) {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (count % 2 == 0) {
                    result.append("x");
                } else {
                    result.append(" ");
                }
                count++;
            }
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }
}
