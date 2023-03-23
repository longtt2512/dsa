package leetcode;

import java.util.Arrays;

/**
 * @author long.truong@finos.asia
 */
public class RemovingDuplicatedInt {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4,4};
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }


    public static int removeDuplicates(int[] nums) {

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i< nums.length-1 && nums[i] == nums[i+1] ) {
                continue;
            }
            nums[temp] = nums[i];
            ++temp;
        }

        return temp;

    }

    public static int removeDuplicates1(int[] nums) {
        int max = 101;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = max;
            } else {
                ++max;
            }
        }
        Arrays.sort(nums);

        return (max - 101 + 1);
    }
}
