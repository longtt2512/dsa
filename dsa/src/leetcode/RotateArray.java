package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author long.truong@finos.asia
 */
public class RotateArray {

    public static void main(String[] args) {
       System.out.println(cyclicRotation(new int[]{3, 8, 9, 7, 6}, 3));
        System.out.println(4%6);
    }

    public static int[] cyclicRotation(int[] input, int step){
        int[] result = input;
        for(int i=0; i< input.length; i++){
            int newIndex = (i+step)% input.length;
            result[newIndex] = input[i];
        }
        Set testSet = new HashSet<Integer>();
        boolean add = testSet.add(1);
        boolean add2 = testSet.add(2);
        System.out.println(add == add2);

        return result;
    }
}
