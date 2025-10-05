import java.util.*;
import java.io.FileNotFoundException;

public class Driver00 {
    public static void main(String[] args) {
        String file = args[0];
        int entries = Integer.parseInt(args[1]);
        Scanner in = new Scanner(System.in);
        Place[] locations;

        //System.out.print("zipcode: ");

        while (true) {
            //Scanner in = new Scanner(System.in);
            try {
                locations = LookupZip.readZipCodes(file, entries);

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
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        //in.close();
        /*if (in.nextLine().equals("00000")) {
            System.out.println("Good Bye!");
            in.close();
            return;
        }*/
    }
}
