import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class NameLL that creates a LL.
 */
public class NameLL {
    /**
     * Private Node class that creates nodes for the LL.
     */
    private class Node {
        public Name data; // element of a node
        public Node next; // next node
        public Node prev; // prev node

        // constructor methods for class Node
        /**
         * Default constructor for Node.
         */
        Node() {
            this.next = null;
            this.prev = null;
        }

        /**
         * Customzied constructor for Node that has a
         * specific data argument.
         * 
         * @param data is any user-specified data to be
         * stored
         */
        Node(Name data) {
            this.data = data;
        }
    }

    // instance variables
    private Node head; // head node, is null
    private Node tail; // tail node, is null
    private int size; // number of elems in LL

    // constructor methods
    /**
     * Default constructor for class NameLL.
     */
    public NameLL() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    // methods
    /**
     * Returns the size (how many elements) of NameLL.
     * 
     * @return the size of the LL
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the LL is empty.
     * 
     * @return true or false depending on emptiness of 
     * the LL
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element of the first node.
     * 
     * @return data of node following head node (first
     * node)
     */
    public Name first() {
        return head.next.data;
    }

    /**
     * Returns the element of the last node.
     * 
     * @return data of node before tail node (last
     * node)
     */
    public Name last() {
        return tail.prev.data;
    }
    
    /**
     * Inserts new node containing user-specified data
     * after the head node.
     * 
     * @param data is the element of the new node being
     * inserted
     */
    public void insertFirst(Name data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;

        size++;
    }

    /**
     * Inserts new node containing user-specified data
     * before the tail node.
     * 
     * @param data is the element of the new node being
     * inserted
     */
    public void insertBack(Name data) {
        Node newNode = new Node(data);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;

        size++;
    }

    /**
     * Insert a new node containing user-specified data
     * before a user-specified node.
     * 
     * @param data is the element of the new node
     * @param someNode is the node the new node will be 
     * inserted before
     */
    public void insertBefore(Name data, Node someNode) {
        Node newNode = new Node(data);
        
        if (someNode != null) {
            Node node = someNode.prev;
            node.next = newNode;
            someNode.prev = newNode;
            newNode.prev = node;
            newNode.next = someNode;

            size++;
            return;
        }
    }

    /**
     * Insert a new node containing user-specified data
     * into alphabetical order.
     * 
     * @param data is the element of the new node to be
     * inserted
     */
    public void insertSortedAlpha(Name data) {
        Node newNode = new Node(data);
        Node node = head.next;

        if (isEmpty()) {
            insertFirst(data);
        }
        while (node.data != null) {
            if (newNode.data.getName().compareTo(
                node.data.getName()) < 0) {
                insertBefore(data, node);
                return;
            }
            node = node.next;
        }
        if (newNode.data.getName().compareTo(
            tail.prev.data.getName()) > 0) {
            insertBefore(data, tail);
        }
    }

