package nab.test2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author long.truong@finos.asia
 */
public class Task3 {

    public static void main(String[] args) {
//        int[] inputs = {1,2,3,3,2};
        int[] inputs = {2, 3, 5, 2, 3, 4, 6, 4, 1};
//        int[] inputs = {1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1};



//        int[] inputs = buildData2();
//        System.out.println(Arrays.toString(inputs));
//        int solution = solution(ints);
        System.out.println(solution(inputs));
        System.out.println(solution2(inputs));

    }

    public static int[] buildData2(){
        Random random = new Random();
        int N = random.nextInt(30);
        int[] A = new int[N];
        for (int xtest = 0; xtest < 100; xtest++) {

            for (int i = 0; i < N; i++) {
                A[i] = random.nextInt(1000);
            }
        }

        return A;
    }

    public static int[] buildData() {
        int[] result = new int[100_000];
        int temp = 1_000_000;
        for (int i = 0; i < result.length; i++) {
            result[i] = temp;
            temp--;
        }
        return result;
    }

    public static int solution2(int[] A) {
        int N = A.length;

        if (N == 2) return A[0] + A[1];
        if (N == 3) return A[1] + (Math.max(A[0], A[2]));
        if (N == 4) return A[0] + A[1] + A[2] + A[3];
        if (N == 5) return A[1] + A[2] + A[3] + (Math.max(A[0], A[4]));
        if (N == 6) return A[0] + A[1] + A[2] + A[3] + A[4] + A[5];

        int max = 0;
        for (int i = 0; i < N - 5; i++) {
            for (int j = i + 2; j < N - 3; j++) {
                for (int k = j + 2; k < N - 1; k++) {
                    max = Math.max(max, A[i] + A[i + 1] + A[j] + A[j + 1] + A[k] + A[k + 1]);
                }
            }
        }

        return max;
    }

    static int solution(int[] input) {
        int N = input.length;
        if (N == 2) return input[0] + input[1];
        if (N == 3) return input[1] + (Math.max(input[0], input[2]));
        if (N == 4) return input[0] + input[1] + input[2] + input[3];
        if (N == 5) return input[1] + input[2] + input[3] + (Math.max(input[0], input[4]));
        if (N == 6) return input[0] + input[1] + input[2] + input[3] +input[4] + input[5];

        int max = 0;
        int maxSlice = 0;
        Map<String, Integer> tracking = new LinkedHashMap<>();
        for (int i = 1; i < input.length - 1; i++) {
            int temp = input[i] + input[i + 1];
            int temp2 = input[i] + input[i - 1];
            maxSlice = Math.max(temp, temp2);
            String key;
            if (temp > temp2) {
                key = i + "|" + (i + 1);
            } else {
                key = (i - 1) + "|" + i;
            }
            if (!tracking.containsKey(key) && (tracking.get(key) == null ? 0 : tracking.get(key)) < maxSlice)
                tracking.put(key, maxSlice);

        }
        Map<String, Integer> sortedTracking = new LinkedHashMap<>();
        tracking.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedTracking.put(x.getKey(), x.getValue()));
        System.out.println("=============================");
        sortedTracking.forEach( (k,v) -> System.out.println(k+ " "+ v));
        System.out.println("=============================");
        List<String> checkedString = new ArrayList<>();

        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedTracking.entrySet()) {
            String[] comparedStrings = entry.getKey().split("\\|");
            if(count == 3) break;
            if (count == 0){
                max = entry.getValue();
                checkedString.addAll(List.of(comparedStrings));
                count++;
                continue;
            }
            if(!checkedString.contains(comparedStrings[0]) && !checkedString.contains(comparedStrings[1])){
                checkedString.addAll(List.of(comparedStrings));
                max += entry.getValue();
                ++count;
            }



        }

        return max;
    }
}
