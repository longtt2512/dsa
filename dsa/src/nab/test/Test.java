package nab.test;

/**
 * @author long.truong@finos.asia
 */
public class Test {

    public static void main(String[] args) {
        String str = "?ab??a";
        char[] s = str.toCharArray();
        System.out.println(smallestPalindrome(s));
    }

    private static final char QM = '?';


    static boolean isPossiblePalindrome(char str[]) {
        int n = str.length;
        for (int i = 0; i < n / 2; i++) {
            if (str[i] != QM &&
                    str[n - i - 1] != QM &&
                    str[i] != str[n - i - 1])
                return false;
        }

        return true;
    }


    static String smallestPalindrome(char str[]) {
        if (!isPossiblePalindrome(str))
            return "NO";

        int n = str.length;

        for (int i = 0; i < n; i++) {
            if (str[i] == QM) {
                if (str[n - i - 1] != QM)
                    str[i] = str[n - i - 1];
                else
                    str[i] = str[n - i - 1] = 'a';
            }
        }
        return new String(str);
    }
}
