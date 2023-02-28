package nab.test;

/**
 * @author long.truong@finos.asia
 */
public class Task2 {

    public static void main(String[] args) {
        int[] missions = {5,8,2,7};
        int thres = 3;
        System.out.println(solution(missions,thres));
    }

    public static int solution(int[] missions, int threshold) {
        int days = 0;
        int n = missions.length;
        int idx = 0;

        while (idx < n) {
            int cur_mn = Integer.MAX_VALUE;
            int cur_mx = Integer.MIN_VALUE;

            while (cur_mx - cur_mn <= threshold) {
                cur_mx = Math.max(cur_mx, missions[idx]);
                cur_mn = Math.min(cur_mn, missions[idx]);
                idx ++;
            }
            idx --;
            days ++;
        }
        return days;
    }
}
