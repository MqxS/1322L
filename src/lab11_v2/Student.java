package lab11_v2;

public class Student {
    private final String name;
    private final BoxOfBooks boxOfBooks;

    public Student(final String name, final BoxOfBooks boxOfBooks) {
        this.name = name;
        this.boxOfBooks = boxOfBooks;
    }

    public String unpackBoxOfBooks() {
        final StringBuilder sb = new StringBuilder();
        for (String book; (book = boxOfBooks.retrieveBook()) != null;) {
            sb.append(book).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Student: %s%n" +
                        "Books:%n" +
                        "%s",
                name,
                unpackBoxOfBooks()
        );
    }
}
