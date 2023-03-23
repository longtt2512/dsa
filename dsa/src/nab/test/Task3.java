package nab.test;

import java.util.Arrays;

/**
 * @author long.truong@finos.asia
 */
public class Task3 {

    public int solution(int[] A) {
        int N = A.length;
        int[] maxOfLeft = new int[N];
        int[] minOfRight = new int[N];

        maxOfLeft[0] = A[0];
        for (int i = 1; i < N; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], A[i]);
        }

        minOfRight[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], A[i]);
        }

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) result++;
        }

        return result + 1;
    }

    public int solution2(int[] input) {
        int length = input.length;
        int[] maxOfLeft = new int[length];
        int[] minOfRight = new int[length];

        maxOfLeft[0] = input[0];
        minOfRight[length - 1] = input[length - 1];
        for (int i = 1; i < length; i++) {
            maxOfLeft[i] = Math.max(input[i], maxOfLeft[i-1]);
            minOfRight[length-1-i] = Math.min(input[length-1-i], minOfRight[length-i]);
        }
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) {
                result = result + 1;
            }
        }
        return result + 1;
    }
    public static int solution3(int[] input) {
        int n = input.length;
        int idx = 0;
        int res = 0;
        int[] view = Arrays.copyOf(input, input.length);
        Arrays.sort(view);
        while (idx < n) {
            int fnd = view[idx];

            while (input[idx] != fnd) {
                idx ++;
                if (idx >= n) {
                    break;
                }
            }
            idx ++;
            res ++;
        }
        return res;
    }



    public static void main(String[] args) {
        int[] input = {2,4,1,6,5,9,7};
        System.out.println(solution3(input));
    }
}
