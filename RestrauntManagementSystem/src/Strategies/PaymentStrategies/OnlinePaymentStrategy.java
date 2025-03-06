package Strategies.PaymentStrategies;

public class OnlinePaymentStrategy implements PaymentStrategy{
    @Override
    public void payBill(double amount) {
        System.out.println("Online Payment Successful for amount : " +amount);
    }
}
