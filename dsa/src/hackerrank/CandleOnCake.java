package hackerrank;

/**
 * @author long.truong@finos.asia
 */
public class CandleOnCake {

    public static void main(String[] args) {

        int[] data = {4,4,3,4,2,1,5};
        System.out.println(solution(data));

    }

    public static int solution(int[] input){

        int tempMax = -1;
        int countMax = 0;

        for (int temp:
             input) {
            if(temp > tempMax){
                tempMax = temp;
                countMax = 1;
            }else if(temp == tempMax) {
                ++countMax;
            }


        }

        return countMax;
    }
}
