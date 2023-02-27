package nab;

import java.util.*;

/**
 * @author long.truong@finos.asia
 */
public class RemovingStrategyTest {

    public static void main(String[] args) {
        int[] input = {1,  3,4};
        RemovingStrategyTest removingStrategyTest = new RemovingStrategyTest();
        System.out.println(removingStrategyTest.solution(input));
    }

    public int solution(int[] input) {
        //Sort the array first
        Arrays.sort(input);
        List<Integer> occurrencesCounting = new LinkedList<>();
        int occurrence = 1;
        // Get the occurrence of numbers in the array
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                occurrence ++;
            } else {
                occurrencesCounting.add(occurrence);
                // Reset
                occurrence = 1;
            }
        }
        // Add the latest counting value
        occurrencesCounting.add(occurrence);
        // Sort the occurrence array
        Collections.sort(occurrencesCounting);

        Set<Integer> setOccurrence = new HashSet<>();

        // If the current occurrence is not unique, decrease it until it is unique
        // Because the occurrence array is in ascending order,
        // it will be pushed into the set also in ascending order
        int minimumSteps = 0;
        for (int i : occurrencesCounting) {
            if (!setOccurrence.contains(i)) {
                setOccurrence.add(i);
            } else {
                int tmp = i;
                while (setOccurrence.contains(tmp)) {
                    tmp --;
                    minimumSteps ++;
                }
            }
        }
        return minimumSteps;
    }
}
