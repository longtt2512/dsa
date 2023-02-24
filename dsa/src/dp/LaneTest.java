package dp;

/**
 * @author long.truong@finos.asia
 */
public class LaneTest {

    public static void main(String[] args) {

    }

    public static int solution(String lane1, String lane2) {

        final String potholesPosition = "x";

        int maxFixedPotholes = 0;
        int fixedPotholesWithoutTurnL1 = 0;
        int fixedPotholesWithoutTurnL2 = 0;
        int length = lane1.length();

        for (int i = 0; i < length; i++) {
            if (potholesPosition.equalsIgnoreCase(String.valueOf(lane1.charAt(i)))) {
                ++fixedPotholesWithoutTurnL1;
            }
            if (potholesPosition.equalsIgnoreCase(String.valueOf(lane2.charAt(i)))) {
                ++fixedPotholesWithoutTurnL2;
            }
        }
        maxFixedPotholes = Math.max(fixedPotholesWithoutTurnL1, fixedPotholesWithoutTurnL2);

        // We gonna fix from the 3rd segment
        int maxPotholesWithTurn = 0;
        if (length >= 3) {
            // Loop turn positions
            int maxPotholesFromL1 = 0;
            int maxPotholesFromL2 = 0;
            for (int i = 1; i < length - 2; i++) {
                // Left of position
                for (int j = 0; j < i - 1; j++) {
                    if (potholesPosition.equalsIgnoreCase(String.valueOf(lane1.charAt(j)))) {
                        ++maxPotholesFromL1;
                    }
                    if (potholesPosition.equalsIgnoreCase(String.valueOf(lane2.charAt(j)))) {
                        ++maxPotholesFromL2;
                    }
                }
                // Right of position
                for (int k = i + 1; k < length; k++) {
                    if (potholesPosition.equalsIgnoreCase(String.valueOf(lane1.charAt(k)))) {
                        ++maxPotholesFromL1;
                    }
                    if (potholesPosition.equalsIgnoreCase(String.valueOf(lane2.charAt(k)))) {
                        ++maxPotholesFromL2;
                    }
                }
            }
            // Find max between 2 solutions

        }

        return maxFixedPotholes;
    }
}
