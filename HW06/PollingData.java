/**
 * A class that implements the Comparable<E> class to create
 * a PollingData. PollingData stores the polling data from the
 * csv files.
 */
public class PollingData implements Comparable<PollingData> {

    // private instance variables
    private String lastName; // candidate's last name
    private String fullName; // candidate's full name
    private Double percent; // candidate's polling percentage

    // constructor methods
    /**
     * Default constructor for PollingData.
     */
    public PollingData() {}

    /**
     * User-implemented constructor for PollingData.
     * 
     * @param lastName is the candidate's last name
     * @param fullName is the candidate's full name
     * @param percent is the candidate's polling percentage
     */
    public PollingData(String lastName, String fullName, double percent) {
        this.lastName = lastName;
        this.fullName = fullName;
        this.percent = percent;
    }

    // methods
    /**
     * Returns the candidate's last name.
     * 
     * @return instance variable lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the candidate's full name.
     * 
     * @return instance variable fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns the candidate's polling percentage.
     * 
     * @return instance variable percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * Returns a String of the data in the PollingData.
     * 
     * @return the candidate's full name and polling percentage
     */
    @Override
    public String toString() {
        return fullName + ":" + percent;
    }

    // Comparable methods to be implemented
    /**
     * Returns a value based on the comparison of two objects.
     * 
     * @param comparable is the element being compared
     * @return 0 if the two are equal, negative integer if
     * the param is less than the other object, positive
     * integer if the param is greater than the other object.
     */
    public int compareTo(PollingData comparable) {
        return this.lastName.compareTo(comparable.getLastName());
    }

    /**
     * Returns a value based on the comparison of two objects.
     * 
     * @param comparable is the other PollingData object to compare to
     * @return 0 if the two are equal, negative integer if
     * the param is less than the other object, positive
     * integer if the param is greater than the other object.
     */
    public int compareLastName(PollingData other) {
        return this.lastName.compareTo(other.lastName);
    }
}
