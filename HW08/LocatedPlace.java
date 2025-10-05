/**Class that creates a LocatedPlace object. */
public class LocatedPlace extends Place {
    private double latitude;
    private double longitude;

    /**Default constructor. */
    public LocatedPlace() {}

    /**
     * Creates a LocatedPlace with the given zip, town name,
     * state, latitude, and longitude.
     * @param zip The 5-digit zip code
     * @param town The town name
     * @param state The state abbreviation
     * @param latitude The latitude of the place
     * @param longitude The longitude of the place
     */
    public LocatedPlace(String zip, String town, String state,
        double latitude, double longitude) {
        super(zip, town, state);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**Returns the latitude of the place.
     * 
     * @return double value of the latitude
     */
    public double getLat() {
        return latitude;
    }

    /**Return the longitude of the place.
     * 
     * @return double value of the longitude.
     */
    public double getLong() {
        return longitude;
    }

    /**Sets the latitude for a place.
     * 
     * @param lat New latitude
     */
    public void setLat(double lat) {
        this.latitude = lat;
    }
    
    /**Sets the longitude for a place.
     * 
     * @param lon New longitude
     */
    public void setLong(double lon) {
        this.longitude = lon;
    }

    /**Returns a String of the place's location. 
     * 
     * @return String of town, state and lat and long
     */
    public String toStringRegular() {
        return getTown() + ", " + getState() + " " + latitude + " " + longitude;
    }

    public String toString() {
        return getZip();
    }
}