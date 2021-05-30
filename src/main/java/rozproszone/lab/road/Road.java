package rozproszone.lab.road;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class Road {

    private String source;

    private String destination;

    private int basicTime;

    public int currentAmountCars;

    private long amountTime;

    public int amountOfCarsPassed;

    public synchronized void incrementAmountCars() {
        currentAmountCars++;
    }

    public synchronized void decrementAmountCars() {
        currentAmountCars--;
    }

    private int carsInQueue;

    public Road(String source, String destination, int basicTime) {
        this.source = source;
        this.destination = destination;
        this.basicTime = basicTime;
        currentAmountCars = 0;
        amountOfCarsPassed = 1;
        amountTime = basicTime ;
    }

    public abstract void travel() throws InterruptedException;

    public double expectedTimeForTravelling(){
        return (double) amountTime / amountOfCarsPassed;
    };

    public synchronized void notification() {
        notifyAll();
    }

    public synchronized void updateTime(long time){
        amountOfCarsPassed++;
        amountTime += time+getBasicTime();
    }


    public synchronized long timeInQueue(int MAX_AMOUNT_OF_CARS) throws InterruptedException {
        if (currentAmountCars < MAX_AMOUNT_OF_CARS)
            return 0;
        carsInQueue++;
        long startTimeInQueue = new Date().getTime();

        while (currentAmountCars >= MAX_AMOUNT_OF_CARS) {
            wait();
        }
        long endTimeInQueue = new Date().getTime();
        long timeInQueue = endTimeInQueue - startTimeInQueue;
        carsInQueue--;


        return timeInQueue;
    }


}
