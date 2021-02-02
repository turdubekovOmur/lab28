package lab28;

import java.util.Random;

public class City {
    private Random rnd = new Random();
    private  int distance = rnd.nextInt(50)+50;
    private Towns towns;


    public int getDistance() {
        return distance;
    }

    public int setDistance(int distance) {
        this.distance = distance;
        return distance;
    }
}
