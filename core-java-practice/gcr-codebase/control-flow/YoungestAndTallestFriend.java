import java.util.Scanner;

class YoungestAndTallestFriend {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int amarAge = input.nextInt();
        double amarHeight = input.nextDouble();
        int akbarAge = input.nextInt();
        double akbarHeight = input.nextDouble();
        int anthonyAge = input.nextInt();
        double anthonyHeight = input.nextDouble();

        String youngestFriend = "Amar";
        int youngestAge = amarAge;

        if (akbarAge < youngestAge) {
            youngestFriend = "Akbar";
            youngestAge = akbarAge;
        }

        if (anthonyAge < youngestAge) {
            youngestFriend = "Anthony";
        }

        String tallestFriend = "Amar";
        double tallestHeight = amarHeight;

        if (akbarHeight > tallestHeight) {
            tallestFriend = "Akbar";
            tallestHeight = akbarHeight;
        }

        if (anthonyHeight > tallestHeight) {
            tallestFriend = "Anthony";
        }

        System.out.println("Youngest Friend = " + youngestFriend);
        System.out.println("Tallest Friend = " + tallestFriend);

        input.close();
    }
}
