/**
 * Class that creates a comparable LinkedBinaryTree
 * that implements LabBinaryTree.
 * 
 * @param <E> Generic
 */
public class LinkedBinaryTree<E extends Comparable<E>>
    implements LabBinaryTree<E> {
    /** Nested private class Node.
     * 
     * @param <E> Generic
     */
    private class Node<E> {
        private E element;
        private Node<E> left;
        private Node<E> right;

        /** Initializes an empty tree. */
        Node() {
            this.left = null;
            this.right = null;
        }

        /** 
         * Initializes a tree with a root.
         * 
         * @param data Root of the tree
         */
        Node(E data) {
            this.element = data;
            this.left = null;
            this.right = null;
        }
    }

    Node<E> root;
    private int numElements;

    // Constructors
    /** Initializes a tree with an empty root. */
    public LinkedBinaryTree() {
        this.root = null;
    }
    /**
     * Initializes a tree with a nonempty root.
     * 
     * @param data Element to put into root
     */

    public LinkedBinaryTree(E data) {
        this.root = new Node<E>(data);
        numElements++;
    }

    // Methods
    /** 
     * Determines the number of elements in the tree.
     *
     * @return int - the number of elements
     */
    public int size() {
        return numElements;
    }

    /** 
     * Determines if the tree is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /** 
     * Inserts an element into the tree.
     *
     * @param element - the element to insert
     */
    public void insert(E element) {
        root = insertHelper(root, element);
    }

    // helper method for insert

    private Node<E> insertHelper(Node<E> node, E element) {
        // if tree is empty, make new root node
        if (node == null) {
            numElements++;
            return new Node<E>(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = insertHelper(node.left, element);
        }
        else if (element.compareTo(node.element) > 0) {
            node.right = insertHelper(node.right, element);
        }

        return node;
    }

    /** 
     * Determines if the tree contains a specific element.
     *
     * @param element - the element to search for
     * @return a boolean if the item was found
     */
    public boolean contains(E element) {
        return search(root, element);
    }

    // helper method for contains element
    /**
     * Searches the tree to see if the indicated element is there.
     * 
     * @param node The node to start looking
     * @param element The element searching for
     * @return Whether the element is found
     */
    private boolean search(Node<E> node, E element) {
        boolean key = false;

        // base case
        if (node == null) {
            return key;
        }

        if (element.compareTo(node.element) == 0) {
            key = true;
            return key;
        }
        else if (element.compareTo(node.element) > 0) {
            return search(node.right, element);
        } 
        else if (element.compareTo(node.element) < 0) {
            return search(node.left, element);
        }
        return key;
    }
 
    /** 
     * Computes the height of the tree.
     *
     * @return Height as an int
     */
    public int height() {
        return heightFinder(root);
    }

    // helper method for height
    /**
     * Finds the height of the tree rooted at node.
     * 
     * @param node Root of subtree we calculate height for
     * @return Height of tree
     */
    private int heightFinder(Node<E> node) {
        int height = -1;

        // base case
        if (node == null) {
            return height;
        }

        int heightLeft = heightFinder(node.left);
        int heightRight = heightFinder(node.right);
        
        if (heightLeft >= heightRight) {
            return heightLeft + 1;
        }
        else {
            return heightRight + 1;
        }
    }

    /** 
     * Creates a string representation of the elements in the tree,
     * the string should be based on an in-order traversal.
     *
     * @return A string representation of the elements in the tree
     */
    public String toString() {
        return inOrderTraversal(root);
    }

    // helper methods for toString()
    /** 
     * Traverses the tree in order.
     * 
     * @param node Node to start traversing from
     * @return String of nodes concatenated together
     */
    private String inOrderTraversal(Node<E> node) {
        // base case
        if (node == null) {
            return "";
        }

        // Traverse left subtree, append current node, then
        // traverse right subtree
        return inOrderTraversal(node.left) + node.element.toString() +
            " " + inOrderTraversal(node.right);
    }
    public void readData(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readData'");
    }
    public String toStringPreOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toStringPreOrder'");
    }
    public String toStringPostOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toStringPostOrder'");
    }
    public String toStringInOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toStringInOrder'");
    }
}