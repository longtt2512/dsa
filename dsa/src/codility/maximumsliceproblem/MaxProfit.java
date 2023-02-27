package codility.maximumsliceproblem;

/**
 * @author long.truong@finos.asia
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] input = {23171,
                21011,
                21123,
                21366,
                21013,
                21367};
        System.out.println(solution(input));
    }

    public static int solution(int[] input) {
        // Implement your solution here
        if(input.length == 0) return 0;
        int maxProfit = 0;
        int maxprofitCandidate = 0;

        for(int i = 1; i< input.length ; i++){
            int todayProfit = input[i] - input[i-1];
//            System.out.println("===================");
//            System.out.println("I: "+ i);
//            System.out.println("Today profit: "+ todayProfit);
            if (todayProfit >= maxprofitCandidate+ todayProfit) {

                maxprofitCandidate = todayProfit;
            } else {
                maxprofitCandidate = maxprofitCandidate + todayProfit;

            }
//            maxprofitCandidate = Math.max(todayProfit, todayProfit+maxprofitCandidate);
//            System.out.println("Max profit candidate: "+ maxprofitCandidate);
            maxProfit = Math.max(maxProfit, maxprofitCandidate);
//            System.out.println("Max profit: "+ maxProfit);
        }

        return maxProfit;
    }
}
