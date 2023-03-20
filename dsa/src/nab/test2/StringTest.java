package nab.test2;

/**
 * @author long.truong@finos.asia
 */
public class StringTest {

    public static void main(String[] args) {
        String test = "baaaaaaaaa";
        System.out.println(solution2(test));
    }

    public static boolean solution1(String input) {
        boolean result = true;
        if (input.length() > 300_000) return false;
        char[] stringArray = input.toCharArray();
        boolean isBBefore = false;
        for (char temp :
                stringArray) {
            if ('b' == temp) {
                isBBefore = true;
            }
            if (isBBefore && 'a' == temp) {
                return false;
            }
        }

        return result;
    }

    public static boolean solution2(String input) {
        int bIndex = input.indexOf('b');
        int lastIndexOfA = input.lastIndexOf('a');
        if(bIndex < 0) return true;
        return bIndex >= lastIndexOfA;

    }
}
