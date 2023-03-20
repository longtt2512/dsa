import java.util.Collection;

/**
 * @author long.truong@finos.asia
 */
public class Teasdasd {

    public Integer divine(int a, int b) {
        try {
            return a / b;
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(12, "D D U U D D U D U U U D "));

    }

    public static void changeText(String input) {
        input = "2";
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int result = 0;
        String[] strings = path.split("");
        for (String str :
                strings) {
            if("U".equals(str)){
                result++;
            }else if("D".equalsIgnoreCase(str)) {
                result--;
            }
        }

        return result;
    }
}
