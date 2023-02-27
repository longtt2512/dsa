package codility.presum;

/**
 * @author long.truong@finos.asia
 */
public class DNATest {

    public int[] solution(String S, int[] P, int[] Q) {
        // Implement your solution here

        int k = P.length;
        int[] result = new int[k];
        // Substring to find smallest impact
        for (int i = 0; i < k; i++) {
            int pIndex = P[i];
            int qIndex = Q[i];
            String temp = S.substring(pIndex, qIndex);
            if (temp.contains("A")) {
                result[i] = 1;
            } else if (temp.contains("C")) {
                result[i] = 2;
            } else if (temp.contains("G")) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] P = {};
        System.out.println();
    }

}
