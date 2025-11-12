package lab10;

public class Alarm extends Thread {
    private static int nextId = 1;

    private final int id;
    private final String name;
    private int timer; //durationMs

    public Alarm(final String name, final int durationSeconds) {
        this.id = nextId++;
        this.name = name.isEmpty() ? String.format("Alarm %d", id) : name;
        this.timer = durationSeconds * 1000;
    }

    @Override
    public void run() {
        while (timer > 0) {
            if (isInterrupted()) {
                System.out.printf("%s has been interrupted at %d seconds.%n", name, timer/1000);
                return;
            }

            try {
                sleep(1000);
            } catch (final InterruptedException e) {
                interrupt();
                continue;
            }
            timer -= 1000;

            if (timer == 10_000) {
                System.out.printf("%s will go off in 10 seconds.%n", name);
            }
        }
        System.out.printf("%s has gone off!%n", name);
    }

    public int getAlarmId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s is currently at %d seconds", name, timer/1000);
    }
}
