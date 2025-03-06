package Strategies.PaymentStrategies;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void payBill(double amount) {
        System.out.println("Card Payment Successful for amount : " + amount);
    }
}
