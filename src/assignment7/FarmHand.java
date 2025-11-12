package assignment7;

public class FarmHand implements Runnable {
    private final Warehouse warehouse;
    private final Produce produce;
    private final int produceAmount;

    public FarmHand(
            final Warehouse warehouse,
            final Produce produce,
            final int produceAmount
    ) {
        this.warehouse = warehouse;
        this.produce = produce;
        this.produceAmount = produceAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < produceAmount; i++) {
            warehouse.storeProduce(produce);
        }
        System.out.printf("Worker storing %s is done.%n", produce.getProduceName());
    }
}
