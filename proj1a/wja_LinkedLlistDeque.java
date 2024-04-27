import static org.junit.Assert.*;

import org.junit.Test;

public class wja_LinkedLlistDeque {
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

    @Test
	public void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());
        assertEquals(true, passed);

		lld1.addFirst("front");
		
		passed = checkSize(1, lld1.size()) && passed;
        assertEquals(true, passed);
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
        assertEquals(true, passed);

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;
        assertEquals(true, passed);

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;
        assertEquals(true, passed);

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
		
	}

    @Test
    public void addRemoveTest() {

		System.out.println("Running add/remove test.");
		
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());
        assertEquals(true, passed);

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
        assertEquals(true, passed);

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
        assertEquals(true, passed);

		printTestStatus(passed);
	}

	@Test
	public void getIterativeTest() {
		LinkedListDeque lld1 = new LinkedListDeque<Integer>();
		lld1.addLast(0);
		lld1.removeLast();
		lld1.addFirst(2);
		lld1.get(0);
		lld1.addLast(4);
		lld1.get(1);
		assertEquals(4, lld1.get(1));
	}

	@Test
	public void getRecursiveTest() {
		LinkedListDeque lld1 = new LinkedListDeque<Integer>();
		lld1.addLast(0);
		lld1.removeLast();
		lld1.addFirst(2);
		lld1.get(0);
		lld1.addLast(4);
		lld1.getRecursive(1);
		assertEquals(4, lld1.get(1));
	}
}
