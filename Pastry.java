public class Pastry extends MenuItem {

    private boolean warmed;

    // Default constructor
    public Pastry() {
        super();
        warmed = false;
    }

    //Parameterized constructor
    public Pastry(String name, double basePrice,
                  String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    // Calculates the pastry price
    @Override
    public double computePrice() {

        double price = basePrice;

        // Add 10 pesos if the pastry is warmed.
        if (warmed) {
            price += 10;
        }

        return price;
    }

    // Gets the pastry description
    @Override
    public String getDescription() {

        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }

        return super.getDescription();
    }

    //Checks if the pastry is warmed
    public boolean isWarmed() {
        return warmed;
    }

    //Sets the warming option
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
