import java.util.ArrayList;

public class Store {

    private String store;
    private ArrayList<Receipt> receipts = new ArrayList<>();


    public Store(String store) {
        if (store == null || store.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        this.store = store;
    }

    public String getStore() {
        return store;
    }

    public void addReceipt(Receipt receipt){

        receipt.setStore(this);
        this.receipts.add(receipt);

    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public void viewReceipts() {
        System.out.println("\n\t\tPrinting receipts here for: " + store);
        double totalSpend = 0;

        for (Receipt receipt : receipts) {
            if (receipt.getStore().getStore().equals(store)) {
                // Format and print receipt details
                Store receiptStore = receipt.getStore();
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
                System.out.println("Something is missing...");
            }
        }

        System.out.println(String.format(
                "\t\tYour overall spending in %s is: $%.2f\n", store, totalSpend));
    }



    public void generateReport() {
        System.out.println("\n--- Detailed Report for Store: " + store + " ---\n");

        // Check if the store has any receipts
        if (receipts.isEmpty()) {
            System.out.println("No receipts found for store: " + store);
            return;
        }

        double totalSales = 0;
        int totalReceipts = 0;

        // Print header for the entire report
        System.out.println("--------------------------------------------------");
        System.out.printf("%-12s %-20s %-15s %-10s %10s %10s\n", "Receipt ID", "Customer", "Item Name", "Price", "Quantity", "Amount");
        System.out.println("--------------------------------------------------");

        // Loop through the store's receipts and print details in a consolidated manner
        for (Receipt receipt : receipts) {
            String customerName = receipt.getCustomer() != null ? receipt.getCustomer().getName() : "Unknown Customer";
            for (Item item : receipt.getItems()) {
                double amount = item.getPrice() * item.getQuantity();
                totalSales += amount;
                totalReceipts++;

                // Print receipt details for each item under the same receipt
                System.out.printf("%-12d %-20s %-15s $%10.2f %10d $%10.2f\n",
                        receipt.getId(), customerName, item.getName(), item.getPrice(), item.getQuantity(), amount);
            }
        }

        // Print summary of the store's total sales and receipt count
        System.out.println("--------------------------------------------------");
        System.out.printf("\n%-40s Total Receipts: %d\n", "", totalReceipts);
        System.out.printf("%-40s Total Sales: $%.2f\n", "", totalSales);
        System.out.println("--------------------------------------------------\n");
    }


    public String toString() {
        return store;
    }

}
