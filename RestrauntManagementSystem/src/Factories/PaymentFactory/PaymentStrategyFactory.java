package Factories.PaymentFactory;

import Models.PaymentType;
import Strategies.PaymentStrategies.CardPaymentStrategy;
import Strategies.PaymentStrategies.CashPaymentStrategy;
import Strategies.PaymentStrategies.OnlinePaymentStrategy;
import Strategies.PaymentStrategies.PaymentStrategy;

public class PaymentStrategyFactory {
    public PaymentStrategy choosePaymentModel(PaymentType paymentType) throws Exception {
        switch (paymentType){
            case CASH -> {
                return new CashPaymentStrategy();
            }
            case CARD -> {
                return new CardPaymentStrategy();
            }
            case ONLINE -> {
                return new OnlinePaymentStrategy();
            }
        }
        throw new Exception("invalid payment type");
    }
}
