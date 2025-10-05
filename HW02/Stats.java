/**
 * Class to create Stats objects.
 */
public class Stats {
    private int year; // year of data
    private int rank; // rank of name for that year
    private int named; // # of babies w/ name

    // constructor methods
    /**
     * User set constructor for Stats object.
     * 
     * @param year of data
     * @param rank of name
     * @param num of babies w/ name
     */
    public Stats(int year, int rank, int named) {
        this.year = year;
        this.rank = rank;
        this.named = named;
    }

    // methods
    /**
     * Returns the value of variable year.
     * 
     * @return int year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the value of variable rank.
     * 
     * @return int rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the value of variable named.
     * 
     * @return int named
     */
    public int getNamed() {
        return named;
    }
}
