package lab28;

import java.util.List;
import java.util.Random;

public class Event extends Seller {
//    Random random = new Random();
    private Products soldProducts = new Products();
    private int day = 0;


    //  получаем случайные обстаятельства:
    private Events getRandomEvents() {
        int random = (int) (Math.random() * Events.values().length);
        return Events.values()[random];
    }

    // сделать что-то, если выпал какой-то обстаятельства:
    public void randomEvents() {
        switch (getRandomEvents()) {
            case NORMAL_DAY:
                System.out.println("День прошел как обычно. ");
                getMovementSpeed();
                break;
            case RAIN:
                System.out.println("Был дождь, пришлось ехать медленно...");
                double spoiledProductChance = new Random().nextInt();
                if (spoiledProductChance < 0.30){

                }
                setMovementSpeed(1);
                break;
            case SMOOTH_ROAD:
                System.out.println("Было идеальноя дорога!");
                if (getMovementSpeed() <= 4){
                    setMovementSpeed(5);
                    break;
                }else{
                    System.out.println("Было идеальноя дорога!");
                     getMovementSpeed();
                     break;
                }
            case BROKEN_WHEEL:
                System.out.println("Спустило шину, целый день искал вулканизацию!");
                setMovementSpeed(0);
                break;
            case RIVER:
                System.out.println("Целый день потратил на поиски моста, чтобы перейти через канал.");
                break;
            case MEET_LOCAL:
                System.out.println("Удалось встретить местного алкаша, он согласился за бутылку показать короткую дорогу!");
                setMovementSpeed(6);
                break;
            case ROBBERS:
                System.out.println("Видимо мне не фортануло сегодня, встретил местных гопников. Отжали половину бюджета!");
                 setMoney(getMoney() / 2);
                 break;
            case PUB:
                int pubChance = new Random().nextInt();
                if (pubChance > 0.50){
                    soldProducts = getRandomProduct();
                    System.out.printf("Удалось продать товар %s на борохолке \n", soldProducts);
                    // -4 money for a food and hotel:
//                    setMoney(soldProducts.getPrice()) - 4
                      getMovementSpeed();
                      break;
                }else{
                    System.out.println("проехал мимо паба, ибо нет времени не местных чаек");
                     getMovementSpeed();
                     break;
                }
        }

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
