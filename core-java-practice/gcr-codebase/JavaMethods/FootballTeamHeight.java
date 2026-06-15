import java.util.Arrays;

public class FootballTeamHeight {
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }

        return heights;
    }

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);

        System.out.println("Player heights are " + Arrays.toString(heights));
        System.out.println("Sum of heights is " + findSum(heights));
        System.out.println("Mean height is " + findMean(heights));
        System.out.println("Shortest height is " + findShortest(heights));
        System.out.println("Tallest height is " + findTallest(heights));
    }
}
