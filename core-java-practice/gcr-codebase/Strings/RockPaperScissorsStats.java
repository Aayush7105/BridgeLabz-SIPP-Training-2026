import java.util.Scanner;

public class RockPaperScissorsStats {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) {
            return "rock";
        }
        if (choice == 1) {
            return "paper";
        }
        return "scissors";
    }

    public static String getWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        }
        if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][3];

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", (userWins * 100.0) / totalGames);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", (computerWins * 100.0) / totalGames);

        stats[2][0] = "Draw";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f", (draws * 100.0) / totalGames);

        return stats;
    }

    public static void displayGameResults(String[][] games, String[][] stats) {
        System.out.printf("%-8s %-12s %-12s %-10s%n", "Game", "User", "Computer", "Winner");
        for (String[] game : games) {
            System.out.printf("%-8s %-12s %-12s %-10s%n", game[0], game[1], game[2], game[3]);
        }

        System.out.println();
        System.out.printf("%-12s %-8s %-12s%n", "Player", "Wins", "Win %");
        for (String[] row : stats) {
            System.out.printf("%-12s %-8s %-12s%n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int numberOfGames = scanner.nextInt();
        scanner.nextLine();

        String[][] games = new String[numberOfGames][4];
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("Enter rock, paper, or scissors for game " + (i + 1) + ": ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Using rock.");
                userChoice = "rock";
            }

            String computerChoice = getComputerChoice();
            String winner = getWinner(userChoice, computerChoice);

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }

            games[i][0] = String.valueOf(i + 1);
            games[i][1] = userChoice;
            games[i][2] = computerChoice;
            games[i][3] = winner;
        }

        displayGameResults(games, calculateStats(userWins, computerWins, draws, numberOfGames));
    }
}
