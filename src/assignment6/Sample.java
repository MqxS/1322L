package assignment6;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sample {
    private static int nextId = 0;

    private final int id;

    private final String drugType;
    private final double weight;
    private final int gcTime;
    private final String msPeaks;
    private final String miscTest;
    private final ArrayList<String> tests;

    public Sample(
            final String drugType,
            final double weight,
            final int gcTime,
            final String msPeaks,
            final String miscTest
    ) {
        this.id = nextId++;
        this.drugType = drugType;
        this.weight = weight;
        this.gcTime = gcTime;
        this.msPeaks = msPeaks;
        this.miscTest = miscTest;

        final Assignment6.DrugType drug = Assignment6.DrugType.findDrug(drugType);
        this.tests = drug.tests.stream()
                .map(Enum::name)
                .map(name -> name.replace('_', ' '))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int getId() {
        return id;
    }

    public String getDrugType() {
        return drugType;
    }

    public double getWeight() {
        return weight;
    }

    public int getGcTime() {
        return gcTime;
    }

    public String getMsPeaks() {
        return msPeaks;
    }

    public String getMiscTest() {
        return miscTest;
    }

    public ArrayList<String> getTests() {
        return tests;
    }

    @Override
    public String toString() {
        return String.format(
                "Case: #%d%n" +
                        "Drug: %s%n" +
                        "Weight: %.2fg%n" +
                        "Tests run: %s",
                id,
                drugType,
                weight,
                String.join(", ", tests)
        );
    }
}
