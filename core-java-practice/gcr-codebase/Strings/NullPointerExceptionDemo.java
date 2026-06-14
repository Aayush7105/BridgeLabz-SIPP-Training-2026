public class NullPointerExceptionDemo {

    public static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length());
    }

    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException exception) {
            System.out.println("Handled NullPointerException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            generateNullPointerException();
        } catch (NullPointerException exception) {
            System.out.println("Generated NullPointerException: " + exception.getMessage());
        }

        handleNullPointerException();
    }
}
