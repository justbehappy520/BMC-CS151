/**
 * 
 * @param <E>
 */
public class AVLTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {

    // private instance variables
    //private LinkedBinaryTree<E> tree;

    // constructors

    public AVLTree() {
        super();
    }

    public AVLTree(E element) {
        super(element);
    }
    
    // methods
    /**
     * Rebalances the tree at the given node.
     * 
     * @param node to be rebalanced around
     * @return node of root of rebalanced tree
     */
    public Node<E> rebalance(Node<E> n) {
        Node<E> node = n;

        // base case
        if (node == null) {
            return null;
        }

        // update height of current node
        updateHeight(node);
        
        // calculate the balance factor
        int balanceFactor = getBalance(node);

        // left heavy subtree
        if (balanceFactor > 1) {
            // double rotate
            if (getBalance(node.getLeft()) > 0) {
                return rotateLeftRight(node);
            }
            return rotateRight(node);
        }
        // right heavy subtree
        else if (balanceFactor < -1) {
            // double rotate
            if (getBalance(node.getRight()) < 0) {
                return rotateRightLeft(node);
            }
            return rotateLeft(node);
        }
        return node;
    }

    // helper methods for reblance()
    
    /**
     * Helper method for rebalance that rotates the 
     * subtree to the left around a given root.
     * 
     * @param n is the root of the subtree
     * @return the new root after rotation
     */
    public Node<E> rotateLeft(Node<E> n) {
        Node<E> root = n;
        Node<E> pivot = n.getRight();

        if (root == super.root) {
	    this.root = pivot;
	    }
	    if (pivot == null) {
            return root;
        }

        // rotate!!
        root.setRight(pivot.getLeft());
        if (pivot.getLeft() != null) {
            pivot.getLeft().setParent(root);
        }
        pivot.setLeft(root);

        pivot.setParent(root.getParent());
        root.setParent(pivot);

        // update heights
        //updateHeight(root);
        //updateHeight(pivot);

        while (root != null) {
            updateHeight(root);
            root = root.getParent();
        }

        // return the new root
        return pivot;
    }

    /**
     * Helper method for reblanace that rotates the
     * subtree to the right around a given root.
     * 
     * @param n is the root of the subtree
     * @return the new root after rotation
     */
    public Node<E> rotateRight(Node<E> n) {
        Node<E> root = n;
        Node<E> pivot = n.getLeft();

        // double check
        if (root == super.root) {
	    this.root = pivot;
	    }
	    if (pivot == null) {
            return root;
        }

	    System.out.println("root: " + root);
	    System.out.println("pivot: " + pivot);
        // rotate!!
        root.setLeft(pivot.getRight());
        if (pivot.getRight() != null) {
            pivot.getRight().setParent(root);
        }
        pivot.setRight(root);

        //
        pivot.setParent(root.getParent());
        root.setParent(pivot);

        // update heights
        while (root != null) {
	        System.out.println(":3");
            updateHeight(root);
            root = root.getParent();
        }

        // return the new root
        return pivot;
    }

    /**
     * Helper method for rebalance that rotates the
     * subtree to the left and then the right.
     * 
     * @param n is the root of the subtree
     * @return the new root after rotation
     */
    public Node<E> rotateLeftRight(Node<E> n) {
        Node<E> node = n;
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    /**
     * Helper method for rebalance that rotates the
     * subtree to the right and then the left.
     * 
     * @param n is the root of the subtree
     * @return the new root after rotation
     */
    public Node<E> rotateRightLeft(Node<E> n) {
        Node<E> node = n;
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }

    /**
     * Helper method for rebalance that returns the
     * difference in height between the two subtrees.
     * 
     * @return balance factor of the given root
     */
    private int getBalance(Node<E> n) {
        Node<E> node = n;

        // base case
        if (node == null) {
            return 0;
        }

        //updateHeight(node);
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.getLeft() != null) {
            leftHeight = node.getLeft().getHeight();
        }
        if (node.getRight() != null) {
            rightHeight = node.getRight().getHeight();
        }
        int balance = leftHeight - rightHeight;
        return balance;
    }

    /**
     * Inserts new element into the AVLTree.
     * 
     * @param element is the data being inserted
     */
    @Override
    public void insert(E element) {
        insertRecursive(root, element);
    }

    private void insertRecursive(Node<E> node, E element) {        
        // base case
        if (node == null) {
	    super.root = new Node<E>(element);
	    size++;
	    return;
        } // if I leave this out it continuously overrides the root with a new insert

        // make comparisons and insertions (hopefully works)
        Node<E> nnode = insertOrUpdate(node, element);
	    // nnode is the current root of the tree because reasons beyond me

        // check balance factor
	    int balanceFactor = 0;
	    Node<E> lowest = null;
	    System.out.println("node bef: " + nnode);
	    while (nnode != null) {
            if (Math.abs(balanceFactor) >= 2) {
            lowest = nnode;
            }
            balanceFactor = getBalance(nnode);
            //System.out.println("bF: " + balanceFactor);
            if (balanceFactor > 0) {
            nnode = nnode.getLeft();
            } else {
            nnode = nnode.getRight();
            }
        }
        if (lowest == null) {
            return;
        }
        balanceFactor = getBalance(lowest);
        System.out.println("node aft: " + lowest);

        int llh = 0;
        int lrh = 0;
        int rlh = 0;
        int rrh = 0;
        int leftBF = 0;
        int rightBF = 0;
        if (lowest.getLeft() != null) {
            leftBF = getBalance(lowest.getLeft());
        }
        if (lowest.getRight() != null) {
            rightBF = getBalance(lowest.getRight());
        }

        // ROTATT
        if (balanceFactor > 1 && leftBF > 0) {
		    System.out.println("rright");
            rotateRight(lowest);
        }
        if (balanceFactor < -1 && rightBF < 0) {
		    System.out.println("rleft");
            rotateLeft(lowest);
        }
        if (balanceFactor > 1 && leftBF < 0) {
		    System.out.println("rleftright");
	        node.setLeft(rotateLeft(lowest.getLeft()));
            rotateRight(lowest);
        }
        if (balanceFactor < -1 && rightBF > 0) {
		    System.out.println("rrightleft");
            node.setRight(rotateRight(lowest.getRight()));
            rotateLeft(lowest);
        }
    }

    // toString override
    @Override
    public String toString() {
        String print = super.toStringInOrder();
        return print.trim();
    }

    /**
     * Main method of AVLTree to test the insert and print
     * methods.
     * 
     * @param args is the array of command-line arguments
     */
    public static void main(String[] args) {
        AVLTree<String> test = new AVLTree<>();
        test.insert("M");
	    System.out.println("insert M: " + test.toString());
        test.insert("N");
	    System.out.println("insert N: " + test.toString());
        test.insert("O");
	    System.out.println("insert O: " + test.toString());
        test.insert("L");
        System.out.println("insert L: " + test.toString());
        test.insert("K");
        System.out.println("insert K: " + test.toString());
       /* test.insert("Q");
        System.out.println("insert Q: " + test.toString());
        test.insert("P");
        System.out.println("insert P: " + test.toString());
        test.insert("H");
        System.out.println("insert H: " + test.toString());
        test.insert("I");
        System.out.println("insert I: " + test.toString());
        test.insert("A");
        System.out.println("insert A: " + test.toString());*/
    }
}
