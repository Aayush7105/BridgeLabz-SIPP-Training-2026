import java.util.Scanner;

public class DeckOfCardsDistribution {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int numberOfCards = suits.length * ranks.length;
        String[] deck = new String[numberOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int numberOfCards = deck.length;
        for (int i = 0; i < numberOfCards; i++) {
            int randomCardNumber = i + (int) (Math.random() * (numberOfCards - i));
            String temporary = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temporary;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numberOfPlayers, int cardsPerPlayer) {
        if (numberOfPlayers <= 0 || cardsPerPlayer <= 0 || numberOfPlayers * cardsPerPlayer > deck.length) {
            return new String[0][0];
        }

        String[][] players = new String[numberOfPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return players;
    }

    public static void printPlayersCards(String[][] players) {
        if (players.length == 0) {
            System.out.println("Cards cannot be distributed with the given inputs");
            return;
        }

        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        System.out.print("Enter number of cards for each player: ");
        int cardsPerPlayer = scanner.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] players = distributeCards(deck, numberOfPlayers, cardsPerPlayer);
        printPlayersCards(players);
    }
}
