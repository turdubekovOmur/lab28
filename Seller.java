package lab28;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seller {
    Random random = new Random();
    private int money = random.nextInt(50)+50;            // Начальное количество денег от 50 до 100 монет
    private  int maxWeight = 200;                               // максимальный вес 200кг
    private int currentWeight = 0;
    private  int movementSpeed = (int) (Math.random()*(5-1)+1); // скорость передвижение от 1 до 5
    private List<Products> boughtProducts = new ArrayList<>();

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

//    // метод, который закупет продукт и дабавляет в телегу:
//    public List<Products> buyProduct(){
//        boughtProducts.add(getRandomProduct());
//      System.out.printf("Купил %s за %s, [состояние: %s], \n ",boughtProducts.get(0).getTypeOfProduct(),
//              boughtProducts.get(0).getPrice() , boughtProducts.get(0).getQuality() );
//      maxWeight  -= getRandomProduct().getWeight();
//      money -= getRandomProduct().getPrice();
//      boughtProducts.add(getRandomProduct());
//      return boughtProducts;
//    }

    public  void buyingProducts(){
        while (money > getRandomProduct().getPrice() || currentWeight < maxWeight){
            boughtProducts.add(getRandomProduct());
            money -= getRandomProduct().getPrice();
            currentWeight += getRandomProduct().getWeight();
        }
        System.out.println("Купил товары: ");
        boughtProducts.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Seller seller = new Seller();
        seller.buyingProducts();
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

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
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
