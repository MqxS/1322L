package assignment2;

public class Publication {
    private static int nextId = 10001;

    private final int publicationId;
    private final int year;
    private final String title;
    private final String author;
    private boolean available;

    public Publication(final String title, final String author, final int year) {
        this.publicationId = nextId++;
        this.year = year > 0 ? year : 1970;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public void setAvailable(final boolean available) {
        this.available = available;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format(
                "%s by %s (%d)%n" +
                        "#%d%n" +
                        "%s",
                title,
                author,
                year,
                publicationId,
                (available ? "AVAILABLE" : "NOT AVAILABLE")
        );
    }
}
