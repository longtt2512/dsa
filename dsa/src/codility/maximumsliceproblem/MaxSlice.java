package codility.maximumsliceproblem;

/**
 * @author long.truong@finos.asia
 */
public class MaxSlice {

    public static void main(String[] args) {
        int[] input = {3, 2, -6, 4, 0};

        System.out.println(solution(input));
    }

    public static int solution(int[] input) {
        // Implement your solution here
        if(input.length == 1)
            return input[0];

        int maxSlice = Integer.MIN_VALUE;
        int maxSliceCandidate = Integer.MIN_VALUE;

       for(int i: input){
           maxSliceCandidate = Math.max(maxSliceCandidate+ i, i);
           maxSlice = Math.max(maxSliceCandidate,maxSlice);
       }

        return maxSlice;

    }
}
