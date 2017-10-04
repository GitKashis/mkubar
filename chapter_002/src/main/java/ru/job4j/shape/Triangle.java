package ru.job4j.shape;

/**
 * Created by Kubar on 04.10.2017.
 */
public class Triangle implements Shape {
    /**
     * Painting triangle.
     * @return String.
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        String sep = System.getProperty("line.separator");
        sb.append("     +").append(sep);
        sb.append("    +++").append(sep);
        sb.append("   +++++").append(sep);
        sb.append("  +++++++");
        return sb.toString();
    }
}
