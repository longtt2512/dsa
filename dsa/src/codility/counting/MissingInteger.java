package codility.counting;

import java.util.HashSet;

/**
 * @author long.truong@finos.asia
 */
public class MissingInteger {

    public int solution(int[] input) {
        // Implement your solution here
        int result = 1;
        HashSet<Integer> uniqueValue = new HashSet<Integer>();
        // Remove duplicated value
        for(int i=0; i< input.length; i++){
            if(input[i] > 0)
                uniqueValue.add(input[i]);
        }
        for(int i=0 ; i< uniqueValue.size(); i++){
            if(uniqueValue.contains(result))
                ++result;
            else
                break;
        }

        return result;
    }
}
