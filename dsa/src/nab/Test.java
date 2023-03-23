package nab;

/**
 * @author long.truong@finos.asia
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(solution("?ab??a"));
    }

    public static String solution(String input) {
        int n = input.length();
        int endIndex= n - 1;
        int startIndex = 0;
        while (startIndex <= endIndex) {
            if (input.charAt(startIndex) == '?' && (input.charAt(endIndex) >= 'a' && input.charAt(endIndex) <= 'z')) {
                input = input.substring(0, startIndex) + input.charAt(endIndex) + input.substring(startIndex + 1);
            } else if (input.charAt(endIndex) == '?' && (input.charAt(startIndex) >= 'a' && input.charAt(startIndex) <= 'z')) {

                input = input.substring(0, endIndex) + input.charAt(startIndex) + input.substring(endIndex + 1);

            } else if (input.charAt(endIndex) == '?' && input.charAt(startIndex) == '?'){
                input = input.substring(0, endIndex) + 'a' + input.substring(endIndex + 1);
                input = input.substring(0, startIndex) + 'a' + input.substring(startIndex + 1);
            } else if (
                    (input.charAt(endIndex) >= 'a' && input.charAt(endIndex) <= 'z') && (input.charAt(startIndex) >= 'a' && input.charAt(startIndex) <= 'z')) {
                if (input.charAt(endIndex) != input.charAt(startIndex)) {
                    return "NO";
                }
            }
            // increase condition
            startIndex ++;
            endIndex--;
        }
        return input;
    }
}
