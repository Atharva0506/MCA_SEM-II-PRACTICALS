// Marker interface (empty)
interface MyMarker {
}

// Product class implementing marker interface
class Product implements MyMarker {
    private int product_id;
    private String product_name;
    private double product_cost;
    private int product_quantity;
    static int count = 0; // Static counter for object count

    // Default constructor
    public Product() {
        product_id = 0;
        product_name = "Unknown";
        product_cost = 0.0;
        product_quantity = 0;
        count++;
    }

    // Parameterized constructor
    public Product(int product_id, String product_name, double product_cost, int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.product_quantity = product_quantity;
        count++;
    }

    // Method to display product details
    void displayDetails() {
        System.out.println("Product ID: " + product_id);
        System.out.println("Product Name: " + product_name);
        System.out.println("Product Cost: " + product_cost);
        System.out.println("Product Quantity: " + product_quantity);
        System.out.println("----------------------");
    }

    // Method to display object count
    static void displayObjectCount() {
        System.out.println("Total Objects Created: " + count);
    }
}

public class Q4 {
    public static void main(String[] args) {
        // Creating objects using default and parameterized constructors
        Product p1 = new Product(); // Default constructor
        Product p2 = new Product(101, "Laptop", 75000.50, 10); // Parameterized constructor
        Product p3 = new Product(102, "Mouse", 1500.75, 50); // Parameterized constructor

        // Displaying product details
        System.out.println("\nProduct Details:");
        p1.displayDetails();
        p2.displayDetails();
        p3.displayDetails();

        // Displaying total object count
        Product.displayObjectCount();
    }
}
