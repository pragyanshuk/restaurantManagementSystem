package Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int noOfTable;
    private List<Integer> tables;
    private List<Item> menu;
    private List<Order> orders;

    public int getNoOfTable() {
        return noOfTable;
    }

    public void setNoOfTable(int noOfTable) {
        this.noOfTable = noOfTable;
    }

    public List<Integer> getTables() {
        return tables;
    }

    public void setTables(List<Integer> tables) {
        this.tables = tables;
    }

    public List<Item> getMenu() {
        return menu;
    }

    public void setMenu(List<Item> menu) {
        this.menu = menu;
    }

    private Restaurant(){
        this.tables = new ArrayList<>();
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public static class Builder{
        private int noOfTable;
        private List<Item> menu;

        public Builder(){
            this.menu = new ArrayList<>();
        }

        public Builder setTotalTable(int cnt){
            this.noOfTable = cnt;
            return this;
        }

        public Builder addItem(Item item){
            this.menu.add(item);
            return this;
        }

        public Restaurant build(){
            Restaurant restaurant = new Restaurant();
            restaurant.noOfTable = this.noOfTable;
            for(int i=0;i<this.noOfTable;i++){
                restaurant.tables.add(0);
            }
            restaurant.menu = this.menu;
            return restaurant;
        }
    }

    public int assignTable(){
        for(int i=0;i<noOfTable;i++){
            if(tables.get(i) == 0){
                tables.set(i, 1);
                return i;
            }
        }
        return -1;
    }

    public void placeOrder(List<Order>orders , int tableNo){
        for(Order order : orders){
            order.setTableNo(tableNo);
            this.orders.add(order);
        }
        System.out.println("Order successfully placed");
    }

    public double getBill(int tableNo){
        double totalBill = 0.0;
        for(Order order : this.orders){
            if(order.getTableNo() == tableNo){
                totalBill += order.getItem().getPrice()* order.getQuantity();
            }
        }
        return totalBill;
    }
}
