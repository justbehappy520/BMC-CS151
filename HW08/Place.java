/**Class that creates a Place object. */
public class Place implements Comparable<Place> {
    private String zip;
    private String town;
    private String state;

    /**
     * Creates a Place with the given zip, town name, and state.
     * @param zip The 5-digit zip code
     * @param town The town name
     * @param state The state abbreviation
     */
    public Place(String zip, String town, String state) {
        this.zip = zip;
        this.town = town;
        this.state = state;
    }

    /**Default constructor. */
    public Place() {}

    /**Prints out a Place.
     * @return String of town, state
     */
    public String toStringRegular() {
        return town + ", " + state;
    }

    public String toString() {
        return zip;
    }

    /**Returns zipcode of Place.
     * @return String of zipcode
     */
    public String getZip() {
        return zip;
    }

    /**Returns town name of Place.
     * @return String name of town
     */
    public String getTown() {
        return town;
    }

    /**Returns which state Place is in. 
     * @return String name of state
     */
    public String getState() {
        return state;
    }

    /**Returns comparison value of two Place objects.
     * @param place Place object being compared
     * @return int comparison value
     */
    @Override
    public int compareTo(Place place) {
        return zip.compareTo(place.getZip());
    }
}