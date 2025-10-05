import java.io.FileNotFoundException;
import java.util.Scanner;

/**Class to lookup zipcodes from the directories. */
public class DriverHW08 {
    /**Main method of DriverHW04.
     * @param args Filenames
     * @throws FileNotFoundException throws when file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // filenames
        String file = "";
        String file2 = "";
        boolean debug = false;

        // check for flags
        if (args[0].equals("-d")) {
            debug = true;
            file = args[1];
            file2 = args[2];
        } else {
            file = args[0];
            file2 = args[1];
        }
        System.out.println(file);

        // scan in files
        Scanner in = new Scanner(System.in);
        AVLTree<Place> locations;
        locations = LookupZip.readZipCodes(file, file2);

        if (debug) {
            System.out.println(locations.height());
            System.out.println(locations.toString() + "\n");
        }

        while (true) {
            System.out.print("zipcode: ");
            String zipcode = in.nextLine();

            if (zipcode.equals("00000")) {
                System.out.println("Good Bye!");
                in.close();
                return;
            }

            Place location = LookupZip.lookupZip(locations, zipcode);
            if (location == null) {
                System.out.println("No such zipcode\n");
            }
            else {
                System.out.println(location.toStringRegular() + "\n");
            }
        }
    }
}
