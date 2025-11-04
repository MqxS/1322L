package lab11_v2;

import java.util.ArrayList;

public class QueueOfStudents {
    private final ArrayList<Student> students;

    public QueueOfStudents() {
        this.students = new ArrayList<>();
    }

    public void registerForPickup(final Student student) {
        students.add(student);
    }

    public Student deliverBoxOfBooks() {
        if (students.isEmpty()) {
            return null;
        }
        return students.removeFirst();
    }
}
