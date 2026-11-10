
public class CafeApp {

    public static void main(String[] args) {

        // Create two customers using different constructors
        Customer customer1 = new Customer("Judelyn Agir", true);
        Customer customer2 = new Customer("Jovelyn Mandao");

        // Create menu items using parameterized constructors
        Beverage milkTea = new Beverage(
            "Milk Tea", 95, "B-01", "L"
        );

        Pastry ensaymada = new Pastry(
            "Ensaymada", 45, "P-01", true
        );

        Meal menudo = new Meal(
            "Menudo", 110, "M-01", true, 1
        );

        // Create menu items using default constructors
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");

        // Demonstrate invalid price setter
        hotChocolate.setBasePrice(-5);

        // Set valid values
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130);
        beefTapa.setItemCode("M-02");
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);

        // Create first order
        Order order1 = new Order("1001", customer1);

        order1.addItem(milkTea);
        order1.addItem(ensaymada);
        order1.addItem(menudo);

        // Attempt to add a fourth item
        Pastry cookie = new Pastry(
            "Cookie", 30, "P-02", false
        );

        order1.addItem(cookie);

        // Print first receipt
        order1.printReceipt();

        // Create second order
        Order order2 = new Order("1002", customer2);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        // Print second receipt with voucher
        System.out.println("Second Order with Voucher:");
        System.out.println("Total with 20-peso voucher: "
            + order2.computeTotal(20));

        order2.printReceipt();
    }
}
