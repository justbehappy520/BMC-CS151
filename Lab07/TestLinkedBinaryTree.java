import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/** Class that tests LinkedBinaryTree. */
public class TestLinkedBinaryTree {
    /**
     * Tests size() method.
     * 
     * @result 1 Inserted one element
     * @result 5 Inserted four more elements
     * @result 7 Inserted two more elements
     */
    @Test
    public void testSize() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        assertEquals(0, (int) tree.size());

        tree.insert("cat");
        assertEquals(1, (int) tree.size());

        tree.insert("chia");
        tree.insert("chair");
        tree.insert("caterwhaul");
        tree.insert("corn muffins");
        assertEquals(5, (int) tree.size());

        tree.insert("carpentry");
        tree.insert("Cullens");
        assertEquals(7, (int) tree.size());
    }

    /**
     * Tests isEmpty() method.
     * 
     * @result true Initialized an empty Binary Tree
     * @result false Inserted several elements
     */
    @Test
    public void testIsEmpty() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        assertTrue(tree.isEmpty());

        tree.insert("dungeon");
        tree.insert("dragon");
        tree.insert("dogmatic");
        assertFalse(tree.isEmpty());
    }

    /**
     * Tests insert() method.
     * 
     * @result "elephant " Inserted one element "elephant"
     */
    @Test
    public void testInsert() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        tree.insert("elephant");
        assertEquals("elephant ", tree.toString());
    }

    /**
     * Tests contains() method.
     * 
     * @result true Tree contains "fennec"
     * @result false Tree does not contain "fungus"
     * @result true Tree contains "flippant"
     * @result true Tree contains "flamboyant"
     * @result false Tree does not contain "fennadryl"
     * @result true Tree contains "focal"
     * @result true Tree contains "faux"
     */
    @Test
    public void testContains() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        tree.insert("flippant");
        tree.insert("faux");
        tree.insert("flamboyant");
        tree.insert("fume");
        tree.insert("focal");
        tree.insert("flamenco");
        tree.insert("fennec");

        assertTrue(tree.contains("fennec"));
        assertFalse(tree.contains("fungus"));
        assertTrue(tree.contains("flippant"));
        assertTrue(tree.contains("flamboyant"));
        assertFalse(tree.contains("fennadryl"));
        assertTrue(tree.contains("focal"));
        assertTrue(tree.contains("faux"));
    }

    /**
     * Tests height() method.
     * 
     * @result -1 for an empty tree
     * @result 0 for a tree with just a root
     * @result 3 for a tree with all the inserted elements
     */
    @Test
    public void testHeight() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        assertEquals(-1, tree.height());

        tree.insert("gloss");
        assertEquals(0, tree.height());

        tree.insert("gilgamesh");
        tree.insert("godly");
        tree.insert("glorification");
        tree.insert("goopy");
        tree.insert("galavant");
        tree.insert("gullible");
        tree.insert("gentrification");
        assertEquals(3, tree.height());

    }

    /**
     * Tests toString() method.
     * 
     * @result "heliocentric " the only element
     * @result "hamlet heleborous heliocentric hummus hydra " all elements 
     */
    @Test
    public void testToString() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        tree.insert("heliocentric");
        assertEquals("heliocentric ", tree.toString());

        tree.insert("hummus");
        tree.insert("hamlet");
        tree.insert("heleborous");
        tree.insert("hydra");
        assertEquals("hamlet heleborous heliocentric hummus hydra ",
            tree.toString());
    }
}
