package codility.counting;

import java.util.Arrays;

/**
 * @author long.truong@finos.asia
 */
public class TestCountingElements {

    public static void main(String[] args) {
        int[] testArray = new int[5];
        System.out.println(Arrays.toString(testArray));
    }

    public int[] solution(int counter, int[] input) {
        // Implement your solution here
        int[] counterArray = new int[counter];

        int maxCounterValue = 0;
        int currentMaxCounter = 0;
        for(int item : input){
            int index = item -1;
            if(item > counter){
                // found a max counter
                maxCounterValue = currentMaxCounter;
            } else if ( counterArray[index] >= maxCounterValue) {
                counterArray[index] += 1;
            } else {
                counterArray[index] = maxCounterValue +1;
            }
            if(item <= counter && currentMaxCounter < counterArray[index])
                currentMaxCounter = counterArray[index];

        }
        for(int item: counterArray){
            if(item < maxCounterValue)
                item = maxCounterValue;
        }

        return counterArray;

    }
}
