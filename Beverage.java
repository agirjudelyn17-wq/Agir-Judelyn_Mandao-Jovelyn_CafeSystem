public class Beverage extends MenuItem {

    private String size;

    //Default constructor
    public Beverage() {
        super();
        size = "S";
    }

    // Parameterized constructor
     
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

     @Override
    public double computePrice() {

        // Large adds 25 pesos.
        if (size.equals("L")) {
            return basePrice + 25;
        }

        // Medium adds 15 pesos.
        else if (size.equals("M")) {
            return basePrice + 15;
        }

        // Small uses the original base price.
        else {
            return basePrice;
        }
    }

    //Gets the beverage description
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {

        // Only S, M, and L are accepted.
        if (size != null &&
            (size.equalsIgnoreCase("S") ||
             size.equalsIgnoreCase("M") ||
             size.equalsIgnoreCase("L"))) {

            this.size = size.toUpperCase();

        } else {
            System.out.println("Invalid beverage size.");
        }
    }
}
