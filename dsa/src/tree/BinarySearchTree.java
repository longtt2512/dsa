package tree;

import java.util.ArrayList;

/**
 * @author long.truong@finos.asia
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        Node parent = root;

        while (parent != null) {
            if (newNode.value == parent.value) return;
            if (newNode.value < parent.value) {
                // left
                if (parent.left != null) {
                    parent = parent.left;
                } else {
                    parent.left = newNode;
                    parent = null;
                }
            } else {
                // right
                if(parent.right != null){
                    parent = parent.right;
                }else {
                    parent.right = newNode;
                    parent = null;
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public ArrayList<Integer> doInOrderImplementation(BinarySearchTree tree) {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(BinarySearchTree.Node node) {
                // In-Order traversal
                // Visits left node -> current node -> right node
                if (node.left != null) {
                    new Traverse(node.left);
                }
                results.add(node.value);
                if(node.right != null){
                    new Traverse(node.right);
                }
            }
        }
        new Traverse(tree.getRoot());

        return results;
    }

    class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }
}
