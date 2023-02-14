package queue;

/**
 * @author long.truong@finos.asia
 */
public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.print();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.print();
        System.out.println("===========");
        queue.dequeue();
        queue.print();
    }
}
