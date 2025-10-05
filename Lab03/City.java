public class City {
    private String name;
    private int pop;

    public City(String name, int pop) {
        this.name = name;
        this.pop = pop;
    }

    public City() {}

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return pop;
    }

    public String toString() {
        return name + " (" + pop + " pop)";
    }
}
