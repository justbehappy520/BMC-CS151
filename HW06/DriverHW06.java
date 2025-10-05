import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The driver class for HW06.
 */
public class DriverHW06 {
    /**
     * Main method of Driver HW06.
     * 
     * @param args is command-line arguments
     * @throws FileNotFoundException if the named file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // variables
        int topN = 0; // n integer in command-line arg
        ArrayHeap<PollingData> heap = new ArrayHeap<>();
        // track filenames in command-line argument
        ArrayList<String> files = new ArrayList<>();
        // track flags indices in command-line argument
        ArrayList<String> names = new ArrayList<>();

        // identify command-line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-n")) {
                topN = Integer.parseInt(args[i + 1]);
            }
            if (args[i].contains("-r")) {
                argRemove(args, i, names);
            }
            if (args[i].contains(".csv")) {
                files.add(args[i]);
            }
        }

        // read in data of each file and parse into an ArrayHeap
        for (String file : files) {
            heap.readData(file);

            // print statements
            System.out.println(heap.toString());
            if (topN > 0) {
                System.out.println("Top " + topN + " Candidates:");
                ArrayList<PollingData> top = heap.peekTopN(topN);
                for (PollingData candidate : top) {
                    System.out.println(candidate);
                }
            }
        }

        // optional removal of candidates
        for (String name : names) {
            for (int i = 0; i < heap.size(); i++) {
                PollingData data = heap.get(i);
                if (data.getLastName().contains(name)) {
                    heap.remove(data);
                }
            }
        }

        
    }

    /**
     * A helper method for processArg that processes the names
     * to be removed in the command line.
     * 
     * @param args is the array of command line arguments
     * @param argIndex is the index of args
     * @param names is the ArrayList to put the command line arguments
     * into
     */
    private static void argRemove(String[] args, int argIndex,
        ArrayList<String> names) {
        int index = argIndex + 1;
        while (index < args.length) {
            String curr = args[index];
            if (!curr.startsWith("-") || !curr.contains(".csv")) {
                break;
            }
            names.add(curr);
            index++; // Move to the next argument
        }
    }
}
