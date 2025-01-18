import java.util.ArrayList;
import java.util.List;

public class Customer {

   private String name;
   private List<Receipt> receipts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Customer(String name) {

        this.name = name;
    }

    public void addReceipt(Receipt receipt){
        receipt.setCustomer(this);
        this.receipts.add(receipt);
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void viewReceipts() {
        System.out.println("\n\t\tReceipts List:");
        System.out.println("\t\t--------------------------------");

        double totalSpend = 0;

        for (Receipt receipt : receipts) {
            Store receiptStore = receipt.getStore(); // Access the store associated with the receipt
            if (receiptStore != null) { // Ensure the store is not null
                System.out.println(String.format(
                        "Receipt ID      : %d\n" +
                                "Store Name      : %s\n" +
                                "Customer Name   : %s\n" +
                                "Total Amount    : $%.2f\n" +
                                "Payment Method  : %s\n" +
                                "--------------------------------",
                        receipt.getId(),
                        receiptStore.getStore(),
                        receipt.getCustomer().getName(),
                        receipt.totalAmount,
                        receipt.getPaymentMethod()
                ));
                totalSpend += receipt.totalAmount;
            } else {
                System.out.println("Store information is missing for this receipt.");
            }
        }

        System.out.println(String.format(
                "\t\tOverall spending across receipts: $%.2f\n", totalSpend));
    }



    public void generateReport() {
        System.out.println("\n--- Detailed Report for Customer: " + name + " ---\n");

        // Check if the customer has any receipts
        if (receipts.isEmpty()) {
            System.out.println("No receipts found for customer: " + name);
            return;
        }

        double totalSpend = 0;

        // Print header for the entire report
        System.out.println("--------------------------------------------------");
        System.out.printf("%-12s %-20s %-15s %-10s %10s %10s\n", "Receipt ID", "Store", "Item Name", "Price", "Quantity", "Amount");
        System.out.println("--------------------------------------------------");

        // Loop through the customer's receipts and print details in a consolidated manner
        for (Receipt receipt : receipts) {
            String storeName = receipt.getStore() != null ? receipt.getStore().getStore() : "Unknown Store";
            for (Item item : receipt.getItems()) {
                double amount = item.getPrice() * item.getQuantity();
                totalSpend += amount;

                // Print receipt details for each item under the same receipt
                System.out.printf("%-12d %-20s %-15s $%10.2f %10d $%10.2f\n",
                        receipt.getId(), storeName, item.getName(), item.getPrice(), item.getQuantity(), amount);
            }
        }

        // Print payment details and total spending for the customer at the end
        System.out.println("--------------------------------------------------");
        System.out.printf("\n%-40s Total Spending: $%.2f\n", "", totalSpend);
        System.out.println("--------------------------------------------------\n");
    }
}
