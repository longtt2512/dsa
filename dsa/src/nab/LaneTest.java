package nab;

/**
 * @author long.truong@finos.asia
 */
public class LaneTest {

    public static void main(String[] args) {
//        System.out.println(solution("..xx.x.", "x.x.x.."));
//        System.out.println(solution(".xxx...x", "..x.xxxx"));
        System.out.println(solution(".xxx...x", ".xxx...x"));
    }

    public static int solution(String lane1, String lane2) {

        final String potholesPosition = "x";

        int maxFixedPotholes = 0;
        // Without change lane
        int fixedPotholesWithoutChangeLaneL1 = 0;
        int fixedPotholesWithoutChangeLaneL2 = 0;
        int length = lane1.length();
        // Changing lane index starts from 1 to length -2

        int[] potholesL1Left = new int[length];
        int[] potholesL2Left = new int[length];

        // Without change lane
        for (int i = 0; i < length; i++) {
            char l1Char = lane1.charAt(i);
            char l2Char = lane2.charAt(i);
            if (isPotholesSegment(l1Char)) {
                ++fixedPotholesWithoutChangeLaneL1;
            }
            if (isPotholesSegment(l2Char)) {
                ++fixedPotholesWithoutChangeLaneL2;
            }
            // Convenience calculation
            if (i >= 1 && i <= length - 1) {
                potholesL1Left[i] = (isPotholesSegment(lane1.charAt(i-1)) ? 1 : 0) + potholesL1Left[i - 1];
                potholesL2Left[i] = (isPotholesSegment(lane2.charAt(i-1)) ? 1 : 0) + potholesL2Left[i - 1];
            }
        }
        maxFixedPotholes = Math.max(fixedPotholesWithoutChangeLaneL1, fixedPotholesWithoutChangeLaneL2);

        // Change lane
        int maxChangeLane = 0;
        for (int i = 1; i < length - 2; i++) {
            int maxPotholesStartingFromL1 = 0;
            int maxPotholesStartingFromL2 = 0;

            char l1Char = lane1.charAt(i);
            char l2Char = lane2.charAt(i);

            maxPotholesStartingFromL2 = potholesL1Left[i] + (fixedPotholesWithoutChangeLaneL2- (isPotholesSegment(l2Char) ? 1 : 0)- potholesL2Left[i]);
            maxPotholesStartingFromL1 = potholesL2Left[i] + (fixedPotholesWithoutChangeLaneL1 - (isPotholesSegment(l1Char) ? 1 : 0)- potholesL1Left[i]);
            maxChangeLane = Math.max(maxChangeLane, Math.max(maxPotholesStartingFromL2, maxPotholesStartingFromL1));
            System.out.println("I: "+ i+ " max change lane: "+ maxChangeLane);
        }

        return Math.max(maxChangeLane, maxFixedPotholes);
    }

    public static boolean isPotholesSegment(char character) {
        return "x".equalsIgnoreCase(String.valueOf(character));
    }
}
