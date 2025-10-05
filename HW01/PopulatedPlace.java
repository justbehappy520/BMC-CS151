public class PopulatedPlace extends LocatedPlace {
    private int population;

    public PopulatedPlace() {}

    public PopulatedPlace(String zip, String town, String state,
    double latitude, double longitude, int population) {
        super(zip, town, state, latitude, longitude);
        this.population = population;
    }
    
    public int getPop() {
        return population;
    }

    public String toString() {
        return getTown() + ", " + getState() + " " + getLat() + " " + getLong()
        + " " + population;
    }
}