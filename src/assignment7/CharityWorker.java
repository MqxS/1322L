package assignment7;

public class CharityWorker implements Runnable {
    private static int nextID = 0;
    private final int workerID;
    private final Warehouse warehouse;

    public CharityWorker(final Warehouse warehouse) {
        this.workerID = nextID++;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (Produce produce; (produce = warehouse.getProduce()) != null;) {
            warehouse.addToTaxSavings(produce.getPrice());
            switch (produce.getProduceName().toLowerCase()) {
                case "tomatoes" -> warehouse.addTomato();
                case "lettuce" -> warehouse.addLettuce();
                case "carrots" -> warehouse.addCarrot();
            }
        }
        System.out.printf("Worker %s is done working%n", getWorkerID());
    }

    public int getWorkerID() {
        return workerID;
    }
}
