package tree;

/**
 * @author long.truong@finos.asia
 */
public class TestBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree(47);


        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("\nDFS InOrder:");
        System.out.println( myBST.doInOrderImplementation(myBST));
    }
}
