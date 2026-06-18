import java.util.Scanner;

public class ReverseInteger {

    static int reverse(int n, int result) {
        if (n == 0) {
            return result;
        }
        int digit = n % 10;
        return reverse(n / 10, result * 10 + digit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverse(n, 0));
        sc.close();
    }
}
