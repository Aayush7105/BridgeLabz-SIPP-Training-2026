import java.util.Arrays;

public class RandomStatsCalculator {
    public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }

        return numbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        double average = (double) sum / numbers.length;
        return new double[] { average, min, max };
    }

    public static void main(String[] args) {
        RandomStatsCalculator calculator = new RandomStatsCalculator();
        int[] numbers = calculator.generate4DigitRandomArray(5);
        double[] result = calculator.findAverageMinMax(numbers);

        System.out.println("Random numbers are " + Arrays.toString(numbers));
        System.out.println("Average value is " + result[0]);
        System.out.println("Minimum value is " + result[1]);
        System.out.println("Maximum value is " + result[2]);
    }
}
