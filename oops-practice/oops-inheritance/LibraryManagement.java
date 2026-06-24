class Book {

    private final String title;
    private final int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Publication Year: " + getPublicationYear());
    }
}

class Author extends Book {

    private final String name;
    private final String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + getName());
        System.out.println("Author Bio: " + getBio());
    }
}

public class LibraryManagement {

    public static void main(String[] args) {
        Author bookWithAuthor = new Author(
            "Clean Code",
            2008,
            "Robert C. Martin",
            "Software engineer and author known for writing about clean programming practices."
        );

        bookWithAuthor.displayInfo();
    }
}
