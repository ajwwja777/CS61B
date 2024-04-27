/**
 * See AList first.
 */

 public class ArrayDeque<T> {

    private T[] items;
    private static int headerIndex = 1;
    private static int lastIndex = 0;
    private static int size = 0;
    private static int length = 8;

    /* Creates an empty array deque. */
    /* The starting size of your array should be 8. */
    public ArrayDeque() {
        items = (T[]) new Object[length];
        size = 0;
    }

    public ArrayDeque(T item) {
        items = (T[]) new Object[length];
        size = 0;
        addFirst(item);
    }
    
    /*             h */
    /* 0 1 2 3 4 5 6 7 */
    public void resize(int capacity) {
        T[] newItem = (T[]) new Object[capacity];
        System.arraycopy(items, headerIndex, newItem, 0, size - headerIndex);
        System.arraycopy(items, 0, newItem, size - headerIndex, headerIndex);
        items = newItem;
    }
    
    /* must take constant time, except during resizing operations. */
    public void addFirst(T item) {
        if (size == length) {
            resize(size * 2);
        }
        headerIndex--;
        if (headerIndex < 0) {
            headerIndex = length + headerIndex;
        }
        items[headerIndex] = item;
        size++;
    }
    
    /* must take constant time, except during resizing operations. */
    public void addLast(T item) {
        if (size == length) {
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
        int i = headerIndex;
        int j = 0;
        while (i < size) {
            System.out.println(items[i]);
            i++;
        }
        while (j < headerIndex) {
            System.out.println(items[j]);
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
