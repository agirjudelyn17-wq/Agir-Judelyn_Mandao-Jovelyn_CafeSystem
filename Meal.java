public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    // Default constructor
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    //Parameterized constructor. 
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    // Calculates the meal price. 
    @Override
    public double computePrice() {

        double price = basePrice;

        // Add 20 pesos if the meal is upsized.
        if (upsized) {
            price += 20;
        }

        price += extraSides * 12;

        return price;
    }

    //Gets the meal description.
    @Override
    public String getDescription() {

        String status;

        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }

        return super.getDescription() + " " + status
                + ", " + extraSides + " side(s)";
    }

    //Checks if the meal is upsized. 
    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    //Gets the number of extra sides. 
    public int getExtraSides() {
        return extraSides;
    }

    //Sets the number of extra sides. 
    public void setExtraSides(int extraSides) {

        // Negative extra sides are not allowed.
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
