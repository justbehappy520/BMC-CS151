import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/** 
 * Has methods parseLine, updatePlace, readZipcodes, and lookupZip.
 * Stores and manages an ExpandableArray of Place objects.
 */
public class LookupZip {
    
    /** Reads information from param line, creates a new Place object, appends
     * Place object to the end of the ExapandableArray.
     * 
     * @param places ExpandableArray of Place objects
     * @param line Specific line read in from the csv file
     * @return Place object created from info taken from param line
     */
    public static Place parseLine(ExpandableArray<Place> places, String line) {
        int zip = 0;
        int city = 1;
        int state = 2;
        int pop = 3;

        String[] input = line.split(",");
        PopulatedPlace popPlace;
        Place place;

        if (input.length > 3) {
            popPlace = new PopulatedPlace(input[zip], input[city], input[state],
            0.0, 0.0, Integer.parseInt(input[pop]));
            return popPlace;
        }
        place = new Place(input[zip], input[city], input[state]);
        return place;
    }

    /** Updates Place objects without lat and lon args.
     * 
     * @param places ExpandableArray in which to modify the Place objects
     * @param line Specific line read in from the csv file
     */
    public static void updatePlace(ExpandableArray<Place> places, String line) {
        int zip = 0;
        int lat = 5;
        int lon = 6;

        String[] input = line.split(",");
        String quote = input[zip].replace("\"", "");

        if (input[lat].compareTo("") != 0) {
            for (int i = 0; i < places.size(); i++) {
                if (places.get(i).getZip().equals(quote)) {
                    if (places.get(i) instanceof PopulatedPlace) {
                        ((PopulatedPlace) places.get(i)).setLat(
                            Double.parseDouble(input[lat]));
                        ((PopulatedPlace) places.get(i)).setLong(
                            Double.parseDouble(input[lon]));
                    }
                    else {
                        LocatedPlace locPlace = new LocatedPlace(quote, 
                            places.get(i).getTown(), places.get(i).getState(),
                            Double.parseDouble(input[lat]), 
                            Double.parseDouble(input[lon]));
                        places.set(locPlace, i);
                    }
                }
            }
        }
    }

    /** Reads in the param files and parses each line to consolidate the
     * information into an ExpandableArray of Place objects.
     * 
     * @param filename Name of first file to parse
     * @param filename2 Name of second file to parse
     * @return ExpandableArray of Place objects made from files
     * @throws FileNotFoundException Thro
     */
    public static ExpandableArray<Place> readZipCodes(String filename,
        String filename2) throws FileNotFoundException {
        Scanner input1 = new Scanner(new File(filename));
        Scanner input2 = new Scanner(new File(filename2));
        ExpandableArray<Place> places = new ExpandableArray<Place>();
        String nextLine;

        input1.nextLine();
        input2.nextLine();

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

    /** Searches the param ExpandableArray for a given Place object based on
     * param zip.
     * 
     * @param places ExpandableArray of Place objects to search for a Place
     * @param zip String of numbers to use to search for a Place
     * @return Place object containing param zip
     */
    public static Place lookupZip(ExpandableArray<Place> places, String zip) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getZip().equals(zip)) {
                return places.get(i);
            }
        }
        return null;
    }
}