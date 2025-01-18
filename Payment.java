
import java.util.Random;

abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract String getPaymentType();

    public double getAmount() {
        return amount;
    }

}
