import static org.junit.Assert.*;
import org.junit.Test;

public class wja_ArrayDequeTest {

    @Test
    public void aSimpleTest() {
        // 1 4 _ _ _ _ 3 2
        ArrayDeque aD1 = new ArrayDeque<>();
        aD1.addFirst(1);
        aD1.addFirst(2);
        aD1.addFirst(3);
        aD1.addLast(4);
        
        assertEquals(1, aD1.get(0));
        assertEquals(4, aD1.get(1));
        assertEquals(3, aD1.get(6));
        assertEquals(2, aD1.get(7));
    }
}
