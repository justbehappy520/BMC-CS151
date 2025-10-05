import java.util.*;
import java.io.FileNotFoundException;

public class Driver01 {
    public static void main(String[] args) throws FileNotFoundException {
        String file = args[0];
        String file2 = args[1];
        Scanner in = new Scanner(System.in);
        ExpandableArray<Place> locations;

        while (true) {
            locations = LookupZip.readZipCodes(file, file2);

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
