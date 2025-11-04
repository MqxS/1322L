package lab11_v1;

public class BlueRayCollection {
    private BlueRayDisk head;

    public BlueRayCollection() {
        this.head = null;
    }

    public void addDisk(
            final String title,
            final String director,
            final int yearOfRelease,
            final double cost
    ) {
        final BlueRayDisk newDisk = new BlueRayDisk(title, director, yearOfRelease, cost);
        if (head == null) {
            head = newDisk;
        } else {
            BlueRayDisk current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newDisk;
        }
    }

    public String showAll() {
        final StringBuilder sb = new StringBuilder();
        BlueRayDisk current = head;
        while (current != null) {
            sb.append(current).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
