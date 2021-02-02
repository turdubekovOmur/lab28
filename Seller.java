package lab28;

import java.util.ArrayList;
import java.util.List;

public class Seller{
//    Random random = new Random();
    private int money = 100;         // Начальное количество денег от 50 до 100 монет
    private  int maxWeight = 200;                               // максимальный вес 200кг
    private int currentWeight = 0;
    private  int movementSpeed = 3;  // скорость передвижения
    private int untilCityDistance = 0;
    private List<Products> boughtProducts = new ArrayList<>();  // товары в телеге
    private City city = new City();
//    private Event event = new Event();

    // массив товаров, из которых мы будем покуть случайные товары перед въездом:
    Products[] products = {
            Products.makeProduct(TypeOfProduct.DRIED_FRUITS,20,13,Quality.NORMAL),
            Products.makeProduct(TypeOfProduct.MEAT,40,7,Quality.NORMAL),
            Products.makeProduct(TypeOfProduct.GRAIN,50,15,Quality.NORMAL),
            Products.makeProduct(TypeOfProduct.FLOUR,50,43,Quality.NORMAL),
            Products.makeProduct(TypeOfProduct.PAINT,10,11,Quality.NORMAL),
    };

    // Получаем случайный продукт из массива:
    public Products getRandomProduct() {
        int random = (int) (Math.random() * products.length);
        return products[random];
    }

    // выбранные товары будут дабавлены в List
    public  void buyingProducts(){
        while (money > getRandomProduct().getPrice() || currentWeight < maxWeight){
            boughtProducts.add(getRandomProduct());
            money -= getRandomProduct().getPrice();
            currentWeight += getRandomProduct().getWeight();
        }
        System.out.println("Купил товары: ");
        boughtProducts.forEach(System.out::println);
        System.out.printf("Осталось %s монет \n", money);
        System.out.println("___________________________________________________________________");
    }

    public int getMoney() {
        return money;
    }

    public int setMoney(int money) {
        this.money = money;
        return money;
    }

    public Products[] getProducts() {
        return products;
    }

    public void setProducts(Products[] products) {
        this.products = products;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
        return movementSpeed;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public List<Products> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<Products> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

}
