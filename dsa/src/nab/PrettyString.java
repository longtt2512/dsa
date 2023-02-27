package nab;

/**
 * @author long.truong@finos.asia
 */
public class PrettyString {

    public static void main(String[] args) {
        int[] input = {1, 333, 4321, 54321, 21,12,688,534534};
        solution(input, 3);
    }

    public static void solution(int[] input, int k) {
        // print the line based on k value
        int rows = (int)Math.ceil((double) input.length / k);
        int maxChar = 0;
        int[][] processedArray = new int[rows][k];
        int countingCol = 0;
        int countingRow = 0;
        for (int i = 0; i < input.length; i++) {
            int temp = input[i];
            maxChar = Math.max(String.valueOf(temp).length(), maxChar);
            if (countingCol < k) {
                processedArray[countingRow][countingCol] = temp;
                countingCol++;
            } else {
                // reset
                countingCol = 0;
                countingRow++;
                processedArray[countingRow][countingCol] = temp;
                countingCol++;
            }

        }
        // header, body, footer
        boolean isPrintedFirstRow = false;
        boolean isPrintedLastRow = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < processedArray.length; i++) {
            for (int j = 0; j < processedArray[i].length; j++) {

            }
        }
    }

    public static String buildString(String str, int maxChar, boolean isFirst){
        StringBuilder
    }
}
