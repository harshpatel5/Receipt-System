import java.util.ArrayList;

public class Item {

     String name;
     double price;
     int quantity;

    public Item(String name, double price, int quantity) {


        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive integer.");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void generateReport(ArrayList<Receipt> receipts) {
        int totalQuantitySold = 0;
        double totalSales = 0;

        // Loop through all receipts to calculate total quantity sold and total sales for the item
        for (Receipt receipt : receipts) {
            for (Item item : receipt.getItems()) { // Assuming getItems() returns a list of items in the receipt
                if (item.getName().equals(this.name)) {
                    totalQuantitySold += item.getQuantity();
                    totalSales += item.getPrice() * item.getQuantity();
                }
            }
        }

        // Print the item report
        System.out.println("Item Report for: " + this.name);
        System.out.println("------------------------------------------------");
        System.out.println("Total Quantity Sold: " + totalQuantitySold);
        System.out.println("Total Sales for this Item: " + totalSales);
        System.out.println("------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Item: " +
                "Name='" + name + '\'' +
                ", Price=" + price +
                ", Quantity=" + quantity;
    }


}
