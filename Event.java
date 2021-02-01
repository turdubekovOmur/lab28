package lab28;

import java.util.Random;

public class Event {
    Random random = new Random();
    Seller seller;
    Products soldProducts;

    //  получаем случайные обстаятельства:
    public Events getRandomEvents() {
        int random = (int) (Math.random() * Events.values().length);
        return Events.values()[random];
    }

    // сделать что-то, если выпал какой-то обстаятельства:
    public int randomEvents() {
        switch (getRandomEvents()) {
            case NORMAL_DAY:
                System.out.println("День прошел как обычно. ");
                return seller.getMovementSpeed();
            case RAIN:
                System.out.println("Был дождь, пришлось ехать медленно...");
                double spoiledProductChance = random.nextInt();
                if (spoiledProductChance < 0.30){
                    seller.setBoughtProducts();
                }
                return seller.getMovementSpeed() -2;
            case SMOOTH_ROAD:
                System.out.println("Было идеальноя дорога!");
                if (seller.getMovementSpeed() <= 3){
                    return seller.getMovementSpeed()+2;
                }else{
                    return seller.getMovementSpeed();
                }
            case BROKEN_WHEEL:
                System.out.println("Спустило шину, целый день искал вулканизацию!");
               return 0;
            case RIVER:
                System.out.println("Целый день потратил на поиски моста, чтобы перейти через канал.");
                return 0;
            case MEET_LOCAL:
                System.out.println("Удалось встретить местного алкаша, он согласился за бутылку показать короткую дорогу!");
                return seller.getMovementSpeed() + (int) (Math.random() * (6 - 3) + 1);
            case ROBBERS:
                System.out.println("Видимо мне не фортануло сегодня, встретил местных гопников. Отжали половину бюджета!");
                return seller.setMoney(seller.getMoney() / 2);
            case PUB:
                int pubChance = random.nextInt();
                if (pubChance > 0.50){
                    soldProducts = seller.getRandomProduct();
                    System.out.printf("Удалось продать товар %s на борохолке \n", soldProducts);
                    // -4 money for a food and hotel:
                    return  (seller.getMoney() + soldProducts.getPrice()) - 4;
                }else{
                    return seller.getMovementSpeed();
                }

            case SPOILED:
                System.out.printf("Товар %s испортился \n", seller.getRandomProduct().getTypeOfProduct());
                seller.getRandomProduct().setQuality(Quality.TRASH);

            default:
                throw new IllegalStateException("Unexpected value: " + getRandomEvents());
        }

    }

}
