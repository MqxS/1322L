package assignment5;

public class Tile {
    private final String symbol;
    private boolean visited;

    public Tile(final String symbol) {
        this.symbol = symbol;
        this.visited = false;
    }

    public void setVisited(final boolean visited) {
        this.visited = visited;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isVisited() {
        return visited;
    }
}
