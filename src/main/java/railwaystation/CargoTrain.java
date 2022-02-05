package railwaystation;

public class CargoTrain extends Train{

    public CargoTrain(int numberOfWagons) {
        super(numberOfWagons);
    }

    @Override
    public int calculateTravellingPeople() {
        return Math.max(1, getNumberOfWagons() / 10);
    }
}
