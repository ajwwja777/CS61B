/**
 * See DLList and generic data structures first.
 */

public class LinkedListDeque<T> implements Deque<T>{

    private class Node {

        private Node prev; // last
        private T item;
        private Node next; // first

        Node(T item) {
            prev = null;
            next = null;
            this.item = item;
        }

        Node() {
            prev = null;
            next = null;
        }
    }

    private Node sentinel;
    private static int size = 0;

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    LinkedListDeque(T item) {
        sentinel = new Node();
        Node newNode = new Node(item);
        sentinel.prev = newNode;
        sentinel.next = newNode;
        newNode.prev = sentinel;
        newNode.next = sentinel;
        size++;
    }

    /* must not involve any looping or recursion. */
    public void addFirst(T item) {
        Node newNode = new Node(item);
        Node pastNextPtr = sentinel.next;
        sentinel.next = newNode;
        pastNextPtr.prev = newNode;
        newNode.prev = sentinel;
        newNode.next = pastNextPtr;
        size++;
    }

    /* must not involve any looping or recursion. */
    public void addLast(T item) {
        Node newNode = new Node(item);
        Node pastPrevPtr = sentinel.prev;
        sentinel.prev = newNode;
        pastPrevPtr.next = newNode;
        newNode.prev = pastPrevPtr;
        newNode.next = sentinel;
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
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node firstNode = sentinel.next;
        Node secondNode = sentinel.next.next;
        sentinel.next = secondNode;
        secondNode.prev = sentinel;
        size--;
        return firstNode.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node firstNode = sentinel.prev;
        Node secondNode = sentinel.prev.prev;
        sentinel.prev = secondNode;
        secondNode.next = sentinel;
        size--;
        return firstNode.item;
    }

    /* must use iteration, not recursion. */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = 0;
        Node ptr = sentinel.next;
        while (ptr != sentinel && i != index) {
            ptr = ptr.next;
            i++;
        }
        if (ptr == sentinel) {
            return null;
        }
        return ptr.item;
    }

    /* Helper fn of getRecursive. */
    private T getRecursiveHelper(Node nD, int index) {
        if (nD == sentinel) {
            return null;
        } else if (index == 0) {
            return nD.item;
        } else {
            return getRecursiveHelper(nD.next, index - 1);
        }
    }

    /* Same as get, but uses recursion. */
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }
}
