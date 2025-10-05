public class LocatedPlace extends Place {
    private double latitude;
    private double longitude;

    public LocatedPlace() {}

    public LocatedPlace(String zip, String town, String state,
    double latitude, double longitude) {
        super(zip, town, state);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLat() {
        return latitude;
    }

    public double getLong() {
        return longitude;
    }

    public void setLat(double lat) {
        this.latitude = lat;
    }

    public void setLong(double lon) {
        this.longitude = lon;
    }

    public String toString() {
        return getTown() + ", " + getState() + " " + latitude + " " + longitude;
    }
}