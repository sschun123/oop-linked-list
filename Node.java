public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node(5);
        Node<Integer> node2 = new Node(3);
        Node<Integer> node3 = new Node(100);

        System.out.println(node1.getData());
        System.out.println(node1.getNext());
        System.out.println(node2.getData());
        System.out.println(node2.getNext());
        System.out.println(node3.getData());
        System.out.println(node3.getNext());

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(node1.getNext().getNext().getData());
    }
}
