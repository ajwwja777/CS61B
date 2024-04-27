public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        //String.charAt()
        Deque<Character> d = new LinkedListDeque<>();
        int i = 0;
        while (i < word.length()) {
            d.addLast(word.charAt(i));
            i++;
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < word.length(); i++) {
            s1 += d.get(i);
        }
        for (int i = word.length() - 1; i >= 0 ; i--) {
            s2 += d.get(i);
        }
        return s1.equals(s2);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        String s1 = "";
        String s2 = "";
        int index = -1;
        if (word.length() % 2 == 1) {
            index = (word.length() + 1) / 2;
        }
        for (int i = 0; i < word.length(); i++) {
            s1 += d.get(i);
        }
        for (int i = word.length() - 1; i >= 0 ; i--) {
            s2 += d.get(i);
        }
        for (int i = 0; i < word.length(); i++) {
            if (i != index - 1 && !cc.equalChars(s1.charAt(i), s2.charAt(i))){
                return false;
            }
        }
        return true;
    }

}