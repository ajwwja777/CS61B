import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {

    @Test
    public void testIsSameNumber() {
        int a = 127;
        int aCopy = 127;
        int b = 128;
        int bCopy = 128;
        Integer c = 128;
        Integer cCopy = 128;
        assertTrue(Flik.isSameNumber(a, aCopy));
        assertTrue(Flik.isSameNumber(b, bCopy));
        assertTrue(Flik.isSameNumber(c, cCopy));
    }
}
