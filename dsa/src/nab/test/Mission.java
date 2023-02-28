package nab.test;

/**
 * @author long.truong@finos.asia
 */
public class Mission {
    public static void main(String[] args) {
//        int[] missions = new int[] {5, 8, 2, 7};
//        int difficultThreshold = 3; // -> 3

//        int[] missions = new int[] {2, 5, 9, 2, 1, 4};
//        int difficultThreshold = 4; // -> 3

//        int[] missions = new int[] {1, 12, 10, 4, 5, 2};
//        int difficultThreshold = 2; // -> 4

//        int[] missions = new int[] {1, 2, 3, 4, 5, 6, 7};
//        int difficultThreshold = 1; // -> 4

//        int[] missions = new int[] {1,1,1,1,1,1 };
//        int difficultThreshold = 1; // -> 1

//        int[] missions = new int[] {1,1,1,1,1,1, 2 };
//        int difficultThreshold = 1; // -> 1


//        int[] missions = new int[] {1,1,1,1,1,1, 2, 5 };
//        int difficultThreshold = 1; // -> 2

        int[] missions = new int[] { };
        int difficultThreshold = 1; // -> 0
        Mission m = new Mission();
        System.out.println(m.solution(missions, difficultThreshold));

    }

    public int solution(int[] mission, int difficultThreshold) {

        if (mission.length == 0) return 0;

        int dayCount = 0;
        int tmpMin = mission[0];
        int tmpMax = mission[0];
        for (int i = 1; i < mission.length; i++) {
            if (tmpMin > mission[i]) {
                tmpMin = mission[i];
            }

            if (tmpMax < mission[i]) {
                tmpMax = mission[i];
            }

            if (tmpMax - tmpMin > difficultThreshold) {
                dayCount++;
                tmpMax = mission[i];
                tmpMin = mission[i];
            }
        }

        return dayCount + 1;
    }
}
