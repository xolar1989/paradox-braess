package rozproszone.lab;

import rozproszone.lab.car.repository.CarRepository;
import rozproszone.lab.road.repository.RoadRepository;
import rozproszone.lab.traffic.service.TrafficService;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RoadRepository roadRepository = new RoadRepository(5) ;
        CarRepository carRepository = new CarRepository(roadRepository) ;


        TrafficService trafficService = new TrafficService(carRepository,roadRepository) ;

        trafficService.startTraffic();
    }
}
