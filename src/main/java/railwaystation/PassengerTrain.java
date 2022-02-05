package railwaystation;

public class PassengerTrain extends Train{

    private boolean hasDiningCar;
    final static int CAPACITY = 70;

    public PassengerTrain(int numberOfWagons) {
        super(numberOfWagons);
        this.hasDiningCar = false;
    }

    public PassengerTrain(String name, int numberOfWagons) {
        super(name, numberOfWagons);
        this.hasDiningCar = true;
    }

    @Override
    public int calculateTravellingPeople() {
        if (hasDiningCar) {
            return CAPACITY * (getNumberOfWagons()-1);
        } else {
            return CAPACITY * getNumberOfWagons();
        }
    }

    public boolean hasDiningCar() {
        return hasDiningCar;
    }
}
