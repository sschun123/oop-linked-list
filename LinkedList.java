public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    @Override
    public int size() {
        Node<T> current = this.head;
        int size = 0;
        if (current == null) {
            return 0;
        }
        size++;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        this.size = size;
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > this.size()) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }

        Node<T> newNode = new Node<T>(data, null);

        if (index == 0) {
            Node<T> tmpHead = this.head;
            this.head = newNode;
            this.head.setNext(tmpHead);
            return;
        }

        int counter = 0;
        Node<T> current = this.head;
        while (counter != index - 1) {
            counter++;
            current = current.getNext();
        }
        if (index == this.size() - 1) {
            current.setNext(newNode);
            this.tail = newNode;
            return;
        }
        Node<T> tmpNext = current.getNext();
        current.setNext(newNode);
        newNode.setNext(tmpNext);
    }

    @Override
    public T getAtIndex(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        if (index == 0) {
            return this.getHead().getData();
        }

        int counter = 0;
        Node<T> current = this.head;
        while (current.getNext() != null) {
            counter++;
            current = current.getNext();
            if (counter == index) {
                break;
            }
        }

        if (index == 0) {
            this.head = current;
        }
        return current.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        if (index == 0) {
            T headData = this.getHead().getData();
            this.head = this.getHead().getNext();
            return headData;
        }
        int counter = 0;
        Node<T> current = this.head;
        while (counter != index - 1) {
            counter++;
            current = current.getNext();
        }

        if (index == this.size() - 1) {
            Node<T> tmpTail = current.getNext();
            this.tail = current;
            return tmpTail.getData();
        }

        Node<T> removeNode = current.getNext();
        current.setNext(removeNode.getNext());

        return removeNode.getData();
    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }

        if (this.head.getData().equals(data)) {
            Node<T> tmpHead = this.head;
            this.head = this.head.getNext();
            return tmpHead.getData();
        }

        Node<T> current = this.head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                break;
            }
            current = current.getNext();
        }
        Node<T> removeNode = current.getNext();
        if (removeNode.getNext() == null) {
            this.tail = current;
            return removeNode.getData();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }

        return removeNode.getData();
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    // public static void main(String[] args) {
    //     LinkedList<String> ll = new LinkedList<String>();
    //     ll.addAtIndex("hello", 0);
    //     ll.addAtIndex("world", 1);
    //     // System.out.println(ll.getHead().getData());
    //     // System.out.println(ll.getHead().getNext().getData());
    //     // ll.addAtIndex("goodbye", 0);
    //     // System.out.println(ll.getHead().getData());
    //     // System.out.println(ll.getHead().getNext().getData());
    //     System.out.println(ll.getAtIndex(0));
    //     System.out.println(ll.getAtIndex(1));

    //     // ll.removeAtIndex(0);
    //     // System.out.println(ll.getAtIndex(0));
    //     // System.out.println(ll.getAtIndex(1));
    // }
}