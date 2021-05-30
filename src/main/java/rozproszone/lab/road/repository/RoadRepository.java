package rozproszone.lab.road.repository;

import rozproszone.lab.road.Road;
import rozproszone.lab.road.highway.Highway;
import rozproszone.lab.road.localroad.LocalRoad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoadRepository {


    public List<Road> roads ;

    public RoadRepository(int amountOfRoads) {
        roads = new ArrayList<>(amountOfRoads) ;
        roads.add(new LocalRoad("A" ,"Y" ,20)) ;
        roads.add(new Highway("A" ,"X",40)) ;
        roads.add(new Highway("Y" ,"B",40)) ;
        roads.add(new LocalRoad("X" ,"B",20)) ;
        if (amountOfRoads == 5)
            roads.add(new Highway("Y" ,"X" ,10)) ;
    }

    public List<Road> getRoadsFromSource(String source){

        return roads.stream().filter(road -> road.getSource().equals(source)).collect(Collectors.toList());
    }

    public synchronized Road chooseTheBestRoad(List<Road> roads) throws Exception {
        if (roads.size() == 0) {
            throw new Exception("roads from which we had to choose is empty") ;
        }

        Road theBestRoad = roads.get(0);
        for (Road road:roads) {
            if(theBestRoad.expectedTimeForTravelling() > road.expectedTimeForTravelling()){
                theBestRoad = road;
            }
        }
        return theBestRoad ;
    }






}
