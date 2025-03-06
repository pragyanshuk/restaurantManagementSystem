import Models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant.Builder()
                .setTotalTable(3)
                .addItem(new Item.Builder()
                        .setName("Chinese")
                        .setPrice(149.0)
                        .setFoodType(FoodType.VEG)
                        .setCategory(Category.STARTER)
                        .build())
                .addItem(new Item.Builder()
                        .setName("ButterChicken")
                        .setPrice(399.0)
                        .setFoodType(FoodType.NON_VEG)
                        .setCategory(Category.MAIN_COURSE)
                        .build())
                .addItem(new Item.Builder()
                        .setName("Chocolate IceCream")
                        .setPrice(99.0)
                        .setFoodType(FoodType.VEG)
                        .setCategory(Category.DESSERT)
                        .build())
                .build();

        try {
            Customer customer1 = new Customer(restaurant, PaymentType.CASH);
            Customer customer2 = new Customer(restaurant, PaymentType.CARD);
            Customer customer3 = new Customer(restaurant, PaymentType.ONLINE);
            //Customer customer4 = new Customer(restaurant, PaymentType.CASH);

            List<Item> menu = customer1.browseMenuViaFilter(FoodType.NON_VEG,Category.MAIN_COURSE);
            for(Item item : menu){
                System.out.println(item.getName());
            }

            Order order = new Order(menu.get(0),2,customer1.getTableNo());
            List<Order> orders = new ArrayList<>();
            orders.add(order);
            customer1.placeOrder(orders);

            double bill = customer1.getBill();
            System.out.println(bill);

            customer1.payBill(bill);

        } catch (Exception e){
            System.out.println("No more customers allowed");
        }



        System.out.println("Nice having you , have a nice day :))");
    }
}