import java.lang.Math;

public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
    
    public class Node<E> {
        private E element; //the element stored in the node
        private Node<E> left; //reference to the left child
        private Node<E> right; //reference to the right child
        private Node<E> parent;
        private int height;

        public Node() {
            this.element = null;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.height = 1;
        }

        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.height = 1;
        }

        /** Returns the value of the element stored in the node
         * @return The value of element
         */
        public E getElement() {
            return element;
        }
        /** Returns the value of the left child's node
         * @return The value of left
         */
        public Node<E> getLeft() {
            return left;
        }
        /** Returns the value of the right child's node
         * @return The value of right
         */
        public Node<E> getRight() {
            return right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public int getHeight() {
            return height;
        }
        
        /** Sets the value of element
         * @param e The element to be stored
         */
        public void setElement(E e) {
            element = e;
        }
        /** Sets the value of left node
         * @param e The new left node
         */
        public void setLeft(Node<E> l) {
            left = l;
        }
        /** Sets the value of right node
         * @param e The new right node
         */
        public void setRight(Node<E> r) {
            right = r;
        }

        public void setParent(Node<E> p) {
            parent = p;
        }

        public void setHeight(int h) {
            height = h;
        }

        public String toString() {
            return element + "(" + height + ")";
        }
    }

    private int size = 0; //the number of nodes in the tree
    private Node<E> root = null; //the first node

    /** Creates a linked binary tree */
    public LinkedBinaryTree() { }

    public int height() {
        updateHeight(root);
        return root.getHeight();
    }

    /** Returns the value of the root element
     * @return The value of the root node's element
     */
    public E getRootElement() {
        if (root != null) {
            return root.getElement();
        } else {
            return null;
        }
    }

    /** Returns the root node
     * @return The root node
     */
    public Node<E> getRoot() {
        return root;
    }

    /** Returns the value of size
     * @return The size of the tree
     */
    public int size() {
	    return size;
    }

    /** Returns if the tree is empty or not
     * @return True if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
	    return size == 0;
    }

    /** Inserts a new node into the tree in the correct ordered location
     * @param element The element to be inserted
     */
    public void insert(E element) {
        Node<E> newest = insertRec(root, element); //the node that has been inserted
        if (isEmpty()) {
            root = newest; //updates the root
        }
        updateHeight(root);
        Node<E> p = rebalance(root);
        root.setParent(p);
        root = p;
        size++;
    }

    /** Recursively compares the elements in the tree to find the correct insertion location
     * @param root The current root node element is compared with
     * @param element The element to be inserted
     * @return The node being inserted
     */
    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) { //reached the correct position in the tree
            return new Node<E>(element); //node is inserted as a leaf
        }
        if (root.getElement().compareTo(element) > 0) {
            root.setLeft(insertRec(root.getLeft(), element));
            root.getLeft().setParent(root);
            updateHeight(root.getLeft());
            Node<E> p = rebalance(root.getLeft());
            p.setParent(root);
            root.setLeft(p);
        } else {
            root.setRight(insertRec(root.getRight(), element));
            root.getRight().setParent(root);
            updateHeight(root.getRight());
            Node<E> p = rebalance(root.getRight());
            p.setParent(root);
            root.setRight(p);
        }
        return root;
    }
    
    private Node<E> rebalance(Node<E> n) {
        updateHeight(n);
        int lh = 0, rh = 0;
        if (n.getLeft() != null) {
            lh = n.getLeft().getHeight();
        }
        if (n.getRight() != null) {
            rh = n.getRight().getHeight();
        }

        if (lh > rh+1) {
            int llh = 0, lrh = 0;
            if (n.getLeft().getLeft() != null) {
                llh = n.getLeft().getLeft().getHeight();
            }
            if (n.getLeft().getRight() != null) {
                lrh = n.getLeft().getRight().getHeight();
            }
            if (llh >= lrh) {
                return rotateRight(n); //update parent w/ returned node
            } else {
                return rotateLeftRight(n);
            }
        } else if (rh > lh+1) {
            int rlh = 0, rrh = 0;
            if (n.getRight().getLeft() != null) {
                rlh = n.getRight().getLeft().getHeight();
            }
            if (n.getRight().getRight() != null) {
                rrh = n.getRight().getRight().getHeight();
            }
            if (rrh >= rlh) {
                return rotateLeft(n);
            } else {
                return rotateRightLeft(n);
            }
        }
        return n; //no rotation
    }

    private Node<E> rotateRight(Node<E> r) {
        Node<E> p = r.getLeft();
        r.setLeft(p.getRight());
        p.setRight(r);
        updateHeight(r);
        updateHeight(p);
        return p;	
    }

    private Node<E> rotateLeft(Node<E> l) {
        Node<E> p = l.getRight();
        l.setRight(p.getLeft());
        p.setLeft(l);
        updateHeight(l);
        updateHeight(p);
        return p;	
    }

    private Node<E> rotateLeftRight(Node<E> r) {
	    r.setLeft(rotateLeft(r.getLeft()));
        return rotateRight(r);
    }

    private Node<E> rotateRightLeft(Node<E> l) {
	    l.setRight(rotateRight(l.getRight()));
        return rotateLeft(l);
    }

    private void updateHeight(Node<E> n) {
        if (n == null) {
            n.setHeight(-1);
        }
        int lh = 0, rh = 0;
        if (n.getLeft() != null) {
            lh = n.getLeft().getHeight();
        }
        if (n.getRight() != null) {
            rh = n.getRight().getHeight();
        }
        int height = 1 + Math.max(lh, rh);
        n.setHeight(height);
    }

    /** Checks if an element is in the tree
     * @param element The element being checked for
     * @return True if the element is in the tree, false otherwise
     */
    public boolean contains(E element) {
	    return containsRec(root, element);
    }

    /** Recursively searches the tree for an element
     * @param root The current root node element is compared with
     * @param element The element being checked for
     * @return True if the element is in the tree, false otherwise
     */
    private boolean containsRec(Node<E> root, E element) {
        if (root == null) { //the element was not found
            return false;
        }

        int compare = element.compareTo(root.getElement()); //comparison between the current root and element
        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return containsRec(root.getLeft(), element);
        } else {
            return containsRec(root.getRight(), element);
        }
    }

    /** Removes a node from the tree
     * @param element The element to be removed
     * @return True if the element was found and removed, false otherwise
     */
    public boolean remove(E element) {
        if (contains(element)) {
            Node<E> newest = removeRec(root, element);
            if (contains(element)) { //case where tree's root has one child
                root = newest; //updates root to its child
            }
            size--;

            if (!isEmpty()) {
                Node<E> p = rebalance(root);
                root.setParent(p);
                root = p;
            }
            return true;
        } else {
            return false;
        }
    }

    /** Recursively searches for an element and removes it if found
     * @param element The element to be removed
     * @return The root node 
     */
    private Node<E> removeRec(Node<E> root, E element) {
        int result = element.compareTo(root.getElement()); //comparison between the current root and element
        //adjusts the links to remove the element
        if (result < 0) {
            root.setLeft(removeRec(root.getLeft(), element));
            updateHeight(root);
            if (root.getLeft() != null) {
                Node<E> p = rebalance(root.getLeft());
                p.setParent(root);
                root.setLeft(p);
            }
        } else if (result > 0) {
            root.setRight(removeRec(root.getRight(), element));
            updateHeight(root);
            if (root.getRight() != null) {
                Node<E> p = rebalance(root.getRight());
                p.setParent(root);
                root.setRight(p);
            }
        } else { //the element was found
            //root has one child
            if (root.getLeft() == null) {
                if (root.getRight() != null)
                root.getRight().setParent(root.getParent());
                return root.getRight();
            } else if (root.getRight() == null) {
                if (root.getLeft() != null) {
                    root.getLeft().setParent(root.getParent());
                }
                return root.getLeft();
            //root has two children
            } else {
                //replaces root with the smallest element in its right subtree
                root.setElement(minKey(root.getRight()));
                root.setRight(removeRec(root.getRight(), root.getElement()));
            }
        }
	    return root;		    
    }

    /** Finds the leftmost element starting from a given node
     * @param root The current root node being checked
     * @return The smallest element starting from root
     */
    private E minKey(Node<E> root) {
        if (root.getLeft() == null) {
            return root.getElement();
        } else {
            return minKey(root.getLeft());
        }
    }

    /** Formats the elements in the tree in order based on how they are comparable
     * @return A string representing an in order traversal of the tree
     */
    public String toStringInOrder() {
	    return toStringInOrderRec(root);
    }

    /** Builds a string using a left subtree, root, right subtree traversal
     * @return A string representing an in order traversal of the tree
     */
    private String toStringInOrderRec(Node<E> root) {
        if (root == null) { //base case, the traversal has reached the left/rightmost node
            return "";
        } else {
            String s = "";
            s += toStringInOrderRec(root.getLeft());
            s += root.toString() + " ";
            s += toStringInOrderRec(root.getRight());
            return s;
        }
    }

     /** Formats the elements in the tree based on a pre order traversal
     * @return A string representing a pre order traversal of the tree
     */
    public String toStringPreOrder() {
	    return toStringPreOrderRec(root);
    }

    /** Builds a string using a root, left subtree, right subtree traversal
     * @return A string representing a pre order traversal of the tree
     */
    private String toStringPreOrderRec(Node<E> root) {
        if (root == null) { //base case, the traversal has reached the left/rightmost node
            return "";
        } else {
            String s = "";
            s += root.getElement() + " ";
            s += toStringPreOrderRec(root.getLeft());
            s += toStringPreOrderRec(root.getRight());
            return s;
        }
    }

    /** Formats the elements in the tree based on a post order traversal
     * @return A string representing a post order traversal of the tree
     */
    public String toStringPostOrder() {
	    return toStringPostOrderRec(root);
    }

     /** Builds a string using a left subtree, right subtree, root traversal
     * @return A string representing a post order traversal of the tree
     */
    private String toStringPostOrderRec(Node<E> root) {
        if (root == null) { //base case, the traversal has reached the left/rightmost node
            return "";
        } else {
            String s = "";
            s += toStringPostOrderRec(root.getLeft());
            s += toStringPostOrderRec(root.getRight());
            s += root.getElement() + " ";
            return s;
        }
    }

    /** Formats how a linked binary tree is printed
     * @return A string containing the tree's pre order, in order, and post order traversals
     */
    public String toString() {
        return "Tree:\nPre:\t" + toStringPreOrder() + "\nIn:\t" +
	    toStringInOrder() + "\nPost:\t" + toStringPostOrder();
    }
}