public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    // Default constructor
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    // Parameterized constructor
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    // Gets the item name
    public String getName() {
        return name;
    }

    // Sets the item name
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid item name.");
        }
    }

    // Gets the base price
    public double getBasePrice() {
        return basePrice;
    }

    // Sets the base price
    public void setBasePrice(double basePrice) {
        // Negative prices are not allowed.
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    // Gets the item code
    public String getItemCode() {
        return itemCode;
    }

    //Sets the item code
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
