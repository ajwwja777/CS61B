import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("tat"));
        assertFalse(palindrome.isPalindrome("persiflage"));
        assertTrue(palindrome.isPalindrome("whahw"));
        assertTrue(palindrome.isPalindrome("acca"));
        assertTrue(palindrome.isPalindrome("ajaja"));
        assertTrue(palindrome.isPalindrome("affa"));
        assertTrue(palindrome.isPalindrome("alala"));
        assertTrue(palindrome.isPalindrome("alula"));
        assertTrue(palindrome.isPalindrome("amma"));
        assertTrue(palindrome.isPalindrome("anana"));
        assertTrue(palindrome.isPalindrome("anna"));
        assertTrue(palindrome.isPalindrome("arara"));
    }

    @Test
    public void testIsPalindromecc() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aa", cc));
        assertFalse(palindrome.isPalindrome("aalii", cc));
    }
}
