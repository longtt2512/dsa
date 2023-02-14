package linkedlist;

/**
 * @author long.truong@finos.asia
 */
public class TestLinkedList {

    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest(4);
        ///
        System.out.println("Append new node");
        linkedListTest.append(5);
        linkedListTest.append(6);
        linkedListTest.append(7);
        linkedListTest.printList();
        System.out.println("Remove last node");
        linkedListTest.removeLast();
        linkedListTest.printList();

    }
}
