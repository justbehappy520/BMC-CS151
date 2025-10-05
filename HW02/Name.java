/**
 * Class to create Name objects.
 */
public class Name {
    private String name; // name
    private char gender; // M or F
    private ExpandableArray<Stats> stats; // array of years
    
    // constructor methods
    /**
     * Constructs user specified Name.
     * 
     * @param name name
     * @param gender of name
     */
    public Name(String name, char gender) {
        this.name = name;
        this.gender = gender;

        stats = new ExpandableArray<Stats>();
    }

    // methods
    /**
     * Getter method for priv variable name.
     * 
     * @return a name String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for priv variable gender.
     * 
     * @return a char M or F
     */
    public char getGender() {
        return gender;
    }

    /**
     * Returns the data of EA years.
     * 
     * @return a database on data attached to year
     */
    public ExpandableArray<Stats> getStats() {
        return stats;
    }

    /**
     * Return sum of all values of variable named.
     * 
     * @return int value of total # of babies w/ name
     */
    public int total() {
        int total = 0;
        for (int i = 0; i < stats.size(); i++) {
            total += stats.get(i).getNamed();
        }
        return total;
    }

    /**
     * Returns a string of Name data.
     * 
     * @return a string of the name and the gender
     */
    public String toString() {
        return name + ", " + gender;
    }
}