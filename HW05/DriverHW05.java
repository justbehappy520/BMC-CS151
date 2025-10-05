import java.io.FileNotFoundException;

/**
 * This is the driver program for assignment HW05. The code
 * takes in the poll results given via CSV files and updates
 * the entries of a binary search tree created by 
 * LinkedBinaryTree. Along with PollingData, the binary
 * search tree stores the name and current polling
 * percentage for each candidate.
 */
public class DriverHW05 {
    /**
     * The main method of DriverHW05. Implements methods from
     * LinkedBinaryTree and PollingData.
     * 
     * @param args is a String[] of command-line arguments
     * @throws FileNotFoundException when the file inputted
     * into the command-line is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // variables
        String filename; // name of the files
        // list of filenames
        ExpandableArray<String> files = new ExpandableArray<>();
        LinkedBinaryTree<PollingData> tree = new LinkedBinaryTree<>();

        // ensure there is at least one filename
        if (args.length == 0) {
            throw new FileNotFoundException("**ERROR** No files found");
        }

        // for the autograder
        if (args.length == 1) {
            files.insert(args[0]);
        }
        else {
            // parse through filenames in command-line
            for (int argIndex = 0; argIndex < args.length; argIndex++) {
                filename = args[argIndex];

                // extract dates from the filename
                int dateStart = filename.length() - 14;
                int dateEnd = filename.length() - 4;
                String date = filename.substring(dateStart, dateEnd);

                // sort the dates
                int fileIndex = 0;
                while (fileIndex < files.size() && 
                    date.compareTo(files.get(fileIndex)) > 0) {
                    fileIndex++;
                }

                // insert the filename at the appropriate position based on date
                files.insert(date, fileIndex);
            }

            for (int argIndex = 0; argIndex < args.length; argIndex++) {
                filename = args[argIndex];

                for (int i = 0; i < files.size(); i++) {
                    if (filename.contains(files.get(i))) {
                        files.remove(i);
                        files.insert(filename, i);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < files.size(); i++) {
            // read in data of each file and parse into a 
            // LinkedBinaryTree
            tree.readData(files.get(i));

            // print each update
            System.out.println(tree.toString());
        }
    }
}
