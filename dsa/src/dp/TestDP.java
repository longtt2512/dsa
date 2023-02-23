package dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @author long.truong@finos.asia
 */
public class TestDP {

    public int solution(int [] A) {
        if (A == null || A.length == 0)
            return 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total = total + A[i];
        }
        int target = (int)Math.ceil(total*1.0/A.length);

        int steps = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i]< target) {
                steps = steps + target - A[i];
            }
        }
        return steps;
    }

    public static void main(String[] args) {

        Random random = new Random();
        int randomLength = random.nextInt(10-1) + 1;
        System.out.println(randomLength);
        int[] randomArray = new int[randomLength];
        for (int i = 0; i < randomLength; i++) {
            randomArray[i] = random.nextInt(1_000 -1 )+ 1;

        }
        System.out.println(Arrays.toString(randomArray));
        TestDP treePlanting = new TestDP();
        System.out.println(treePlanting.solution(randomArray));


//        int[] A = {4, 2, 4, 7,10000000};
//        TestDP treePlanting = new TestDP();
//        System.out.println(treePlanting.solution(A));
//        A = {4, 2, 4, 6};
    }

}
