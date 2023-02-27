package codility;

/**
 * @author long.truong@finos.asia
 */
public class DummyTest {

    public static void main(String[] args) {
        int[] input = {0, 0, 1, 1, 1, 1, 0, 1, 1,1,1,1,1,1};
        System.out.println(solution(input));

    }

    public static int solution(int[] input) {
        int result = 0;
        int maxCounting = 0;

        for(int i: input){
            if(i == 0){
                maxCounting = 0;
            }else {
                maxCounting = Math.max(maxCounting, maxCounting + i);
            }
            result = Math.max(maxCounting, result);
        }


        return result;
    }
}
