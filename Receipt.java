import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

   private static int idCounter = 1;
   private int id;
   private Store store;
   private Customer customer;
   protected List<Item> items;
   private Payment paymentMethod;
   protected double totalAmount = 0;

    public Receipt() {
        items = new ArrayList<>();
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setStore(Store store) {

        this.store = store;
    }
    public Store getStore() {
        return store;
    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){

        items.add(item);
    }

    public double calculateTotal(){

        totalAmount = 0;
            for (Item item : items) {
                totalAmount += item.getPrice() * item.getQuantity(); // Sum up the price of all items
            }
           // System.out.println("your total of the receipt is :  " + totalAmount);

            return totalAmount;
    }

    public String toString() {
        return "Receipt: " +
                "Customer Name: " + (customer != null ? customer.getName() : "null") +
                ", Store Name: " + (store != null ? store.getStore() : "null") +
                ", " + (paymentMethod != null ? paymentMethod.toString() : "Payment not set");
    }



}





