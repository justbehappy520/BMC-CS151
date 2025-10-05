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
     * @param places AVLTree to parse lines to
     * @param line Line that is being parsed
     * @return Place object to be added to the AVLTree
     */
    public static Place parseLine(AVLTree<Place> places, String line) {
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

    /**Updates the AVLTree when the second file is scanned in.
     * 
     * @param places The AVLTree to update
     * @param line The individual line of information being read in
     */
    public static void updatePlace(AVLTree<Place> places, String line) {
        String[] input = line.split(",");
        String quote = input[ZIP].replace("\"", "");

        if (input[LAT].compareTo("") != 0) {
            //LinkedBinaryTree<Place>.Node<Place> node = places.getRoot();
            //int lo = 0;
            //int hi = places.size() - 1;
            Place place = places.get(new Place(quote, "", ""));
            if (place != null) { // Place is found
                if (place instanceof PopulatedPlace) {
                    ((PopulatedPlace) place).setLat(
                        Double.parseDouble(input[LAT]));
                    ((PopulatedPlace) place).setLong(
                        Double.parseDouble(input[LON]));
                } else {
                    LocatedPlace locPlace = new LocatedPlace(quote,
                        place.getTown(), place.getState(),
                        Double.parseDouble(input[LAT]),
                        Double.parseDouble(input[LON]));
                    places.insert(locPlace);
                }
            }
        }
    }

    /**Takes two files and reads them into an AVLTree.
     * 
     * @param filename First file to be read
     * @param filename2 Second file to be read
     * @return AVLTree with the information from the files
     * @throws FileNotFoundException if the iles are not found
     */
    public static AVLTree<Place> readZipCodes(String filename,
        String filename2) throws FileNotFoundException {
        Scanner input1 = new Scanner(new File(filename));
        Scanner input2 = new Scanner(new File(filename2));
        AVLTree<Place> places = new AVLTree<Place>();
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
     * @param places AVLTree form where to search
     * @param zip The thing to search for
     * @return Place object if found
     */
    public static Place lookupZip(AVLTree<Place> places, String zip) {
        // start from the root
        LinkedBinaryTree<Place>.Node<Place> node = places.getRoot();
        //int lo = 0;
        //int hi = places.size() - 1;
        
        while (node != null) {
            //int mid = lo + (hi - lo) / 2;
            Place currPlace = node.getData();
            int compare = currPlace.getZip().compareTo(zip);

            if (compare == 0) { // found zipcode
                return currPlace;
            }
            if (compare < 0) { // zipcode is bigger
                node = node.getRight();
            }
            if (compare > 0) { // zipcode is smaller
                node = node.getLeft();
            }
        }
        // zipcode not found
        return null;
    }
}