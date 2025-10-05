public class Trio implements Comparable<Trio> {
    private String name;
    private double price;

    public Trio() {}

    public Trio(Sandwich sandwich, Salad salad, Drink drink) throws IllegalTrioException {
        if (sandwich.getPrice() == salad.getPrice() && 
        salad.getPrice() == drink.getPrice()) {
            throw new IllegalTrioException("Illegal trio detected!");
        }

        this.name = sandwich.getName() + "/" + salad.getName() + "/" + drink.getName();
        if (sandwich.getPrice() >= salad.getPrice() && 
        salad.getPrice() >= drink.getPrice()) {
            this.price = sandwich.getPrice() + salad.getPrice();
        }
        else if (salad.getPrice() >= drink.getPrice() && 
        drink.getPrice() >= sandwich.getPrice()) {
            this.price = salad.getPrice() + drink.getPrice();
        }
        else if (drink.getPrice() >= sandwich.getPrice() && 
        sandwich.getPrice() >= salad.getPrice()) {
            this.price = drink.getPrice() + sandwich.getPrice();
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int compareTo(Trio trio) {
        if (price > trio.getPrice()) {
            return 1;
        }
        else if (price < trio.getPrice()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
