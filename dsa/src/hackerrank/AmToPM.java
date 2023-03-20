package hackerrank;

/**
 * @author long.truong@finos.asia
 */
public class AmToPM {

    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00AM"));
    }

    public static String timeConversion(String s) {
        // Write your code here
        // detect AM or PM
        String hourString = s.substring(0, s.indexOf(":"));

        boolean isPM = false;
        if (s.contains("PM") && Integer.parseInt(hourString) < 12 || Integer.parseInt(hourString) == 12 && s.contains("AM"))
            isPM = true;

        String result = s;

        if (isPM) {
            // Increase time
            int newHour = Integer.parseInt(hourString) + 12;
            if (newHour >= 24)
                newHour = 0;
            result = (newHour < 10 ? "0" + newHour : newHour) + s.substring(s.indexOf(":"));
        }

        result = result.replace("PM", "").replace("AM", "");

        return result;
    }
}
