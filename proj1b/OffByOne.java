public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        //x = 'a', y = 'a', will return true, i dont know why, so add this if statement.
        //'x' - 'y' always equals to 1...
        //dont miss details, maybe it's important.
        /*
        if (x == y) {
            return false;
        }
        */
        if (diff == 1 || diff == -1) {
            return true;
        }
        return false;
    }
}
