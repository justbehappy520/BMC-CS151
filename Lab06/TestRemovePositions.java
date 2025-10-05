import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Class that tests method removePositions. */
public class TestRemovePositions {
    /**Test 1 - base case. */
    @Test
    public void test1() {
        // set ArrayLists
        ArrayList<Integer> test1 = new ArrayList<Integer>();
        test1.add(0, 3);
        test1.add(1, 10);
        test1.add(2, 8);
        test1.add(3, 5);
        test1.add(4, 12);
        test1.add(5, 67);
        test1.add(6, 25);
        test1.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 1);
        indices.add(1, 3);
        indices.add(2, 4);
        indices.add(3, 6);

        // verify
        ArrayList.removePositions(test1, indices);
        System.out.println(test1);
        assertEquals("(3, 8, 67, 22)", test1.toString());
    }

    /**Test 2 - base case. */
    @Test
    public void test2() {
        // set ArrayLists
        ArrayList<Integer> test2 = new ArrayList<Integer>();
        test2.add(0, 3);
        test2.add(1, 10);
        test2.add(2, 8);
        test2.add(3, 5);
        test2.add(4, 12);
        test2.add(5, 67);
        test2.add(6, 25);
        test2.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 0);
        indices.add(1, 2);
        indices.add(2, 5);
        indices.add(3, 7);

        // verify
        ArrayList.removePositions(test2, indices);
        System.out.println(test2);
        assertEquals("(10, 5, 12, 25)", test2.toString());
    }

    /**Test 3 - base case. */
    @Test
    public void test3() {
        // set ArrayLists
        ArrayList<Integer> test3 = new ArrayList<Integer>();
        test3.add(0, 3);
        test3.add(1, 10);
        test3.add(2, 8);
        test3.add(3, 5);
        test3.add(4, 12);
        test3.add(5, 67);
        test3.add(6, 25);
        test3.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 2);
        indices.add(1, 4);
        indices.add(2, 6);

        // verify
        ArrayList.removePositions(test3, indices);
        System.out.println(test3);
        assertEquals("(3, 10, 5, 67, 22)", test3.toString());
    }

    /**Test 4 - base case. */
    @Test
    public void test4() {
        // set ArrayLists
        ArrayList<String> test4 = new ArrayList<String>();
        test4.add(0, "cat");
        test4.add(1, ":3");
        test4.add(2, ":D");
        test4.add(3, ":)");
        test4.add(4, "XD");
        test4.add(5, ":P");
        test4.add(6, "XP");
        test4.add(7, ":*");

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 3);
        indices.add(1, 6);
        indices.add(2, 7);

        // verify
        ArrayList.removePositions(test4, indices);
        System.out.println(test4);
        assertEquals("(cat, :3, :D, XD, :P)", test4.toString());
    }

    /**Test 5 - base case. */
    @Test
    public void test5() {
        // set ArrayLists
        ArrayList<Integer> test5 = new ArrayList<Integer>();
        test5.add(0, 3);
        test5.add(1, 10);
        test5.add(2, 8);
        test5.add(3, 5);
        test5.add(4, 12);
        test5.add(5, 67);
        test5.add(6, 25);
        test5.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 0);
        indices.add(1, 2);
        indices.add(2, 5);

        // verify
        ArrayList.removePositions(test5, indices);
        System.out.println(test5);
        assertEquals("(10, 5, 12, 25, 22)", test5.toString());
    }

    /**Test 6 - P has one index. */
    @Test
    public void test6() {
        // set ArrayLists
        ArrayList<Integer> test6 = new ArrayList<Integer>();
        test6.add(0, 3);
        test6.add(1, 10);
        test6.add(2, 8);
        test6.add(3, 5);
        test6.add(4, 12);
        test6.add(5, 67);
        test6.add(6, 25);
        test6.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 0);

        // verify
        ArrayList.removePositions(test6, indices);
        System.out.println(test6);
        assertEquals("(10, 8, 5, 12, 67, 25, 22)", test6.toString());
    }

    /**Test 7 - L has no indices. */
    @Test
    public void test7() {
        // set ArrayLists
        ArrayList<Integer> test7 = new ArrayList<Integer>();

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 1);
        indices.add(1, 3);
        indices.add(2, 4);
        indices.add(3, 6);

        // verify
        ArrayList.removePositions(test7, indices);
        System.out.println(test7);
        assertEquals("()", test7.toString());
    }

    /**Test 8 - P has no indices.*/
    @Test
    public void test8() {
        // set ArrayLists
        ArrayList<Integer> test8 = new ArrayList<Integer>();
        test8.add(0, 3);
        test8.add(1, 10);
        test8.add(2, 8);
        test8.add(3, 5);
        test8.add(4, 12);
        test8.add(5, 67);
        test8.add(6, 25);
        test8.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();

        // verify
        ArrayList.removePositions(test8, indices);
        System.out.println(test8);
        assertEquals("(3, 10, 8, 5, 12, 67, 25, 22)", test8.toString());
    }

    /**Test 9 - P has all indices of L.*/
    @Test
    public void test9() {
        // set ArrayLists
        ArrayList<Integer> test9 = new ArrayList<Integer>();
        test9.add(0, 3);
        test9.add(1, 10);
        test9.add(2, 8);
        test9.add(3, 5);
        test9.add(4, 12);
        test9.add(5, 67);
        test9.add(6, 25);
        test9.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 0);
        indices.add(1, 1);
        indices.add(2, 2);
        indices.add(3, 3);
        indices.add(4, 4);
        indices.add(5, 5);
        indices.add(6, 6);
        indices.add(7, 7);

        // verify
        ArrayList.removePositions(test9, indices);
        System.out.println(test9);
        assertEquals("()", test9.toString());
    }

    /**Test 10 - base case.*/
    @Test
    public void test10() {
        // set ArrayLists
        ArrayList<Integer> test10 = new ArrayList<Integer>();
        test10.add(0, 3);
        test10.add(1, 10);
        test10.add(2, 8);
        test10.add(3, 5);
        test10.add(4, 12);
        test10.add(5, 67);
        test10.add(6, 25);
        test10.add(7, 22);

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices.add(0, 1);
        //indices.add(1, 1);
        indices.add(1, 4);
        indices.add(2, 6);

        // verify
        ArrayList.removePositions(test10, indices);
        System.out.println(test10);
        assertEquals("(3, 8, 5, 67, 22)", test10.toString());
    }
}
