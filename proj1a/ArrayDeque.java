/**
 * See AList first.
 */

public class ArrayDeque<T> {

    private T[] items;
    private static int headerIndex = 0;
    private static int lastIndex = 0;
    private static int size = 0;
    private static int length = 8;

    /* Creates an empty array deque. */
    /* The starting size of your array should be 8. */
    public ArrayDeque() {
        items = (T[]) new Object[length];
        size = 0;
    }

    /* autoGrade: The following constructors should be removed */
    /*
    public ArrayDeque(T item) {
        items = (T[]) new Object[length];
        size = 0;
        addFirst(item);
    }
    */

    /*             h */
    /* 0 1 2 3 4 5 6 7 */
    private void resize(int capacity) {
        T[] newItem = (T[]) new Object[capacity];
        System.arraycopy(items, headerIndex, newItem, 0, size - headerIndex);
        System.arraycopy(items, 0, newItem, size - headerIndex, headerIndex);
        items = newItem;
        headerIndex = 0;
        lastIndex = length - 1;
        length = capacity;
    }
    
    /* must take constant time, except during resizing operations. */
    public void addFirst(T item) {
        if (size == length || lastIndex + 1 == headerIndex) {
            resize(size * 2);
        }
        if (size == 0) {
            items[headerIndex] = item;
        } else {
            headerIndex--;
            if (headerIndex < 0) {
                headerIndex = length + headerIndex;
            }
            items[headerIndex] = item;
        }
        size++;
    }
    
    /* must take constant time, except during resizing operations. */
    public void addLast(T item) {
        if (size == length || lastIndex + 1 == headerIndex) {
            resize(size * 2);
        }
        if (size == 0) {
            items[lastIndex] = item;
        } else {
            lastIndex++;
            items[lastIndex] = item;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /* must take constant time. */
    public int size() {
        return size;
    }

    public void printDeque() {
        int counter = 0;
        int i = headerIndex;
        int j = 0;
        while (i < length && counter < size) {
            System.out.println(items[i]);
            counter++;
            i++;
        }
        while (j < headerIndex && counter < size) {
            System.out.println(items[j]);
            counter++;
            j++;
        }
    }

    /* must take constant time, except during resizing operations. */
    public T removeFirst() {
        T firstItem = items[headerIndex];
        headerIndex++;
        size--;
        return firstItem;
    }

    /* must take constant time, except during resizing operations. */
    public T removeLast() {
        T lastItem = items[size - 1];
        size--;
        return lastItem;
    }

    /* must take constant time. */
    public T get(int index) {
        return items[index];
    }
}
