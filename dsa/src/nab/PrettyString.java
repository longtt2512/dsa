package nab;

/**
 * @author long.truong@finos.asia
 */
public class PrettyString {

    public static void main(String[] args) {
        int[] input = {1, 333, 4321, 543219999, 21, 12, 688, 534534};
        solution(input, 3);
    }

    public static void solution(int[] input, int k) {
        // print the line based on k value
        if(k > input.length) k =input.length;
        int rows = (int) Math.ceil((double) input.length / k);
        int fraction = input.length % k;
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
        // print table
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < processedArray.length; i++) {
            if (i == 0) {
                // 1st row
                printLine(k, maxChar, result);
                result.append("\n");
            }
            int rowLength = processedArray[i].length;
            for (int j = 0; j < rowLength; j++) {
                result.append("|");
                StringBuilder finalContentString = new StringBuilder();
                String content = String.valueOf(processedArray[i][j]);
                if (0 != processedArray[i][j]) {
                    if (maxChar - content.length() > 0) {
                        finalContentString.append(" ".repeat(maxChar - content.length()));
                        finalContentString.append(content);
                    } else {
                        finalContentString = new StringBuilder(content);
                    }
                    result.append(finalContentString);
                    if (j == rowLength - 1) {
                        result.append("|");
                    }
                }
            }
            result.append("\n");
            if (i != rowLength - 1) {
                printLine(k, maxChar, result);

            } else {
                if (fraction > 0) {
                    printLine(fraction, maxChar, result);
                } else {
                    printLine(k, maxChar, result);
                }
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    private static void printLine(int k, int maxChar, StringBuilder result) {
        result.append("+");
        for (int m = 0; m < k; m++) {
            for (int n = 0; n < maxChar; n++) {
                result.append("-");
            }
            result.append("+");
        }
    }


}
