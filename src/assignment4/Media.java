package assignment4;

public abstract class Media {
    private static int nextId = 1;

    private final String fileName;
    private final int id;

    public Media(final String fileName) {
        this.fileName = fileName;
        this.id = nextId++;
    }

    public String getFileName() {
        return fileName;
    }

    public int getId() {
        return id;
    }
}
