import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @param <K>
 * @param <V>
 */
public class Lab09<K, V> {
    /**
     * 
     * @param args
     * @throws FileNotFoundException if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException{
        // create a ProbeHashMap for the words from dictionary.txt
        ProbeHashMap<String, String> dict = new ProbeHashMap<>(24527);
        // K key is a String, which will be the word inserted from dictionary.txt
        // V value is String, which will be the word inserted from dictionary.txt
        // there are 24,520 words in the file, so the capacity is set at 24,527
        // 24,527 is the prime number that is just slightly larger than the file size
        
        // insert the words from dictionary.txt into the ProbeHashMap
        Scanner dictInput = new Scanner(new File("dictionary.txt"));
        String word = ""; // next line of input

        // read the file and insert the data into the ProbeHashMap
        while (dictInput.hasNextLine()) {
            word = dictInput.nextLine();
            dict.put(word, word);
        }
        dictInput.close();

        // compute the average number of probes
        double avgProbes = dict.computeAvgProbes();
        // compute the maximum number of probes
        double maxProbes = dict.getMaxProbes();
        // a probe is each attempt of the open-addressing hashtable to find the correct
        // array location to either insert or search for a key-value pair

        // compute the load factor after insertion
        double loadFactor = dict.computeLoadFactor();
        // a load factor is the percentage of the capacity of the hash map that is full
        
        // print ProbeHashMap statistics: average probes, max probes, load factor
        System.out.println("average number of probes during insertions: " + avgProbes);
        System.out.println("max number of probes during insertions: " + maxProbes);
        System.out.println("load factor after insertions: " + loadFactor);
        System.out.println("\n");

        // search for the words in search.txt in dict
        Scanner searchInput = new Scanner(new File("search.txt"));
        String search = ""; // next line of input
        String possibilities = ""; // all possible words for a misspelled word

        for (int index = 0; index < dict.size(); index++) {
            // read in the words from search.txt and search for them in dict
            while (searchInput.hasNextLine()) {
                search = searchInput.nextLine();
                String lowercase = search.toLowerCase(); // convert the word to lowercase
                // if found, print out the word
                if (dict.get(lowercase) != null) {
                    possibilities = lowercase;
                }
                if (dict.get(lowercase) == null) {
                    String modified = ""; // a possible word for a misspelled word
                    // change one letter
                    for (int i = 0; i < lowercase.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            modified = replaceCharAtIndex(lowercase, i, c);
                            if (dict.get(modified) != null) {
                                possibilities += " " + modified + ",";
                            }
                        }
                    }
                    // exchange adjacent letters
                    for (int i = 0; i < lowercase.length() - 1; i++) {
                        modified = swapAdjacentChars(lowercase, i, i + 1);
                        if (dict.get(modified) != null) {
                            possibilities += " " + modified + ",";
                        }
                    }
                    // remove one letter
                    for (int i = 0; i < lowercase.length(); i++) {
                        modified = removeCharAt(lowercase, i);
                        if (dict.get(modified) != null) {
                            possibilities += " " + modified + ",";
                        }
                    }
                }
                // formatting, remove final comma
                possibilities = possibilities.replaceAll(",$", "");
                // print the output of the search
                System.out.println(search + ": " + possibilities);
                possibilities = "";
            }
        }
        searchInput.close();

        System.out.println("\n");
        // compute the average number of probes
        double avgSearch = dict.computeAvgProbes();
        // compute the maximum number of probes
        double maxSearch = dict.getMaxProbes();
        // print statistics of the search: average probes, max probes
        System.out.println("average number of probes during search: " + avgSearch);
        System.out.println("max number of probes during search: " + maxSearch);
    }

    /**
     * A helper method to search for words in dict. This method replaces a 
     * char with another char at a given index. Then it returns the word.
     * 
     * @param word is the word to modify
     * @param idx is the index of the char to modify
     * @param c is the char to replace the specified char
     * @return word with a char replaced by another char
     */
    private static String replaceCharAtIndex(String word, int idx, char c) {
        char[] chars = word.toCharArray();
        chars[idx] = c;
        return new String(chars);
    }

    /**
     * A helper method to search for words in dict. This method swaps two 
     * adjacent chars in a word at given indices. Then it returns the word.
     * 
     * @param word is the word to modify
     * @param idx is the index of the first letter to swap
     * @param idxx is the index of the second letter to swap
     * @return word with two adjacent letters swapped
     */
    private static String swapAdjacentChars(String word, int idx, int idxx) {
        char[] chars = word.toCharArray();
        char temp = chars[idx];
        chars[idx] = chars[idxx];
        chars[idxx] = temp;
        return new String(chars);
    }

    /**
     * A helper method to search for words in dict. This method takes a word 
     * and removes a char at a specific index. Then it returns the word.
     * 
     * @param word is the word to modify
     * @param idx is the index of the char to remove
     * @return word with a letter removed
     */
    private static String removeCharAt(String word, int idx) {
        return word.substring(0, idx) + word.substring(idx + 1);
    }
}
