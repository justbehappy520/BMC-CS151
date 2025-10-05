import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**Class with methods to parse through and read files with.  */
public class LookupZip {
    /**Index of zipcode in file. */
    public static final int ZIP = 0;
    /**Index of town in file. */
    public static final int CITY = 1;
    /**Index of state in file. */
    public static final int STATE = 2;
    /**Index of population in file. */
    public static final int POP = 3;
    /**Index of latitude in file. */
    public static final int LAT = 5;
    /**Index of longitude in file. */
    public static final int LON = 6;
    
    /**Parses each line of a file and reads in the information.
     * 
     * @param places ExpandableArray to parse lines to
     * @param line Line that is being parsed
     * @return Place object to be added to the ExpandableArray
     */
    public static Place parseLine(ExpandableArray<Place> places, String line) {
        String[] input = line.split(",");
        PopulatedPlace popPlace;
        Place place;

        if (input.length > 3) {
            popPlace = new PopulatedPlace(input[ZIP], input[CITY], input[STATE],
            0.0, 0.0, Integer.parseInt(input[POP]));
            return popPlace;
        }
        place = new Place(input[ZIP], input[CITY], input[STATE]);
        return place;
    }

    /**Updates the ExpandableArray when the second file is scanned in.
     * 
     * @param places The ExpandableArray to update
     * @param line The individual line of information being read in
     */
    public static void updatePlace(ExpandableArray<Place> places, String line) {
        String[] input = line.split(",");
        String quote = input[ZIP].replace("\"", "");

        if (input[LAT].compareTo("") != 0) {
            int lo = 0;
            int hi = places.size() - 1;
            
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                Place midPlace = places.get(mid);
                int compare = midPlace.getZip().compareTo(quote);
    
                if (compare == 0) {
                    if (midPlace instanceof PopulatedPlace) {
                        ((PopulatedPlace) midPlace).setLat(
                            Double.parseDouble(input[LAT]));
                        ((PopulatedPlace) midPlace).setLong(
                            Double.parseDouble(input[LON]));
                    }
                    else {
                        LocatedPlace locPlace = new LocatedPlace(quote,
                            midPlace.getTown(), midPlace.getState(),
                            Double.parseDouble(input[LAT]),
                            Double.parseDouble(input[LON]));
                        places.set(locPlace, mid);
                    }
                }
                if (compare < 0) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
        }
    }

    /**Takes two files and reads them into an ExpandableArray.
     * 
     * @param filename First file to be read
     * @param filename2 Second file to be read
     * @return ExpandableArray with the information from the files
     * @throws FileNotFoundException if the iles are not found
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

    /**Looks for a zipcode in the data base.
     * 
     * @param places Array form where to search
     * @param zip The thing to search for
     * @return Place object if found
     */
    public static Place lookupZip(ExpandableArray<Place> places, String zip) {
        int lo = 0;
        int hi = places.size() - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Place midPlace = places.get(mid);
            int compare = midPlace.getZip().compareTo(zip);

            if (compare == 0) {
                return midPlace;
            }
            else if (compare < 0) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return null;
    }
}