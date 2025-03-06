package Models;

public class Item {
    private String name;
    private double price;
    private FoodType foodType;
    private Category category;


    private Item(){

    }


    public static class Builder{
        private String name;
        private double price;
        private FoodType foodType;
        private Category category;

        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setPrice(double price){
            this.price = price;
            return this;
        }
        public Builder setFoodType(FoodType foodType){
            this.foodType = foodType;
            return this;
        }
        public Builder setCategory(Category category){
            this.category = category;
            return this;
        }

        public Item build(){
            Item item = new Item();
            item.setName(this.name);
            item.setPrice(this.price);
            item.setFoodType(this.foodType);
            item.setCategory(this.category);
            return item;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
