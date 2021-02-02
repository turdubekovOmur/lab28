package lab28;

public class Main {
    public static void main(String[] args) {
        Seller seller = new Seller();
        City city = new City();
        Event event = new Event();
         int day = 0;
         int goal;

        seller.buyingProducts();
         while (city.getDistance() > 0){
             day+=1;
             int a = city.getDistance()- seller.getMovementSpeed();
             System.out.printf("День %s: \n", day);
             event.randomEvents();

             goal = city.setDistance(a) ;

             System.out.printf("Осталось %s км до города. \n", goal );
             System.out.println();

         }







    }
}
