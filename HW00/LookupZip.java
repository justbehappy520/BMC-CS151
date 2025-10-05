import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class LookupZip {
    /**
     * Parses one line of input by creating a Place that
     * denotes the information in the given line
     * @param line One line from the zipcodes file
     * @return A Place that contains the relevant information
     * (zip code, town, state) from that line
     */
    public static Place parseLine(String line) {
        String[] lineInput = line.split(",");
        Place place = new Place(lineInput[0], lineInput[1], lineInput[2]);
        return place;
    }

    /**
     * Reads a zipcodes file, parsing every line
     * @param filename The name of the zipcodes file
     * @param numEntries the number of places in the csv file
     * @return The array of Places representing all the
     * data in the file.
     */
    public static Place[] readZipCodes(String filename, int numEntries) throws 
    FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        String nextLine;
        Place[] placeDB = new Place[numEntries];
        int counter = 0;
        input.nextLine();

        while (input.hasNextLine()) {
            nextLine = input.nextLine();

            placeDB[counter] = parseLine(nextLine);
            counter++;
            //String[] lineInput = nextLine.split(",");
            /*for (int i = 0; i < numEntries; ) {
                placeDB[i] = new Place(lineInput[0], lineInput[1], 
                lineInput[2]);
                break;
                */
        }
        input.close();
        return placeDB;
    }

    /**
     * Find a Place with a given zip code
     * @param places The array of Place objects to search through
     * @param zip The zip code (as a String) to look up
     * @return A place that matches the given zip code,
     * or null if no such place exists.
     */
    public static Place lookupZip(Place[] places, String zip) {
        //Place place = null;

        for (int i = 0; i < places.length; i++) {
            if (places[i].getZip().equals(zip)) {
                //place = places[i];
                return places[i];
            }
        }
        return null;
    }
}