import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static String findYoungest(String[] names, int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        return names[youngestIndex];
    }

    public static String findTallest(String[] names, double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        return names[tallestIndex];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] ages = new int[names.length];
        double[] heights = new double[names.length];

        for (int i = 0; i < names.length; i++) {
            System.out.println("Enter age of " + names[i] + ":");
            ages[i] = input.nextInt();

            System.out.println("Enter height of " + names[i] + ":");
            heights[i] = input.nextDouble();
        }

        System.out.println("Youngest friend is " + findYoungest(names, ages));
        System.out.println("Tallest friend is " + findTallest(names, heights));

        input.close();
    }
}
