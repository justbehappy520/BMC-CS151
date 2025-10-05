import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that implements the BinaryTree class to create
 * a LinkedBinaryTree of nodes. LinkedBinaryTree creates
 * a binary search tree out of nodes made with the private
 * class Node inside LinkedBinaryTree. LinkedBinaryTree is
 * templated and takes a generic object that also extends
 * Comparable<E> so that the element of the LinkedBinaryTree
 * can be compared, sorted, and printed in order.
 * 
 * @param <E> LinkedBinaryTree is templated and takes a generic
 * object
 */
public class LinkedBinaryTree<E extends Comparable<E>> 
    implements BinaryTree<E> {
    
    // start of private Node class
    /**
     * A private class that creates Node objects for the
     * LinkedBinaryTree class.
     */
    private class Node<E> {

        // instance variables for a binary tree
        public E element;
        public Node<E> left;
        public Node<E> right;

        // constructor methods
        /**
         * Default constructor for Node. Initializes an empty Node.
         */
        Node() {
            this.left = null;
            this.right = null;
        }

        /**
         * User-defined constructor for Node. Initializes a Node
         * with the given generic element.
         * 
         * @param element is the element the Node is initialized with
         */
        Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
    // end of private Node class

    // private instance variables
    private Node<E> root;
    private int size; // the number of elements in the LinkedBinaryTree

    // constructor methods
    /**
     * Default constructor for LinkedBinaryTree. Initializes an empty
     * LinkedBinaryTree with a no elements.
     */
    public LinkedBinaryTree() {
        size = 0;
    }

    /**
     * User-defined constructor for LinkedBinaryTree. Initializes a
     * LinkedBinaryTree with the root initialized with the given 
     * generic element.
     * 
     * @param element is the given element assigned to root
     */
    public LinkedBinaryTree(E element) {
        root = new Node(element);
    }
    
    // BinaryTree methods to be implemented

    /**
     * Returns the root element of the LinkedBinaryTree.
     * 
     * @return the element of the root
     */
    public E getRootElement() {
        // ensure the tree has something
        if (root == null) {
            return null;
        }
        else {
            return root.element;
        }
    }

    /**
     * Returns the size of the LinkedBinaryTree.
     * 
     * @return the number of elements in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the LinkedBinaryTree has any elements.
     * 
     * @return true if there are no elements, false if 
     * there are elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks the LinkedBinaryTree for a given element.
     * 
     * @param element is the data being checked for
     * @return true if element exists, false if not
     */
    public boolean contains(E element) {
        boolean contains = false;

        // use containsHelper to see if the element is in
        // the LinkedBinaryTree
        if (containsHelper(root, element) != null) {
            contains = true;
            return contains;
        }
        return contains;
    }

    /**
     * Returns a Node object or null depending on whether
     * the LinkedBinaryTree contains the object. Helps the
     * contains method.
     * 
     * @param node is the current node
     * @param element is the element to check for
     * @return Node object containing element if found,
     * null if otherwise
     */
    private Node containsHelper(Node node, E element) {
        // base case
        if (node == null) {
            return node;
        }

        // element is located
        if (element.compareTo((E) node.element) == 0) {
            return node;
        }

        // element is to the right
        if (element.compareTo((E) node.element) > 0) {
            return containsHelper(node.right, element);
        }

        // element is to the left
        if (element.compareTo((E) node.element) < 0) {
            return containsHelper(node.left, element);
        }

        // element is not in the LinkedBinaryTree
        return null;
    }

    /**
     * Inserts new element into the LinkedBinaryTree.
     * Insertion of existing elements replaces the current 
     * element, think updating. Uses the compareTo method.
     * 
     * @param element is the data being inserted
     */
    public void insert(E element) {
        insertOrUpdate(root, element);
    }

    /**
     * Helper method to insert or update an element in the
     * LinkedBinaryTree.
     * 
     * @param node is the current node
     * @param element is the data to insert or update
     */
    private void insertOrUpdate(Node node, E element) {
        // base case
        if (node == null) {
            root = new Node(element);
            size++;
            return;
        }

        // start searching, compare current to element
        int compare = element.compareTo((E) node.element);

        // element already exists
        if (compare == 0) {
            node.element = element;
        }

        // element is smaller than current node
        if (compare < 0) {
            // fill empty spot
            if (node.left == null) {
                node.left = new Node(element);
                size++;
            }
            // keep searching
            else {
                insertOrUpdate(node.left, element);
            }
        }

        // element is larger than current node
        if (compare > 0) {
            // fill empty spot
            if (node.right == null) {
                node.right = new Node(element);
                size++;
            }
            // keep searching
            else {
                insertOrUpdate(node.right, element);
            }
        }
    }

    /**
     * Checks if a given element exists in the
     * LinkedBinaryTree and is removed.
     *  
     * @param element is the data being checked and removed
     * @return true if the element previously exists and is
     * removed, false if otherwise
     */
    public boolean remove(E element) {
        if (contains(element)) {
            root = removeHelper(root, element);
            size--;
            return true;
        }
        return false;
    }

    /**
     * Helper method to search for and remove an element from
     * the LinkedBinaryTree.
     * 
     * @param node is the current node
     * @param element is the element to be removed
     * @return the root of the subtree after removal
     */
    private Node removeHelper(Node node, E element) {
        // base case
        if (node == null) {
            return node;
        }

        // start searching, compare current to element
        int compare = element.compareTo((E) node.element);

        // element is larger than current node
        if (compare > 0) {
            node.right = removeHelper(node.right, element);
        }

        // element is smaller than current node
        if (compare < 0) {
            node.left = removeHelper(node.left, element);
        }

        // element is found
        if (compare == 0) {
            // element has no children
            if (node.left == null && node.right == null) {
                return node;
            }
            // element has one child (left)
            else if (node.right == null) {
                return node.left;
            }
            // element has one child (right)
            else if (node.left == null) {
                return node.right;
            }
            // element has two children
            else {
                // find the minimum node of the right subtree
                Node minNode = findMin(node.right);
                node.element = minNode.element;
                node.right = removeHelper(node.right, (E) minNode.element);
            }
        }
        return node;
    }

    /**
     * Helper method to find the minimum node in a subtree.
     * 
     * @param node is the current node
     * @return 
     */
    private LinkedBinaryTree.Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // toString methods to print the BinaryTree
    /**
     * Returns a current snapshot of the tree.
     * 
     * @return a String of the data in the LinkedBinaryTree
     * first in pre-order traversal, then in in-order
     * traversal, finally in post-order traversal
     */
    @Override
    public String toString() {
        String preOrder = "Pre: " + toStringPreOrder() + "\n";
        String inOrder = "In: " + toStringInOrder() + "\n";
        String postOrder = "Post: " + toStringPostOrder() + "\n";
        return "\nTree:\n" + preOrder + inOrder + postOrder;
    }

    /**
     * Prints the LinkedBinaryTree according to In-Order 
     * Traversal (i.e., left, root, right - a b c).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in in-order traversal order
     */
    @Override
    public String toStringInOrder() {
        return inOrderTraversal(root);
    }

    /**
     * Returns a String of elements in the LinkedBinaryTree
     * according to in-order traversal. toStringInOrder() 
     * helper method.
     * 
     * @param node is the node to start with
     * @return a String of the elements in the LinkedBinaryTree
     * in in-order traversal order
     */
    private String inOrderTraversal(Node node) {
        // base case
        if (node == null) {
            return "";
        }

        // process the left subtree
        String leftTraversal = inOrderTraversal(node.left);
        // process the current node
        String currentNode = node.element + " ";
        // process the right subtree
        String rightTraversal = inOrderTraversal(node.right);

        return leftTraversal + currentNode + rightTraversal;
    }

    /**
     * Prints the LinkedBinaryTree according to Pre-Order 
     * Traversal (i.e., root, left, right - b a c).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in pre-order traversal order
     */
    @Override
    public String toStringPreOrder() {
        return preOrderTraversal(root);
    }

    /**
     * Returns a String of elements in the LinkedBinaryTree
     * according to pre-order traversal. toStringPreOrder() 
     * helper method.
     * 
     * @param node is the node to start with
     * @return a String of the elements in the LinkedBinaryTree
     * in pre-order traversal order
     */
    private String preOrderTraversal(Node node) {
        // base case
        if (node == null) {
            return "";
        }

        // process the current node
        String currentNode = node.element + " ";
        // process the left subtree
        String leftTraversal = preOrderTraversal(node.left);
        // process the right subtree
        String rightTraversal = preOrderTraversal(node.right);

        return currentNode + leftTraversal + rightTraversal;
    }

    /**
     * Prints the LinkedBinaryTree according to Post-Order 
     * Traversal (i.e., left, right, root - a c b).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in post-order traversal order
     */
    @Override
    public String toStringPostOrder() {
        return postOrderTraversal(root);
    }

    /**
     * Returns a String of elements in the LinkedBinaryTree
     * according to post-order traversal. toStringPostOrder() 
     * helper method.
     * 
     * @param node is the node to start with
     * @return a String of the elements in the LinkedBinaryTree
     * in post-order traversal order
     */
    private String postOrderTraversal(Node node) {
        // base case
        if (node == null) {
            return "";
        }

        // process the left subtree
        String leftTraversal = postOrderTraversal(node.left);
        // process the right subtree
        String rightTraversal = postOrderTraversal(node.right);
        // process the current node
        String currentNode = node.element + " ";

        return leftTraversal + rightTraversal + currentNode;
    }

    // PollingData specific methods
    /**
     * Parses a line from the csv and returns a PollingData
     * object with the information from the line.
     * 
     * @param line is the line with information to parse
     * from the csv file
     * @return a PollingData object with the information parsed 
     * from the line
     */
    public PollingData parseLine(String line) {
        // split the information in the line
        String[] input = line.split(",");
        
        // extract relevant data
        String lastName = input[0];
        String fullName = input[1];
        double percent = Double.parseDouble(input[2]);

        // create and return PollingData
        PollingData data = new PollingData(lastName, fullName, percent);
        return data;
    }

    /**
     * Reads in a line from the given csv file and parses the
     * data into a LinkedBinaryTree.
     * 
     * @param filename is the name of the file to read
     * @throws FileNotFoundException if file is not found
     */
    public void readData(String filename) throws FileNotFoundException {
        // scan in a file
        Scanner input = new Scanner(new File(filename));
        String nextLine; // next line of input
        PollingData data; // PollingData object

        // skip the first
        input.nextLine();

        // read and parse data
        while (input.hasNextLine()) {
            nextLine = input.nextLine();
            data = parseLine(nextLine);

            // insert object into LinkedBinaryTree
            insert((E) data);
        }
        input.close();
    }
}