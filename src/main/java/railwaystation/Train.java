package railwaystation;

public abstract class Train {

    private String name;
    private int numberOfWagons;
    final static int LENGTH_OF_WAGON = 15;

    public Train(int numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public Train(String name, int numberOfWagons) {
        this.name = name;
        this.numberOfWagons = numberOfWagons;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfWagons(int numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public int getTotalLength() {
        return numberOfWagons * LENGTH_OF_WAGON;
    }

    public abstract int calculateTravellingPeople();
}
