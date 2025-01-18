class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    public String getPaymentType() {
        return "Credit Card";
    }

    @Override
    public String toString() {
        return getPaymentType();
    }
}