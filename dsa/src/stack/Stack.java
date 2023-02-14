package stack;

/**
 * @author long.truong@finos.asia
 */
public class Stack {

    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        top = newNode;
        height++;
    }

    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Stack push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            return new Stack(value);
        } else if (height > 0) {
            // set top = new node
            newNode.next = top;
            top = newNode;
            height++;
            return this;
        }
        return null;
    }

    public Stack pop() {
        if (height <= 1) {
              return null;
        } else {
            Node newTopNode = top.next;
            top.next = null;
            top = newTopNode;
            height--;
            return  this;
        }
    }


    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
