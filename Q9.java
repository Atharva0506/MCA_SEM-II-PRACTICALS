import java.util.TreeSet;

public class Q9 {
    public static void main(String[] args) {
        // Creating a TreeSet to store colors
        TreeSet<String> colors = new TreeSet<>();

        // Adding colors to the TreeSet
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");
        colors.add("Orange");

        // Printing colors (TreeSet maintains ascending order)
        System.out.println("Colors in ascending order:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}
