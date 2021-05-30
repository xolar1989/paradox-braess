package rozproszone.lab.road.highway;

import rozproszone.lab.road.Road;

public class Highway extends Road {

    private final static int MAX_AMOUNT_OF_CARS = 100 ;

    public Highway(String source, String destination, int basicTime) {
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
