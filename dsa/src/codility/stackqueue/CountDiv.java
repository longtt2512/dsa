package codility.stackqueue;

/**
 * @author long.truong@finos.asia
 */
public class CountDiv {

    public int solution(int start, int end, int mod) {
        // Implement your solution here
        int result = 0;

        if (start % mod == 0) {
            while (start < end) {
                ++result;
                start += start;
            }

        } else {
            if(mod > start)
                ++ result;
            else {
//                int missingValue = mod - (start % mod);
                start = mod;
            }

            while(start < end){
                start += mod;
                ++ result;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(12%5);
        System.out.println(2%5);
    }
}
