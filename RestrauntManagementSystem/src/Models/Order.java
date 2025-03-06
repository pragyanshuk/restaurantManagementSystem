package Models;

public class Order {
    private Item item;
    private int quantity;
    private int tableNo;

    public Order(){

    }
    public Order(Item item,int quantity,int tableNo){
        this.item = item;
        this.quantity = quantity;
        this.tableNo = tableNo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
}
