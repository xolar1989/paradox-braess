package rozproszone.lab.road.localroad;

import rozproszone.lab.road.Road;

public class LocalRoad extends Road {

    private final static int MAX_AMOUNT_OF_CARS = 10 ;

    public LocalRoad(String source, String destination , int basicTime) {
        super(source, destination, basicTime);
    }

    @Override
    public void travel() throws InterruptedException {

        long p = super.timeInQueue(MAX_AMOUNT_OF_CARS) ;
        incrementAmountCars();
        updateTime(p);
        Thread.sleep(getBasicTime());
        decrementAmountCars();
        notification();
    }

}
