package midterm.Question3;

public class Question3 {
    public static void main(String[] args) {
        final Business[] businesses = new Business[2];
        final Store store = new Store("Record Scratch", 25_000, 2500, 8500);
        final Webstore webstore = new Webstore("Music Central", 20_000, 2500, 500);
        businesses[0] = store;
        businesses[1] = webstore;

        for(final Business business : businesses) {
            System.out.println(business);
            System.out.println();
        }
    }
}
