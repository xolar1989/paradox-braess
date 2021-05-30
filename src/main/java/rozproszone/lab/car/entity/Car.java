package rozproszone.lab.car.entity;


import lombok.*;

import rozproszone.lab.road.Road;
import rozproszone.lab.road.repository.RoadRepository;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Car implements Runnable {

    private int number;

    public RoadRepository roadRepository;


    @Override
    public void run() {
        String currentPosition = "A";
        while (!currentPosition.equals("B")) {
            try {
                Road road = getNewRoad(currentPosition);
                road.travel();
                currentPosition = road.getDestination();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public Road getNewRoad(String source) throws Exception {
        List<Road> roads = roadRepository.getRoadsFromSource(source);
        return roadRepository.chooseTheBestRoad(roads);
    }

}