    /** Returns an integer, indicating the position of the 
     * name in your linked list. The position should be 
     * 1-indexed (meaning the first item should be 1).
     * 
     * @param name - the name to search for
     * @return - the index of the name in the LinkedList
     */
    public int index(String name) {
        int index = 1;
        Node node = head.next;

        while (node.data != null) {
            if (node.data.getName().equals(name)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    /** 
     * Returns an array of size three. 
     * The first value indicates the rank of the name
     * that year, the second value indicates the number of
     * babies given that during that year (for the gender),
     * the third value indicates the percentage of babies
     * given that name that year (for that gender).
     * 
     * @param name - the name to search for
     * @param year - the year for the stats
     * @param gender - the gender for the stats
     * @return array indicating the rank of the name that
     * year, the number of babies given that name that year
     * (for that gender), percentage - the percentage of
     * babies given that name that year (for that gender)
     */
    public double[] yearStats(String name, int year, char gender) {
        int rank = 0; // rank of name for that year
        int named = 0; // # of babies given that name that year
        int total = 0; // total # of babies given that name
        Node node = head.next;

        while (node != tail) {
            for (int i = 0; i < node.data.getStats().size(); i++) {
                if (node.data.getStats().get(i).getYear() == year) {
                    if (node.data.getName().equals(name)) {
                        named = node.data.getStats().get(i).getNamed();
                        rank = node.data.getStats().get(i).getRank();
                    }
                    total += node.data.getStats().get(i).getNamed();
                }
            }
            node = node.next;
        }

        double percent = 0.0;
        if (total > 0) {
            percent = (double) named / (double) total;
        }

        double[] stats = {rank, named, percent};
        return stats;
    }

    /** Returns an array of size three: for a given gender,
     * the rank of the name, the number of babies with that name,
     * the percentage of babies with that name.
     * 
     * @param name - the name to search for
     * @param gender - the gender for the stats
     *
     * @return array of int, int double
     */
    public double[] totalStats(String name, char gender) {
        int rank = 0; // rank of name overall
        int named = 0; // # of babies given that name overall
        int total = 0; // total # of babies overall
        double percent = 0.0;
        Node node = head.next;

        while (node != tail) {
            if (node.data.getName().equals(name)) {
                named += node.data.total();
                rank = totalRank(node.data);
            }
            total += node.data.total();
            node = node.next;
        }

        if (total > 0) {
            percent = (double) named / (double) total;
        }

        double[] stats = {rank, named, percent};
        return stats;
    }

    /**
     * Parses a line from the csv and returns a Name with info.
     * 
     * @param line from the baby names file
     * @param male checks what data to parse
     * @return Name object with info parsed from file
     */
    public Name parseLineName(String line, String flag) {
        String[] input = line.split(",");
        char gender = 'F';
        Name name = null;

        if ("-m".equals(flag)) {
            gender = 'M';
            name = new Name(input[1], gender);
        }
        else if ("-f".equals(flag)) {
            name = new Name(input[3], gender);
        }

        return name;
    }

    /**
     * Parses a line from the csv and returns a Stats with info.
     * 
     * @param line from baby names file
     * @param fileYear is year from filename
     * @param male checks what data to parse
     * @return Stats object with info parsed from file
     */
    public Stats parseLineStats(String line, int fileYear, String flag) {
        String[] input = line.split(",");
        int rank = Integer.parseInt(input[0]);
        int numBabies = 0;
        Stats stats;

        if ("-m".equals(flag)) {
            numBabies = Integer.parseInt(input[2]);
        }
        else if ("-f".equals(flag)) {
            numBabies = Integer.parseInt(input[4]);
        }

        stats = new Stats(fileYear, rank, numBabies);
        return stats;
    }

    /**
     * Reads in a file, parses line, adds data to LL.
     * 
     * @param filename of file to parse
     * @param flag for gender, -m or -f
     * @throws FileNotFoundException if file is not found
     */
    public void readNames(String filename, String flag) 
        throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        String nextLine; // next line of input
        Name name; // Name object
        Stats stats; // Stats object

        // extracts year in filename
        int yearStart = filename.length() - 8;
        int yearEnd = filename.length() - 4;
        int fileYear = Integer.parseInt(filename.substring(yearStart, yearEnd));

        // read + parse
        while (input.hasNextLine()) {
            nextLine = input.nextLine();
            name = parseLineName(nextLine, flag);
            stats = parseLineStats(nextLine, fileYear, flag);

            // check if the name already exists in the LL
            Name exists = findName(name.getName());
            if (exists == null) {
                name.getStats().insert(stats);
                insertSortedAlpha(name);
            }
            else {
                exists.getStats().insert(stats);
            }
        }
        input.close();
    }

    /**
     * Finds and returns if a name is in the LL.
     * 
     * @param name to search for
     * @return Name object or null
     */
    public Name findName(String name) {
        Node node = head.next;
        while (node != tail) {
            if (node.data.getName().equals(name)) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Returns the rank of the name among all the data.
     * 
     * @param name that is being searched
     * @return the final rank of the name
     */
    public int totalRank(Name name) {
        Node node = head.next;
        int rank = 1;

        while (node != tail) {
            if (name.total() < node.data.total()) {
                rank++;
            }
            node = node.next;
        }
        return rank;
    }
}