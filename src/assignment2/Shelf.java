package assignment2;

import java.util.ArrayList;

public class Shelf {
    private final ArrayList<Publication> publications;

    public Shelf() {
        this.publications = new ArrayList<>();
    }

    public void addPublication(final Publication publication) {
        publications.add(publication);
    }

    public void removePublication(final Publication publication) {
        publications.remove(publication);
    }

    public Publication getPublication(final int index) {
        for (final Publication publication : publications) {
            if (publication.getPublicationId() == index) {
                return publication;
            }
        }
        return null;
    }

    public String listByKeyword(final String keyword) {
        final StringBuilder sb = new StringBuilder();
        for (final Publication publication : publications) {
            if (publication.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())
            ) {
                if (!sb.isEmpty()) {
                    sb.append(System.lineSeparator())
                            .append(System.lineSeparator());
                }
                sb.append(publication);
            }
        }
        if (sb.isEmpty()) {
            return "NO MATCH WITH KEYWORD";
        }

        return sb.toString();
    }

    public String listByAuthor(final String author) {
        final StringBuilder sb = new StringBuilder();
        for (final Publication publication : publications) {
            if (publication.getAuthor().equalsIgnoreCase(author)) {
                if (!sb.isEmpty()) {
                    sb.append(System.lineSeparator())
                            .append(System.lineSeparator());
                }
                sb.append(publication);
            }
        }
        if (sb.isEmpty()) {
            return "NO SUCH AUTHOR";
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Publication publication : publications) {
            if (!sb.isEmpty()) {
                sb.append(System.lineSeparator())
                        .append(System.lineSeparator());
            }
            sb.append(publication);
        }
        if (sb.isEmpty()) {
            return "NO PUBLICATIONS";
        }

        return sb.toString();
    }
}
