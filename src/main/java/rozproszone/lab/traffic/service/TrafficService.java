package rozproszone.lab.traffic.service;

import rozproszone.lab.car.entity.Car;
import rozproszone.lab.car.repository.CarRepository;
import rozproszone.lab.road.repository.RoadRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TrafficService {

    private CarRepository carRepository ;

    private RoadRepository roadsRepository ;

    public TrafficService(CarRepository carRepository, RoadRepository roadsRepository) {
        this.carRepository = carRepository;
        this.roadsRepository = roadsRepository;
    }

    public void startTraffic() throws InterruptedException {

        List<Car> cars = carRepository.getCarsList() ;
        List<Thread> threads = new ArrayList<>(cars.size()) ;
        for (Car car:cars) {
            threads.add(new Thread(car)) ;
        }


        long startTimeInQueue = new Date().getTime() ;
        for (Thread thread:threads) {
//            Thread.sleep(1);
            thread.start();
        }

        for (Thread thread:threads) {
            thread.join();
        }
        long endTimeInQueue = new Date().getTime() ;
        long timeInQueue =  endTimeInQueue-startTimeInQueue ;
        System.out.println((double)timeInQueue/1000);
    }



}
