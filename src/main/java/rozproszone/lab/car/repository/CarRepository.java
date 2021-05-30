package rozproszone.lab.car.repository;

import rozproszone.lab.car.entity.Car;
import rozproszone.lab.road.repository.RoadRepository;

import java.util.LinkedList;
import java.util.List;

public class CarRepository {

    private final static int AMOUNT_OF_CARS = 10000 ;

    private final List<Car> carsList ;

    public CarRepository(RoadRepository roadRepository) {
        carsList = generateCars(roadRepository) ;
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    private List<Car> generateCars(RoadRepository roadRepository){
        List<Car> cars = new LinkedList<>() ;

        for (int i = 0; i <AMOUNT_OF_CARS ; i++) {
            Car car = Car.builder()
                    .number(i+1)
                    .roadRepository(roadRepository)
                    .build();
            cars.add(car) ;
        }
        return cars ;
    }


}
