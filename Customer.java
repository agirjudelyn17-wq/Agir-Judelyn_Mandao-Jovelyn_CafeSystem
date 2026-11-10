public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    //Default constructor
    public Customer() {
        this("Guest", false);
    }

    public Customer(String name) {
        this(name, false);
    }
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    // Adds a specific number of loyalty points
    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    //Adds one point for every 50 pesos spent.
    public void addPoints(double amountSpent) {
        if (amountSpent > 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Checks if the customer is a student. 
    public boolean isStudent() {
        return student;
    }

    // Sets the student status
    public void setStudent(boolean student) {
        this.student = student;
    }

    // Gets the customer's loyalty points. 
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Sets the loyalty points. 
    public void setLoyaltyPoints(int loyaltyPoints) {

        // Loyalty points cannot be negative.
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
