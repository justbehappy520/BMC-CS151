/**
 * 
 * @param <E>
 */
public class AVLTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {

    // constructors
    public AVLTree() {
        super();
    }

    public AVLTree(E element) {
        super(element);
    }

    public String toString() {
        return super.toStringInOrder();
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
        test.insert("N");
        test.insert("O");
        test.insert("L");
        test.insert("K");
        test.insert("Q");
        test.insert("P");
        test.insert("H");
        test.insert("I");
        test.insert("A");

        System.out.println(test.toString());
    }
}
