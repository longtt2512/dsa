package queue;

/**
 * @author long.truong@finos.asia
 */
public class Queue {

    private Node first;
    private Node last;
    private int size;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        size++;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Node dequeue() {

        Node lastFirstNode = first;
        if (size <= 0) {
            return null;
        } else if (size == 1) {
            first = null;
            last = null;
        } else {
            first = lastFirstNode.next;
            lastFirstNode.next = null;
        }
        size--;

        return lastFirstNode;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
