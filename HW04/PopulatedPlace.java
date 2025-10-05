/**Class to create a PopulatedPlace object. */
public class PopulatedPlace extends LocatedPlace {
    private int population;

    /**Default constructor. */
    public PopulatedPlace() {}

    /**Constructor with detailed information.
     * 
     * @param zip Zipcode of a place
     * @param town Town name of a place
     * @param state State name of a place
     * @param latitude Latitude of a place
     * @param longitude Longitude of a place
     * @param population Population of a place
     */
    public PopulatedPlace(String zip, String town, String state,
        double latitude, double longitude, int population) {
        super(zip, town, state, latitude, longitude);
        this.population = population;
    }
    
    /**Returns the population of a place.
     * 
     * @return Population
     */
    public int getPop() {
        return population;
    }

    /**Returns a string of all information of a place.
     * @return String with town, state and lat, long, population
     */
    public String toString() {
        return getTown() + ", " + getState() + " " + getLat() + " " + getLong()
            + " " + population;
    }
}