interface StreamingService {

    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription includes movies and shows.");
    }
}

interface GamingService {

    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription includes cloud games.");
    }
}

class SmartTV implements StreamingService, GamingService {

    private final String[] movies;
    private final String[] games;

    SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    @Override
    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayAvailableContent() {
        System.out.println("Available Movies:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }

        System.out.println("Available Games:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
}

public class SmartTVDemo {

    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar", "The Matrix"};
        String[] games = {"FIFA 26", "Minecraft", "Forza Horizon"};

        SmartTV smartTV = new SmartTV(movies, games);

        smartTV.showSubscriptionDetails();
        System.out.println();
        smartTV.displayAvailableContent();
        System.out.println();
        smartTV.streamMovie(movies[0]);
        smartTV.playGame(games[1]);
    }
}
