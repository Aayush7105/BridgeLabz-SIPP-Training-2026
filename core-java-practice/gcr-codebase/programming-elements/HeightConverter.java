import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter height in centimeters:");
        double heightInCentimeters = input.nextDouble();

        double centimetersPerInch = 2.54;
        int inchesPerFoot = 12;
        double totalInches = heightInCentimeters / centimetersPerInch;
        int heightInFeet = (int) (totalInches / inchesPerFoot);
        double remainingInches = totalInches % inchesPerFoot;

        System.out.println("Your Height in cm is " + heightInCentimeters
                + " while in feet is " + heightInFeet + " and inches is " + remainingInches);

        input.close();
    }
}
