import java.util.Scanner;

public class AddDigits {

    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    static int addDigits(int n) {
        if (n < 10) {
            return n;
        }
        return addDigits(sumOfDigits(n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(addDigits(n));
        sc.close();
    }
}
