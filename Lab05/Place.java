public class Place {
    private String zip;
    private String town;
    private String state;

    /**
     * Creates a Place with the given zip, town name, and state
     * @param zip The 5-digit zip code
     * @param town The town name
     * @param state The state abbreviation
     */
    public Place(String zip, String town, String state) {
        this.zip = zip;
        this.town = town;
        this.state = state;
    }

    public Place() {}

    public String toString() {
        return town + ", " + state;
    }

    public String getZip() {
        return zip;
    }

    public String getTown() {
        return town;
    }

    public String getState() {
        return state;
    }
}