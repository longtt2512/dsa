package stack;

/**
 * @author long.truong@finos.asia
 */
public class TestStack {

    public static void main(String[] args) {
        Stack newStack = new Stack(1);
        newStack.print();
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        newStack.print();
        System.out.println("Pop");
        newStack.pop();
        newStack.print();
    }
}
