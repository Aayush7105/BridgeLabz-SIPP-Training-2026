interface TextModeration {

    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Posts must not contain offensive or abusive language.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "abuse", "violent"};
        String lowerCasePost = post.toLowerCase();

        for (String word : restrictedWords) {
            if (lowerCasePost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {

    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Posts must not contain repeated promotional or spam content.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] spamWords = {"buy now", "free money", "click here"};
        String lowerCasePost = post.toLowerCase();

        for (String word : spamWords) {
            if (lowerCasePost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public boolean isSpam(String post) {
        return SpamDetection.containsRestrictedWords(post);
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void moderatePosts(String[] posts) {
        for (String post : posts) {
            System.out.println("Post: " + post);

            if (isSpam(post)) {
                System.out.println("Result: Spam post");
            } else if (isOffensive(post)) {
                System.out.println("Result: Offensive post");
            } else {
                System.out.println("Result: Valid post");
            }
            System.out.println();
        }
    }
}

public class ContentModerationPlatform {

    public static void main(String[] args) {
        String[] posts = {
            "Learning Java interfaces is fun.",
            "Click here to win free money today!",
            "This post contains hate speech.",
            "Buy now and get a huge discount.",
            "Good morning everyone."
        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();
        System.out.println();
        moderator.moderatePosts(posts);
    }
}
