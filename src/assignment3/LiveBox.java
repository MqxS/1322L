package assignment3;

public class LiveBox extends Box {
    private final String animal;
    private final int age;

    public LiveBox(
            final String deliveryAddress,
            final String returnAddress,
            final double width,
            final double height,
            final double boxHeight,
            final int count,
            final String animal,
            final int age
    ) {
        super(deliveryAddress, returnAddress, width, height, boxHeight, count);
        this.animal = animal.toUpperCase();
        this.age = age;
    }

    public LiveBox() {
        this("", "", 0, 0, 0, 0, "", 0);
    }

    public String  getAnimal() {
        return animal;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(
                "%s" +
                        "Animal: %s%n" +
                        "Count: %d%n" +
                        "Age (Days): %d%n",
                super.toString(),
                getAnimal(),
                getCount(),
                getAge()
        );
    }
}
