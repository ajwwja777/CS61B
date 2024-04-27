/**
 * See DLList and generic data structures first.
 */

public class LinkedListDeque<T> {

    public class node {

        public node prev; // last
        public T item;
        public node next; // first

        node(T item) {
            prev = null;
            next = null;
            this.item = item;
        }

        node() {
            prev = null;
            next = null;
        }
    }

    private node sentinel;
    private static int size = 0;

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    LinkedListDeque(T item) {
        sentinel = new node();
        node newNode = new node(item);
        sentinel.prev = newNode;
        sentinel.next = newNode;
        newNode.prev = sentinel;
        newNode.next = sentinel;
        size++;
    }

    /* must not involve any looping or recursion. */
    public void addFirst(T item) {
        node newNode = new node(item);
        node pastNextPtr = sentinel.next;
        sentinel.next = newNode;
        pastNextPtr.prev = newNode;
        newNode.prev = sentinel;
        newNode.next = pastNextPtr;
        size++;
    }

    /* must not involve any looping or recursion. */
    public void addLast(T item) {
        node newNode = new node(item);
        node pastPrevPtr = sentinel.prev;
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
        node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        node firstNode = sentinel.next;
        node secondNode = sentinel.next.next;
        sentinel.next = secondNode;
        secondNode.prev = sentinel;
        size--;
        return firstNode.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        node firstNode = sentinel.prev;
        node secondNode = sentinel.prev.prev;
        sentinel.prev = secondNode;
        secondNode.next = sentinel;
        size--;
        return firstNode.item;
    }

    /* must use iteration, not recursion. */
    public T get(int index) {
        node ptr = sentinel.next;
        int i = 0;
        while (ptr != sentinel && i < index) {
            ptr = ptr.next;
        }
        if (ptr == sentinel) {
            return null;
        }
        return ptr.item;
    }

    /* Helper fn of getRecursive. */
    public T getRecursiveHelper(node nD, int index) {
        if (nD == sentinel) {
            return null;
        } else if (size == 0) {
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
