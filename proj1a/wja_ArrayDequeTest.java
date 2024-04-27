import static org.junit.Assert.*;
import org.junit.Test;

public class wja_ArrayDequeTest {

    @Test
    public void aSimpleTest() {
        // 1 4 _ _ _ _ 3 2
        ArrayDeque aD1 = new ArrayDeque<Integer>();
        aD1.addFirst(1);
        aD1.addFirst(2);
        aD1.addFirst(3);
        aD1.addLast(4);
        
        assertEquals(1, aD1.get(0));
        assertEquals(4, aD1.get(1));
        assertEquals(3, aD1.get(6));
        assertEquals(2, aD1.get(7));
    }

    @Test
    public void printTest() {
        // 1 4 _ _ _ _ 3 2
        ArrayDeque aD1 = new ArrayDeque<Integer>();
        aD1.addFirst(1);
        aD1.addFirst(2);
        aD1.addFirst(3);
        aD1.addLast(4);
        
        assertEquals(1, aD1.get(0));
        assertEquals(4, aD1.get(1));
        assertEquals(3, aD1.get(6));
        assertEquals(2, aD1.get(7));

        aD1.printDeque();
    }

    @Test
    public void aHarderTest() {
        //       e h
        // 1 4 5 6 8 7 3 2
        ArrayDeque aD1 = new ArrayDeque<Integer>();
        aD1.addFirst(1);
        aD1.addFirst(2);
        aD1.addFirst(3);
        aD1.addLast(4);
        aD1.addLast(5);
        aD1.addLast(6);
        aD1.addFirst(7);
        aD1.addFirst(8);
        
        assertEquals(1, aD1.get(0));
        assertEquals(4, aD1.get(1));
        assertEquals(5, aD1.get(2));
        assertEquals(6, aD1.get(3));
        assertEquals(8, aD1.get(4));
        assertEquals(7, aD1.get(5));
        assertEquals(3, aD1.get(6));
        assertEquals(2, aD1.get(7));

        aD1.printDeque();
    }

    @Test
    public void resizeTest() {
        //               e               h
        // 8 7 3 2 1 4 5 6 _ _ _ _ _ _ _ 9
        ArrayDeque aD1 = new ArrayDeque<Integer>();
        aD1.addFirst(1);
        aD1.addFirst(2);
        aD1.addFirst(3);
        aD1.addLast(4);
        aD1.addLast(5);
        aD1.addLast(6);
        aD1.addFirst(7);
        aD1.addFirst(8);
        aD1.addFirst(9);
        
        assertEquals(8, aD1.get(0));
        assertEquals(7, aD1.get(1));
        assertEquals(3, aD1.get(2));
        assertEquals(2, aD1.get(3));
        assertEquals(1, aD1.get(4));
        assertEquals(4, aD1.get(5));
        assertEquals(5, aD1.get(6));
        assertEquals(6, aD1.get(7));
        assertEquals(9, aD1.get(15));

        aD1.printDeque();
    }

    /* From autoGrade */
    @Test
    public void addGetTest() {
        ArrayDeque aD1 = new ArrayDeque<Integer>();
        aD1.addLast(1);
        aD1.addLast(2);
        aD1.addLast(3);
        aD1.addLast(4);
        aD1.addLast(5);
        aD1.addLast(6);
        aD1.addLast(7);
        aD1.addLast(8);
        aD1.addLast(9);

        assertEquals(1, aD1.get(0));
        assertEquals(2, aD1.get(1));
        assertEquals(3, aD1.get(2));
        assertEquals(4, aD1.get(3));
        assertEquals(5, aD1.get(4));
        assertEquals(6, aD1.get(5));
        assertEquals(7, aD1.get(6));
        assertEquals(8, aD1.get(7));
        // assertEquals(9, aD1.get(8));
    }
}
