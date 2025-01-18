class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    public String getPaymentType() {
        return "Cash";
    }

    @Override
    public String toString() {
        return getPaymentType();
    }
}