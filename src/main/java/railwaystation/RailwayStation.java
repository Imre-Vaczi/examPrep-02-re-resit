package railwaystation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RailwayStation {

    private List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return List.copyOf(trains);
    }

    public void addTrain(Train train) {
        if (trains.size() < 10) {
            trains.add(train);
        } else {
            throw new IllegalArgumentException("Too much trains!");
        }
    }

    public Train getLongestTrain() {
        return trains.stream()
                .max(Comparator.comparing(Train::getTotalLength))
                .get();
    }

    public int getHowManyTrainsHaveName() {
        return trains.stream()
                .filter(t -> t.getName() != null)
                .toList()
                .size();
    }

    public List<Train> getTrainsWithPassengersMoreThan(int threshold) {
        return trains.stream()
                .filter(t -> t.calculateTravellingPeople() > threshold)
                .toList();
    }
}
