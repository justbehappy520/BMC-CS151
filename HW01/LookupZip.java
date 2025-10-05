import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class LookupZip {
    public static final int zip = 0, city = 1, state = 2, pop = 3, lat = 5, lon = 6;
    public static Place parseLine(ExpandableArray<Place> places, String line) {
        String[] input = line.split(",");
        PopulatedPlace popPlace;
        Place place;

        if (input.length > 3) {
            popPlace = new PopulatedPlace(input[zip], input[city], input[state],
            0.0, 0.0, Integer.parseInt(input[pop]));
            //System.out.println("asdf");
            return popPlace;
        }
        place = new Place(input[zip], input[city], input[state]);
        return place;
    }

    public static void updatePlace(ExpandableArray<Place> places, String line) {
        String[] input = line.split(",");
        String quote = input[zip].replace("\"", "");

        if (input[lat].compareTo("") != 0) {
            for (int i = 0; i < places.size(); i++) {
                if (places.get(i).getZip().equals(quote)) {
                    if (places.get(i) instanceof PopulatedPlace) {
                        ((PopulatedPlace) places.get(i)).setLat(Double.parseDouble(input[lat]));
                        ((PopulatedPlace) places.get(i)).setLong(Double.parseDouble(input[lon]));
                    }
                    else {
                        LocatedPlace locPlace = new LocatedPlace(quote, places.get(i).getTown(),
                        places.get(i).getState(), Double.parseDouble(input[lat]), Double.parseDouble(input[lon]));
                        places.set(locPlace, i);
                    }
                }
            }
        }
    }

    public static ExpandableArray<Place> readZipCodes(String filename,
    String filename2) throws FileNotFoundException {
        Scanner input1 = new Scanner(new File(filename));
        Scanner input2 = new Scanner(new File(filename2));
        ExpandableArray<Place> places = new ExpandableArray<Place>();
        String nextLine;

        input1.nextLine(); input2.nextLine();

        while (input1.hasNextLine()) {
            nextLine = input1.nextLine();
            places.insert(parseLine(places, nextLine));
        }
        input1.close();

        while (input2.hasNextLine()) {
            nextLine = input2.nextLine();
            updatePlace(places, nextLine);
        }
        input2.close();
        return places;
    }

    public static Place lookupZip(ExpandableArray<Place> places, String zip) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getZip().equals(zip)) {
                return places.get(i);
            }
        }
        return null;
    }
}
