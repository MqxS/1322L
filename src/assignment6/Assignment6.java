package assignment6;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Assignment6 {
    private static final Map<String, List<String>> validLogoIDs = Map.of(
            "R-12", List.of("round", "white"),
            "V-20", List.of("oval", "blue"),
            "A-65", List.of("capsule", "pink")
    );

    private static final TreeMap<Double, String> cocaineAndMethPenalties = new TreeMap<>() {
        {
            put(0d, "Up to 3 years in prison");
            put(1d, "1 - 8 years in prison");
            put(4d, "1 - 15 years in prison");
            put(28d, "Minimum 10 years, $200,000 fine");
            put(200d, "Minimum 15 years, $300,000 fine");
            put(400d, "Minimum 25 years, $1,000,000 fine");
        }
    };

    private static final TreeMap<Double, String> marijuanaPenalties = new TreeMap<>() {
        {
            put(0.0, "Misdemeanor");
            put(28.35, "1 - 10 years in prison");
            put(4535.0, "Minimum 5 years, $100,000 fine");
            put(907184.7, "Minimum 7 years, $250,000 fine");
            put(4535924.0, "Minimum 15 years, $1,000,000 fine");
        }
    };

    private static final StringBuilder passedDrugs = new StringBuilder();
    private static final StringBuilder failedDrugs = new StringBuilder();

    @FunctionalInterface
    public interface CheckedBiConsumer<T, U> {
        void apply(T t, U u) throws TestFailedException;
    }

    public enum Test {
        Gas_Chromatography((drug, sample) -> {
            final TestFailedException exception = new TestFailedException("Separation time out of bounds", sample);
            final int timeSec = sample.getGcTime();

            final int minSec;
            final int maxSec;

            switch(drug) {
                case Marijuana -> {
                    minSec = (5 * 60) + 47;
                    maxSec = (6 * 60) + 14;
                }
                case Cocaine -> {
                    minSec = (6 * 60) + 38;
                    maxSec = (7 * 60) + 2;
                }
                case Methamphetamine -> {
                    minSec = (5 * 60) + 7;
                    maxSec = (5 * 60) + 16;
                }
                default -> throw exception;
            }

            if (minSec > timeSec || timeSec > maxSec) {
                throw exception;
            }
        }),
        Mass_Spectrometry((drug, sample) -> {
            final TestFailedException exception = new TestFailedException("Insufficient peak matches", sample);
            final String[] splitPeakStr = sample.getMsPeaks().split(" ");

            final List<Integer> validPeaks;
            switch (drug) {
                case Marijuana -> validPeaks = List.of(314, 299, 231);
                case Cocaine ->  validPeaks = List.of(149, 91, 58);
                case Methamphetamine -> validPeaks = List.of(303, 182, 82);
                default -> throw exception;
            }

            int matches = 0;
            for (final String peakStr : splitPeakStr) {
                final int peak = Integer.parseInt(peakStr);
                if (validPeaks.contains(peak)) {
                    matches++;
                }
            }

            if (matches < 2) {
                throw exception;
            }
        }),
        Gas_Chromatography_Abundance((_, sample) -> {
            final double concentration = Double.parseDouble(sample.getMiscTest());
            if (concentration < 0.3) {
                throw new TestFailedException("Concentration below 0.3%", sample);
            }
        }),
        UV_Spectroscopy((_, sample) -> {
            final int wavelength = Integer.parseInt(sample.getMiscTest());
            if (192 > wavelength || wavelength > 202) {
                throw new TestFailedException("UV reading out of range", sample);
            }
        }),
        Logo_ID((_, sample) -> {
            final TestFailedException exception = new TestFailedException("Prescription medication", sample);
            final String[] drugId = sample.getMiscTest().split(" ");
            if (drugId.length != 3) {
                throw exception;
            }

            final String engraving = drugId[0];
            final String shape = drugId[1];
            final String color = drugId[2];

            if (validLogoIDs.containsKey(engraving)) {
                final List<String> legalDrug = validLogoIDs.get(engraving);
                final String legalShape = legalDrug.get(0);
                final String legalColor = legalDrug.get(1);

                if (shape.equalsIgnoreCase(legalShape) && color.equalsIgnoreCase(legalColor)) {
                    throw exception;
                }
            }
        }),
        ;

        public final CheckedBiConsumer<DrugType, Sample> function;
        Test(final CheckedBiConsumer<DrugType, Sample> function) {
            this.function = function;
        }
    }

    public enum DrugType {
        Marijuana(List.of(Test.Gas_Chromatography, Test.Mass_Spectrometry, Test.Gas_Chromatography_Abundance)),
        Cocaine(List.of(Test.Gas_Chromatography, Test.Mass_Spectrometry, Test.UV_Spectroscopy)),
        Methamphetamine(List.of(Test.Gas_Chromatography, Test.Mass_Spectrometry, Test.Logo_ID)),
        None(List.of()),
        ;
        public final List<Test> tests;
        DrugType(final List<Test> tests) {
            this.tests = tests;
        }

        public static DrugType findDrug(final String drugName) {
            final String trimmedDrugName = drugName.trim();
            for (final DrugType drug : DrugType.values()) {
                if (drug.name().equalsIgnoreCase(trimmedDrugName)) {
                    return drug;
                }
            }
            return None;
        }
    }

    private static String findPenalty(final Sample sample) {
        final DrugType drug = DrugType.findDrug(sample.getDrugType());

        return switch (drug) {
            case Marijuana -> marijuanaPenalties.floorEntry(sample.getWeight()).getValue();
            case Cocaine, Methamphetamine -> cocaineAndMethPenalties.floorEntry(sample.getWeight()).getValue();
            default -> "";
        };
    }

    private static void addSuccess(final Sample sample) {
        passedDrugs.append(sample.toString());
        passedDrugs.append(System.lineSeparator());
        passedDrugs.append(System.lineSeparator());
        passedDrugs.append(String.format("Result: Positive, %s%n", findPenalty(sample)));
        passedDrugs.append("====");
        passedDrugs.append(System.lineSeparator());
    }

    private static void addFail(final TestFailedException exception) {
        final Sample sample = exception.getSample();
        failedDrugs.append(sample.toString());
        failedDrugs.append(System.lineSeparator());
        failedDrugs.append(System.lineSeparator());
        failedDrugs.append(String.format("Result: Negative, %s%n", exception.getMessage()));
        failedDrugs.append("====");
        failedDrugs.append(System.lineSeparator());
    }

    private static void processMarijuana(final Sample sample) {
        final DrugType drug = DrugType.findDrug(sample.getDrugType());

        try {
            for (final Test test : drug.tests) {
                test.function.apply(drug, sample);
            }
            addSuccess(sample);
        } catch (final TestFailedException e) {
            addFail(e);
        }
    }

    private static void processCocaine(final Sample sample) {
        final DrugType drug = DrugType.findDrug(sample.getDrugType());

        try {
            for (final Test test : drug.tests) {
                test.function.apply(drug, sample);
            }
            addSuccess(sample);
        } catch (final TestFailedException e) {
            addFail(e);
        }
    }

    private static void processMethamphetamine(final Sample sample) {
        final DrugType drug = DrugType.findDrug(sample.getDrugType());

        try {
            for (final Test test : drug.tests) {
                test.function.apply(drug, sample);
            }
            addSuccess(sample);
        } catch (final TestFailedException e) {
            addFail(e);
        }
    }

    private static void processFile(final Scanner scanner) {
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine().trim();
            final String[] splitLine = line.split(",");
            if (splitLine.length < 5) {
                continue;
            }

            final String drugName = splitLine[0];
            final double weight = Double.parseDouble(splitLine[1]);
            final int gcTime = Integer.parseInt(splitLine[2]);
            final String msPeaks = splitLine[3];
            final String miscTest = splitLine[4];
            final DrugType drug = DrugType.findDrug(drugName);
            final Sample sample = new Sample(drugName, weight, gcTime, msPeaks, miscTest);

            switch (drug) {
                case Marijuana -> processMarijuana(sample);
                case Cocaine -> processCocaine(sample);
                case Methamphetamine -> processMethamphetamine(sample);
            }
        }
    }

    public static void main(String[] args) {
        final Scanner consoleScanner = new Scanner(System.in);
        System.out.println("[Drug Report Analyzer]");
        System.out.print("Enter name of drug file: ");
        final String filePath = consoleScanner.nextLine();
        consoleScanner.close();
        final File file = new File(filePath);

        try (final Scanner fileScanner = new Scanner(file)) {
            System.out.println("File loaded, processing...");

            processFile(fileScanner);

            try (
                    final BufferedWriter passedBW = new BufferedWriter(new FileWriter("passed.txt"));
                    final BufferedWriter failedBW = new BufferedWriter(new FileWriter("failed.txt"))
            ) {
                passedBW.write(passedDrugs.toString());
                failedBW.write(failedDrugs.toString());
            } catch (final IOException _) {}

            System.out.println("File processed. Outputs written to 'passed.txt' and 'failed.txt'");
        } catch (final FileNotFoundException e) {
            System.out.printf("Could not find file '%s'%n", filePath);
        }

        System.out.println();
        System.out.println("Program complete.");
    }
}
