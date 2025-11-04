package lab11_v1;

public class BlueRayDisk {
    private final String title;
    private final String director;
    private final int yearOfRelease;
    private final double cost;

    public BlueRayDisk next;

    public BlueRayDisk(
            final String name,
            final String director,
            final int year,
            final double cost
    ) {
        this.title = name;
        this.director = director;
        this.yearOfRelease = year;
        this.cost = cost;

        this.next = null;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %s (%d): $%.2f",
                title,
                director,
                yearOfRelease,
                cost
        );
    }
}
