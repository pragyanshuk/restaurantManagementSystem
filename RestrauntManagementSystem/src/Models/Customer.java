package Models;

import Factories.PaymentFactory.PaymentStrategyFactory;
import Strategies.PaymentStrategies.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int tableNo;
    private PaymentStrategy paymentStrategy;
    private Restaurant restaurant;

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Customer(Restaurant restaurant, PaymentType paymentType) throws Exception {
        this.tableNo = restaurant.assignTable();
        if(this.tableNo == -1){
            throw new Exception("Sorry , All tables are occupied");
        }
        this.paymentStrategy = new PaymentStrategyFactory().choosePaymentModel(paymentType);
        this.restaurant = restaurant;
    }

    public List<Item> browseMenuViaFilter(FoodType foodType,Category category){
        List<Item> fullMenu = restaurant.getMenu();
        List<Item> filteredMenu = new ArrayList<>();
        for(Item item :fullMenu){
            if(item.getFoodType() == foodType && item.getCategory() == category){
                filteredMenu.add(item);
            }
        }
        return filteredMenu;
    }

    public void placeOrder(List<Order> orders){
        restaurant.placeOrder(orders,this.tableNo);
    }

    public double getBill(){
        return restaurant.getBill(this.tableNo);
    }

    public void payBill(double amount){
        this.paymentStrategy.payBill(amount);
    }
}
