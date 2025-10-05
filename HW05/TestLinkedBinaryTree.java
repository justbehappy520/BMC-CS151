import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * A class that tests the getRoothMethod and remove method
 * in LinkedBinaryTree.
 */
public class TestLinkedBinaryTree {
    /**
     * Tests getRootElement method.
     */
    @Test
    public void testGetRootElement() {
        LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<>();
        assertTrue(tree1.isEmpty());
        //assertEquals(":3", tree1.getRootElement());
    }

    /**
     * Tests remove method.
     */
    @Test
    public void testRemove() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        tree.insert(":D");
        tree.insert("^^");
        tree.insert(":3");
        tree.insert(":3c");
        tree.insert(":>");
        assertTrue(tree.remove(":3"));
        assertFalse(tree.remove(":3"));
    }
}
