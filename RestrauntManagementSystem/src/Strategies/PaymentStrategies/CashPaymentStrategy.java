package Strategies.PaymentStrategies;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void payBill(double amount) {
        System.out.println("Cash Payment Successful for amount : " + amount);
    }
}
