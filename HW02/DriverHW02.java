import java.io.FileNotFoundException;

/**
 * Reads csv files of baby names and ranks based on number of
 * babies named that name in a given year. Parses the data of 
 * these files into two LL split by gender and in alphabetical
 * order. Prints the name's alphabetically sorted rank, then
 * for each year, the rank, the number of babies given that name,
 * the percentage of babies named that name that year. Prints
 * the final ranking of all data for all names, total number of 
 * babies named that name, and percentage of babies named that
 * name for all years.
 */
public class DriverHW02 {
    /**
     * Main method of DriverHW02.
     * 
     * @param args takes in command-line arguments
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        // check for command-line arguments
        if (args.length == 0) {
            throw new IllegalArgumentException("**ERROR** Missing argument(s)");
        }

        // create empty LLs
        NameLL maleNames = new NameLL();
        NameLL femaleNames = new NameLL();

        // track flags indices in command-line argument
        ExpandableArray<Integer> flagIndex = new ExpandableArray<>();
        // track filename indices in command-line argument
        ExpandableArray<Integer> filenames = new ExpandableArray<>();

        // identify command-line arguments
        for (int argIndex = 0; argIndex < args.length; argIndex++) {
            if (args[argIndex].contains("-")) {
                flagIndex.insert(argIndex, flagIndex.size());
                // ensure something follows flag
                if (argIndex + 1 > args.length) {
                    throw new IllegalArgumentException("**ERROR** Missing name(s)");
                }
            }
            else if (args[argIndex].contains(".")) {
                filenames.insert(argIndex, filenames.size());
            }
        }

        // ensure that there is at least one flag
        if (flagIndex.size() == 0) {
            throw new IllegalArgumentException("**ERROR** Missing flag(s)");
        }

        // ensure that there is at least one filename
        if (filenames.size() == 0) {
            throw new IllegalArgumentException("**ERROR** Missing filename(s)");
        }

        String flag = ""; // current flag in command-line arg
        String name = ""; // current name in command-line arg
        String filename = ""; // name of current file being read in

        // loop through command line flags
        for (int i = 0; i < flagIndex.size(); i++) {
            flag = args[flagIndex.get(i)];
            name = args[flagIndex.get(i) + 1];

            // loop through the filenames in the command-line argument
            for (int fileIndex = 0; fileIndex < filenames.size(); 
                fileIndex++) {
                filename = args[filenames.get(fileIndex)];
                
                // storing data in the LLs
                if ("-m".equals(flag)) {
                    maleNames.readNames(filename, flag);
                }
                else if ("-f".equals(flag)) {
                    femaleNames.readNames(filename, flag);
                }
                else {
                    throw new IllegalArgumentException(
                        "**ERROR** Invalid flag: " + flag);
                }
            }

            // find and print the alphabetical rank of the name
            int printRank = 0;
            if ("-m".equals(flag)) {
                printRank = maleNames.index(name);
            }
            else if ("-f".equals(flag)) {
                printRank = femaleNames.index(name);
            }

            // in case the name is not found
            if (printRank == -1) {
                System.out.println("That name isn't in our data.\n");
                return;
            }
            else {
                System.out.println(printRank + "\n");
            }
            
            // checks for the gender
            char gender = 'x';
            if ("-m".equals(flag)) {
                gender = 'M';
            }
            else if ("-f".equals(flag)) {
                gender = 'F';
            }

            for (int fileIndex = 0; fileIndex < filenames.size(); 
                fileIndex++) {
                filename = args[filenames.get(fileIndex)];

                // extracts year in filename
                int yearStart = filename.length() - 8;
                int yearEnd = filename.length() - 4;
                int year = Integer.parseInt(filename.substring(
                    yearStart, yearEnd));

                // calculate the yearly stats for the name
                double[] yearStats = new double[3];
                if ("-m".equals(flag)) {
                    yearStats = maleNames.yearStats(name, year, gender);
                }
                else if ("-f".equals(flag)) {
                    yearStats = femaleNames.yearStats(name, year, gender);
                }

                // in case a year doesn't have stats for the name
                if ((int) yearStats[0] == 0) {
                    continue;
                }
                else {
                    String formatted = String.format("%.6f", yearStats[2]);
                    System.out.println(year);
                    System.out.print(name + ": " + (int) yearStats[0] + ", " + 
                        (int) yearStats[1] + ", " + formatted);
                    System.out.println("\n");
                }
            }

            // calculate the total stats for the name
            double[] totalStats = new double[3];
            if ("-m".equals(flag)) {
                totalStats = maleNames.totalStats(name, gender);
            }
            else if ("-f".equals(flag)) {
                totalStats = femaleNames.totalStats(name, gender);
            }
            
            // print the total stats of the name
            String formatted = String.format("%.6f", totalStats[2]);
            System.out.println("Total");
            System.out.print(name + ": " + (int) totalStats[0] + ", " + 
                (int) totalStats[1] + ", " + formatted);
            System.out.println("\n");
        }
    }
}
