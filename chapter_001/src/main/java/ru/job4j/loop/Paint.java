package ru.job4j.loop;
/**
 * Class Max. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 27.08.2017
 */
public class Paint {
    /**
     * @param h - высота пирамиды.
     * @return String.
     */
    public String piramid(int h) {
        StringBuilder result = new StringBuilder("");
        // ширина основания как арифметическая прогрессия.
        int width = 1 + 2 * (h - 1);
        // середина вершины пирамиды.
        int vertex = (int) Math.ceil(width / 2);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < width; j++) {
                if ((j >= vertex - i) && (j <= vertex + i)) {
                    result.append("^");
                } else {
                    result.append(" ");
                }
            }
            // переход на новую строку.
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }
}