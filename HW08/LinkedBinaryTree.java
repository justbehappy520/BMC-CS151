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
    
    // start of Node class
    /**
     * A class that creates Node objects for the
     * LinkedBinaryTree class.
     */
    public class Node<E> {

        // instance variables for a binary tree
        protected E element;
        protected Node<E> left; // left child reference
        protected Node<E> right; // right child reference
        protected Node<E> parent; // parent reference
        protected int height;

        // constructor methods
        /**
         * Default constructor for Node. Initializes an empty Node.
         */
        public Node() {
            this.element = null;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.height = 1;
        }

        /**
         * User-defined constructor for Node. Initializes a Node
         * with the given generic element.
         * 
         * @param element is the element the Node is initialized with
         */
        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.height = 1;
        }

        // public methods for testing
        /**
         * Returns the data (element) of the given node.
         * 
         * @return element
         */
        public E getData() {
            return element;
        }

        /**
         * Returns the left child node of the given node.
         * 
         * @return left child node
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * Returns the right child node of the given node.
         * 
         * @return right child node
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * Returns the parent node of the given node.
         * 
         * @return parent node
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * Returns the hiehg of the subtree rooted at the given node.
         * That is, a leaf node should have a height of 1.
         * 
         * @return the integer height of the tree
         */
        public int getHeight() {
            return height;
        }

        /**
         * Sets the element of the node.
         * 
         * @param element is the element to be stored
         */
        public void setData(E element) {
            this.element = element;
        }

        /**
         * Sets the the left child.
         * 
         * @param left is the new left node
         */
        public void setLeft(Node<E> left) {
            this.left = left;
        }

        /**
         * Sets the right child.
         * 
         * @param right is the new right node
         */
        public void setRight(Node<E> right) {
            this.right = right;
        }

        /**
         * Sets the parent.
         * 
         * @param parent is the new parent node
         */
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        /**
         * Sets the height.
         * 
         * @param height is the new height
         */
        public void setHeight(int height) {
            this.height = height;
        }

        /**
         * Returns a string of the elements with their respective heights
         * in parentheses.
         * 
         * @return string of element (height)
         */
        @Override
        public String toString() {
            return element + "(" + height + ")";
        }
    }
    // end of Node class

    // private instance variables
    protected Node<E> root;
    protected int size; // the number of elements in the LinkedBinaryTree

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
        this.root = new Node<E>(element);
        size = 1;
    }
    
    // BinaryTree methods to be implemented
    /**
     * Returns the element for which compareTo(element)
     * evaluates to 0.
     *
     * @param element the element to search for
     * @return the element for which compareTo(element)
     * evaluates to 0
     */
    public E get(E element) {
        return getHelper(root, element);
    }

    /**
     * Helpfer method for the get method that recursively 
     * searches for the element.
     * 
     * @param node is the node to begin searching from
     * @param element is the element to search fo
     * @return the element for which compareTo(elemnent)
     * evaluates to 0
     */
    private E getHelper(Node<E> node, E element) {
        // base case
        if (node == null) {
            return null;
        }

        // compare
        int compare = element.compareTo(node.getData());

        // search?
        if (compare == 0) {
            return node.getData();
        }
        if (compare < 0) {
            return getHelper(node.getLeft(), element);
        }
        if (compare > 0) {
            return getHelper(node.getRight(), element);
        }
        return null;
    }

    /**
     * Returns the updated height of a node.
     * 
     * @return the int height of a node after latest update
     */
    public int height() {
        return updateHeight(root) - 1;
    }

    /**
     * Returns the root node of a tree.
     * 
     * @return the root
     * @throws NullPointerException if there is no root
     */
    public Node<E> getRoot() throws NullPointerException {
        // base case
        if (isEmpty()) {
            return null;
        }
        return root;
    }

    /**
     * Returns the root element of the LinkedBinaryTree.
     * 
     * @return the element of the root
     */
    public E getRootElement() {
        // base case
        if (root == null) {
            return null;
        }
        else {
            return (E) root.getData();
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
        // base case
        boolean contains = false;

        // use containsHelper to find the element
        if (containsHelper(root, element) != null) {
            contains = true;
            return contains;
        }
        return contains;
    }

    /**
     * Returns a Node object or null depending on whether
     * the LinkedBinaryTree contains the object. A helper
     * method for the contains method.
     * 
     * @param node is the current node
     * @param element is the element to check for
     * @return Node object containing element if found,
     * null if otherwise
     */
    private Node<E> containsHelper(Node<E> node, E element) {
        // base case
        if (node == null) {
            return node;
        }

        // comparison value
        int compare = element.compareTo((E) node.getData());

        // element is located
        if (compare == 0) {
            return node;
        }

        // element is to the right
        if (compare > 0) {
            return containsHelper(node.getRight(), element);
        }

        // element is to the left
        if (compare < 0) {
            return containsHelper(node.getLeft(), element);
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
    protected Node<E> insertOrUpdate(Node<E> node, E element) {
        Node<E> newNode = new Node<E>(element);

        // base case
        if (node == null) {
            size++;
            //updateHeight(newNode);
            return newNode;
        }
        //System.out.println(":3");

        // start searching, compare current to element
        int compare = node.getData().compareTo(element);

        // element already exists
        if (compare == 0) {
            /*int hite = node.getHeight(); // height of node
            Node<E> paren = node.getParent(); // parent of node
            Node<E> lef = node.getLeft(); // left of node
            Node<E> righ = node.getRight(); // right of node*/

            // making a new node because the position changes
            //node = newNode;
            newNode.setHeight(node.getHeight());
            newNode.setParent(node.getParent());
            newNode.setLeft(node.getLeft());
            newNode.setRight(node.getRight());
            //updateHeight(newNode);
            updateHeight(node);
            return newNode;
        }

        // element is smaller than current node
        if (compare < 0) {
            // fill emepty spot
            if (node.getRight() == null) {
                //System.out.println("^^");
                node.setRight(newNode);
                newNode.setParent(node);
                //System.out.println("rpar: " + node.getHeight());
                //System.out.println(":3" + newNode.getParent());
                //node.getRight().setParent(node);
                updateHeight(node);
                while (node.getParent() != null) {
                    node = node.getParent();
                    updateHeight(node);
                }
                //updateHeight(newNode);
                //updateHeight(node.getRight());
                size++;
                return newNode;
            }
            // keep searching
            else {
                //node.setRight(insertOrUpdate(node.getRight(), element));
                updateHeight(node);
                return insertOrUpdate(node.getRight(), element);
                //insertOrUpdate(node.getRight(), element);
            }
        }

        // element is larger than current node
        if (compare > 0) {
            // fill empty spot
            if (node.getLeft() == null) {
                //System.out.println("vv");
                node.setLeft(newNode);
                newNode.setParent(node);
                //System.out.println("lpar: " + node.getHeight());
                //System.out.println(":3" + newNode.getParent());
                //node.getLeft().setParent(node);
                updateHeight(node);
                while (node.getParent() != null) {
                    node = node.getParent();
                    updateHeight(node);
                }
                //updateHeight(newNode);
                //updateHeight(node.getLeft());
                size++;
                return newNode;
            }
            // keep searching
            else {
                //node.setLeft(insertOrUpdate(node.getLeft(), element));
                updateHeight(node);
                return insertOrUpdate(node.getLeft(), element);
                //insertOrUpdate(node.getLeft(), element);
            }
        }
        //updateHeight(node);
        return newNode; // not too sure what it returns now
    }

    /**
     * Checks if a given element exists in the LinkedBinaryTree
     * and is removed.
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
    private Node<E> removeHelper(Node<E> node, E element) {
        // base case
        if (node == null) {
            return node;
        }

        // start searching, compare current to element
        int compare = node.getData().compareTo(element);

        // element is larger than current node
        if (compare > 0) {
            node.setLeft(removeHelper(node.getLeft(), element));
            updateHeight(node);
        }

        // element is smaller than current node
        if (compare < 0) {
            node.setRight(removeHelper(node.getRight(), element));
            updateHeight(node);
        }

        // element is found
        if (compare == 0) {
            // element has none or one children
            if (node.getRight() == null) {
                if (node.getLeft() != null) {
                    node.getLeft().setParent(node.getParent());
                }
                return node.getLeft();
            } else if (node.getLeft() == null) {
                if (node.getRight() != null) {
                    node.getRight().setParent(node.getParent());
                }
                return node.getRight();
            }
            // element has two children
            else {
                // find the minimum node of the right subtree
                Node<E> minNode = findMin(node.getRight());
                node.setData(minNode.getData());
                node.setRight(removeHelper(node.getRight(), (E) minNode.getData()));
            }
        }
        return node;
    }

    /**
     * Helper method to find the leftmost leaf.
     * 
     * @param node is the current node
     * @return the node with the min element
     */
    private Node<E> findMin(Node<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Helper method to find the height of a subtree.
     * 
     * @param node is the node to find the height of
     * @return the height of the subtree the node is 
     * the root of
     */
    protected int updateHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }

        int height = 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (node.getLeft() != null) {
            leftHeight = node.getLeft().getHeight();
        }
        if (node.getRight() != null) {
            rightHeight = node.getRight().getHeight();
        }

        // takes the max and adds 1 (the root)
        height = Math.max(leftHeight, rightHeight) + 1;
        node.setHeight(height);
        return height;
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
    private String inOrderTraversal(Node<E> node) {
        // base case
        if (node == null) {
            return "";
        }

        // process the left subtree
        String leftTraversal = inOrderTraversal(node.getLeft());
        //System.out.println("left: " + leftTraversal);
        // process the current node
        String currentNode = node.toString() + " ";
        //System.out.println("current: " + currentNode);
        // process the right subtree
        String rightTraversal = inOrderTraversal(node.getRight());
        //System.out.println("right: " + rightTraversal);

        return leftTraversal + currentNode + rightTraversal;
    }

    /**
     * Prints the LinkedBinaryTree according to Pre-Order 
     * Traversal (i.e., root, left, right - b a c).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in pre-order traversal order
     */
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
    private String preOrderTraversal(Node<E> node) {
        // base case
        if (node == null) {
            return "";
        }

        // process the current node
        String currentNode = node.getData() + " ";
        // process the left subtree
        String leftTraversal = preOrderTraversal(node.getLeft());
        // process the right subtree
        String rightTraversal = preOrderTraversal(node.getRight());

        return currentNode + leftTraversal + rightTraversal;
    }

    /**
     * Prints the LinkedBinaryTree according to Post-Order 
     * Traversal (i.e., left, right, root - a c b).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in post-order traversal order
     */
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
    private String postOrderTraversal(Node<E> node) {
        // base case
        if (node == null) {
            return "";
        }

        // process the left subtree
        String leftTraversal = postOrderTraversal(node.getLeft());
        // process the right subtree
        String rightTraversal = postOrderTraversal(node.getRight());
        // process the current node
        String currentNode = node.getData() + " ";

        return leftTraversal + rightTraversal + currentNode;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> test = new LinkedBinaryTree<>();
        test.insert("M");
        System.out.println(test.toStringInOrder());
        test.insert("N");
        System.out.println(test.toStringInOrder());
        test.insert("O");
        System.out.println(test.toStringInOrder());
        test.insert("L");
        System.out.println(test.toStringInOrder());
        test.insert("K");
        System.out.println(test.toStringInOrder());
        test.insert("Q");
        System.out.println(test.toStringInOrder());
        test.insert("P");
        System.out.println(test.toStringInOrder());
        test.insert("H");
        System.out.println(test.toStringInOrder());
        test.insert("I");
        System.out.println(test.toStringInOrder());
        test.insert("A");
        System.out.println(test.toStringInOrder());

        //System.out.println(test.toString());
    }
}
