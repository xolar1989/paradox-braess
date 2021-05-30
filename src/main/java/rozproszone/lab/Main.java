package rozproszone.lab;

import rozproszone.lab.car.repository.CarRepository;
import rozproszone.lab.road.repository.RoadRepository;
import rozproszone.lab.traffic.service.TrafficService;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Time with 4 roads :");
        RoadRepository roadRepository = new RoadRepository(4) ;
        CarRepository carRepository = new CarRepository(roadRepository) ;


        TrafficService trafficService = new TrafficService(carRepository,roadRepository) ;

        trafficService.startTraffic();

        System.out.println("Time with 5 roads :");

        RoadRepository roadRepository2 = new RoadRepository(5) ;
        CarRepository carRepository2 = new CarRepository(roadRepository) ;


        TrafficService trafficService2 = new TrafficService(carRepository,roadRepository) ;

        trafficService2.startTraffic();


    }
}
