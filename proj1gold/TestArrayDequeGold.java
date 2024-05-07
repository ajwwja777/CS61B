import static org.junit.Assert.*;
import org.junit.Test;

/* 
 * Your test should randomly call StudentArrayDeque and ArrayDequeSolution methods 
 * until they disagree on an output.
 * addFirst, addLast, removeFirst, and removeLast
 */
public class TestArrayDequeGold {
    @Test
    public void addFirstTest() {

    }

    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        int N = 50000;
        String output = "";
        for(int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                Integer randVal = StdRandom.uniform(0, 100);
                ads.addFirst(randVal);
                sad1.addFirst(randVal);
                output += "\naddFirst(" + randVal + ")";
                
            } else if (operationNumber == 1) {
                Integer randVal = StdRandom.uniform(0, 100);
                ads.addLast(randVal);
                sad1.addLast(randVal);
                output += "\naddLast(" + randVal + ")";
            } else if (operationNumber == 2 && ads.size() != 0) {
                Integer expect = ads.removeFirst();
                Integer actual = sad1.removeFirst();
                output += "\nremoveFirst() " + expect;
                output += "\nremoveFirst() " + actual;
                assertEquals(output, expect, actual);
            } else if (operationNumber == 3 && ads.size() != 0) {
                Integer expect = ads.removeLast();
                Integer actual = sad1.removeLast();
                output += "\nremoveLast() " + expect;
                output += "\nremoveLast() " + actual;
                assertEquals(output, expect, actual);
            }
        }
    }

    public static void main(String[] args) {
    }
}
