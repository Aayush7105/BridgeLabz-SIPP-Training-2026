import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {
    public static int countDigits(int number) {
        number = Math.abs(number);

        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    public static int[] getDigits(int number) {
        int temp = Math.abs(number);
        int[] digits = new int[countDigits(number)];

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        long sum = 0;
        for (int digit : digits) {
            sum += (long) Math.pow(digit, digits.length);
        }
        return sum == Math.abs(number);
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }
        }

        return new int[] { largest, secondLargest };
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest) {
                secondSmallest = digit;
            }
        }

        return new int[] { smallest, secondSmallest };
    }

    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static double findSumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = findSumOfDigits(digits);
        return sum != 0 && Math.abs(number) % sum == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];

        for (int i = 0; i < frequency.length; i++) {
            frequency[i][0] = i;
        }

        for (int digit : digits) {
            frequency[digit][1]++;
        }

        return frequency;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        return reversed;
    }

    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        return areArraysEqual(digits, reverseDigits(digits));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNeonNumber(int number) {
        if (number < 0) {
            return false;
        }

        int square = number * number;
        int[] digits = getDigits(square);
        return findSumOfDigits(digits) == number;
    }

    public static boolean isSpyNumber(int number) {
        int[] digits = getDigits(number);
        int sum = 0;
        int product = 1;

        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }

        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        if (number < 0) {
            return false;
        }

        long square = (long) number * number;
        long divisor = 1;
        for (int i = 0; i < countDigits(number); i++) {
            divisor *= 10;
        }

        return square % divisor == number;
    }

    public static boolean isBuzzNumber(int number) {
        number = Math.abs(number);
        return number % 7 == 0 || number % 10 == 7;
    }

    public static int findProperDivisorSum(int number) {
        number = Math.abs(number);

        if (number <= 1) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        return number > 0 && findProperDivisorSum(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return number > 0 && findProperDivisorSum(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return number > 0 && findProperDivisorSum(number) < number;
    }

    public static long findFactorial(int number) {
        long factorial = 1;

        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static boolean isStrongNumber(int number) {
        int[] digits = getDigits(number);
        long sum = 0;

        for (int digit : digits) {
            sum += findFactorial(digit);
        }

        return sum == Math.abs(number);
    }

    public static void displayDigitFrequency(int[][] frequency) {
        System.out.println("Digit\tFrequency");
        for (int[] digitFrequency : frequency) {
            System.out.println(digitFrequency[0] + "\t" + digitFrequency[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();

        int[] digits = getDigits(number);
        int[] largestValues = findLargestAndSecondLargest(digits);
        int[] smallestValues = findSmallestAndSecondSmallest(digits);

        System.out.println("Digit count is " + countDigits(number));
        System.out.println("Digits are " + Arrays.toString(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));
        System.out.println("Armstrong number: " + isArmstrongNumber(number, digits));
        System.out.println("Largest digit is " + largestValues[0]);
        System.out.println("Second largest digit is " + largestValues[1]);
        System.out.println("Smallest digit is " + smallestValues[0]);
        System.out.println("Second smallest digit is " + smallestValues[1]);
        System.out.println("Sum of digits is " + findSumOfDigits(digits));
        System.out.println("Sum of squares of digits is " + findSumOfSquares(digits));
        System.out.println("Harshad number: " + isHarshadNumber(number, digits));
        displayDigitFrequency(findDigitFrequency(digits));
        System.out.println("Reversed digits are " + Arrays.toString(reverseDigits(digits)));
        System.out.println("Palindrome number: " + isPalindrome(digits));
        System.out.println("Prime number: " + isPrime(number));
        System.out.println("Neon number: " + isNeonNumber(number));
        System.out.println("Spy number: " + isSpyNumber(number));
        System.out.println("Automorphic number: " + isAutomorphicNumber(number));
        System.out.println("Buzz number: " + isBuzzNumber(number));
        System.out.println("Perfect number: " + isPerfectNumber(number));
        System.out.println("Abundant number: " + isAbundantNumber(number));
        System.out.println("Deficient number: " + isDeficientNumber(number));
        System.out.println("Strong number: " + isStrongNumber(number));

        input.close();
    }
}
