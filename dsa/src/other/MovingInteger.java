package other;

/**
 * @author long.truong@finos.asia
 */
public class MovingInteger {
    /*
    “Move all negative numbers at the beginning of an array and all positive numbers at the end”
     */
    public static void main(String[] args) {
        int[] input = {1, -1, 2, 4, -4, -6, 3, 3, -12};
        int lastIndex = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] > 0 && input[input.length-1 - i] < 0) {
                int temp = input[i];
                input[i] =input[input.length -1- i];
                input[input.length - i-1] = temp;
            }

        }
    }
}
