package linkedlist;

import java.util.Objects;

/**
 * @author long.truong@finos.asia
 */
public class LinkedListTest {

    private Node head;
    private Node tail;
    private int length;

    public LinkedListTest(int value) {
        initiateNewLinkedList(value);
    }

    private void initiateNewLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node tempNode = this.head;
        while (tempNode != null) {
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNext();
        }
    }

    public void append(int value) {
        // Add reference to the tail node
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            // Re-assign last item
            this.tail = newNode;
        }
        this.length++;
    }

    public boolean removeLast() {
        if (this.length < 0) {
            return false;
        } else if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length = 0;
            return true;
        } else {
            Node tempNode = this.head;
            Node newTail = null;
            while (tempNode.getNext() != null) {
                newTail = tempNode;
                tempNode = tempNode.getNext();
            }
            if (null != newTail) {
                this.tail = newTail;
                this.tail.setNext(null);
                this.length--;
            }
        }
        return false;
    }

    public void prepend(int value) {
        if (this.length < 0){
            return;
        } else if (this.length == 0) {
            initiateNewLinkedList(value);
        }else {

            Node newHead = new Node(value);
            newHead.setNext(this.head);
            this.head = newHead;

            this.length++;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }
}
