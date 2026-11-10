public class Order {

    // Attributes
    private Customer customer;
    private MenuItem item1, item2, item3;
    private int itemCount;
    private String orderId;

    // Constructor
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }
    public boolean addItem(MenuItem item) {

        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        }

        if (itemCount >= 3) {
            System.out.println(
                "Order is full. Cannot add "
                + item.getDescription()
            );
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        }

        itemCount++;

        return true;
    }

    // Computes the subtotal using polymorphism
    public double computeSubtotal() {

        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    // Computes total with 10% student discount
    public double computeTotal() {

        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            subtotal -= subtotal * 0.10;
        }

        return subtotal;
    }

    // Overloaded method: computes total with voucher
    public double computeTotal(double voucher) {

        double total = computeTotal();

        if (voucher < 0) {
            System.out.println(
                "Error: Voucher cannot be negative."
            );
            return total;
        }

        total -= voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    // Prints the receipt
    public void printReceipt() {

        System.out.println("==============================================");
        System.out.println("              ORDER RECEIPT");
        System.out.println("==============================================");

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());

        if (customer.isStudent()) {
            System.out.println("Customer Type: Student");
        } else {
            System.out.println("Customer Type: Regular");
        }

        System.out.println("----------------------------------------------");

        if (item1 != null) {
            System.out.printf(
                "%-35s %10.2f%n",
                item1.getDescription(),
                item1.computePrice()
            );
        }

        if (item2 != null) {
            System.out.printf(
                "%-35s %10.2f%n",
                item2.getDescription(),
                item2.computePrice()
            );
        }

        if (item3 != null) {
            System.out.printf(
                "%-35s %10.2f%n",
                item3.getDescription(),
                item3.computePrice()
            );
        }
        
        System.out.println("----------------------------------------------");

        double subtotal = computeSubtotal();
        double discount = 0;

        if (customer.isStudent()) {
            discount = subtotal * 0.10;
        }

        double total = computeTotal();

        System.out.printf(
            "Subtotal: %34.2f%n", subtotal
        );

        System.out.printf(
            "Discount: %34.2f%n", discount
        );

        System.out.printf(
            "TOTAL: %37.2f%n", total
        );

        // Update customer's loyalty points
        customer.addPoints(total);

        System.out.println("----------------------------------------------");

        System.out.println(
            "Loyalty Points: " + customer.getLoyaltyPoints()
        );

        System.out.println("==============================================");
        System.out.println();
    }
}