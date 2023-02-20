package codility.array;

/**
 * @author long.truong@finos.asia
 */
public class TestArray {

    public static void main(String[] args) {
        System.out.println(cyclicRotation(new int[]{3, 8, 9, 7, 6}, 3));
    }

    public static int[] cyclicRotation(int[] input, int step){
        int[] result = input;
        int stepAndLengthRatio = step% input.length;
        System.out.println("aaa: "+stepAndLengthRatio);


        return result;
    }
}
