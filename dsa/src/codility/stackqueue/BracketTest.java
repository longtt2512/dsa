package codility.stackqueue;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/**
 * @author long.truong@finos.asia
 */
public class BracketTest {

    public static void main(String[] args) {

    }

    /*
        A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

            S is empty;
            S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
            S has the form "VW" where V and W are properly nested strings.
            For example, the string "{[()()]}" is properly nested but "([)()]" is not.

        Write a function:

        class Solution { public int solution(String S); }

        that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

        For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..200,000];
        string S is made only of the following characters: "(", "{", "[", "]", "}" and/or ")".
     */
    public int solution(String input){
       // It focuses on using stack
        if(input.length() == 0) return 1;
        if(input.length()%2 != 0) return 0;

        HashMap<String, String> openClosePair = new HashMap<>();
        openClosePair.put("(",")");
        openClosePair.put("{","}");
        openClosePair.put("[","]");
        Stack<String> tempStack = new Stack<>();
        for(int i =0; i<input.length();i++){
            String tempString = String.valueOf(input.charAt(i));
            if(openClosePair.containsKey(tempString)){
                tempStack.push(tempString);
            }else {
                if(tempStack.isEmpty() || !tempString.equals(openClosePair.get(tempStack.pop())))
                    return 0;
            }
        }
        return tempStack.isEmpty()?1:0;
    }
}
