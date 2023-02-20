package hashtable;

/**
 * @author long.truong@finos.asia
 */
public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    class Node {
        int value;
        String key;
        Node next;

        public Node(int value, String key) {
            this.value = value;
            this.key = key;
        }
    }
}
