import java.io.FileNotFoundException;
import java.util.Scanner;

/**Class to lookup zipcodes from the directories. */
public class DriverHW04 {
    /**Main method of DriverHW04.
     * @param args Filenames
     * @throws FileNotFoundException throws when file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        String file = args[0];
        String file2 = args[1];
        Scanner in = new Scanner(System.in);
        ExpandableArray<Place> locations;
        locations = LookupZip.readZipCodes(file, file2);

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
                System.out.println(location.toString() + "\n");
            }
        }
    }
}
