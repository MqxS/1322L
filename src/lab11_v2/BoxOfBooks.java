package lab11_v2;

import java.util.ArrayList;

public class BoxOfBooks {
    private final String boxName;
    private final ArrayList<String> books;

    public BoxOfBooks(final String boxName) {
        this.boxName = boxName;
        this.books = new ArrayList<>();
    }

    public String getBoxName() {
        return boxName;
    }

    public void addBook(final String book) {
        books.addFirst(book);
    }

    public String retrieveBook() {
        if (books.isEmpty()) {
            return null;
        }
        return books.removeFirst();
    }

    public BoxOfBooks copy() {
        final BoxOfBooks booksCopy = new BoxOfBooks(boxName);
        for (int i = books.size() - 1; i >= 0; i--) {
            final String book = books.get(i);
            booksCopy.addBook(book);
        }
        return booksCopy;
    }
}
