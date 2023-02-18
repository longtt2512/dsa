package sorting;

import org.w3c.dom.Node;

import java.util.*;

/**
 * @author long.truong@finos.asia
 */
public class TestSort {

    /*
     * Time Complexity is O(n^2)
     * Space Complexity is O(1)
     */
    public static void bubbleSort(int[] arrays) {
        // Loop from back to start to push the biggest number to the end of array
        for (int i = arrays.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
    }

    /*
     * Time Complexity is O(n^2)
     * Space Complexity is O(1)
     */
    public static void selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            // Loop from start to end to find min index
            // Note: It's just used to find min index
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[minIndex] > arrays[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arrays[minIndex];
                arrays[minIndex] = arrays[i];
                arrays[i] = temp;
            }
        }
    }


    public static void insertionSort(int[] arrays) {
        // Starting from 1 instead of 0
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];
            // Get the previous item
            int j = i - 1;
            while (j > -1 && temp < arrays[j]) {
                // Swap temp and array[j]
                arrays[j + 1] = arrays[j];
                arrays[j] = temp;
                j--;
            }
        }
    }

    // Merge facility (helper) to help merge 2 arrays
    // Time complexity is O(n logn)
    // Space complexity is O( n)
    public static int[] merge(int[] array1, int[] array2) {

        int lengthArr1 = array1.length;
        int lengthArr2 = array2.length;
        int[] combinedArray = new int[lengthArr1 + lengthArr2];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < lengthArr1 && j < lengthArr2) {
            if (array1[i] < array2[j]) {
                combinedArray[index] = array1[i];
                i++;
            } else {
                combinedArray[index] = array2[j];
                j++;
            }
            index++;
        }

        while (i < lengthArr1) {
            combinedArray[index] = array1[i];
            index++;
            i++;
        }

        while (j < lengthArr2) {
            combinedArray[index] = array2[j];
            index++;
            j++;
        }


        return combinedArray;
    }

    public static int[] mergeSort(int[] array) {
        if(array.length == 1) return array;
        int midIndex = array.length/2;

        int[] leftArray = mergeSort( Arrays.copyOfRange(array, 0, midIndex) );
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(leftArray, rightArray);
    }

    public static void main(String[] args) {
//        int[] input = new int[]{7,2, 5, 3, 9, 1, 4};
//        bubbleSort(input);
//        System.out.println("Sorting by bubble sort: " + Arrays.toString(input));

//        int[] input2 = new int[]{2, 5, 3, 9, 1, 4};
//        selectionSort(input2);
//        System.out.println("Sorting by selection sort: " + Arrays.toString(input2));
//
        int[] input = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(input));
    }

    public static int solution(int[] input) {
        // Implement your solution here
        int result = -1;
        if(input.length < 1) return result;
        HashMap<Integer, Integer> hashMapData = new HashMap<>();
        for(int i =0; i < input.length; i++){
            if(!hashMapData.containsKey(input[i])){
                hashMapData.put(input[i], 0);
            }else{
                hashMapData.put(input[i], hashMapData.get(input[i])+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMapData.entrySet()) {
            if(entry.getValue()%2 != 0){
                return entry.getKey();
            }
        }


        return result;

    }
}
