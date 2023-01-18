package TwoPointers;

import java.util.Arrays;

// Given an integer array nums sorted in non-decreasing order,return an array of the squares of each number sorted in non-decreasing order.

/*
 * Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */
public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] arrayNumbers = new int[] { -4, -1, 0, 3, 10 };// initialising the array
        // TODO: Take the inputs directly from CMD
        int[] sortedArrayValues = sortArray(arrayNumbers);
        System.out.println(Arrays.toString(sortedArrayValues));

    }

    private static int[] sortArray(int[] arrayNumbers) {
        // Find the MID of the array
        int mid = 0, n = arrayNumbers.length;
        for (int i = 0; i < n; i++) {
            mid = i;
            if (arrayNumbers[i] >= 0) {
                break;
            }
        }
        int leftPtr = mid - 1, rightPtr = mid;
        int[] arr = new int[n];
        // To keep track of the next index that needs to be filled
        int index = 0;
        // Keep checking until one of the condition breaks
        while (leftPtr >= 0 && rightPtr <= n - 1) {
            int leftValue = arrayNumbers[leftPtr] * arrayNumbers[leftPtr];
            int rightValue = arrayNumbers[rightPtr] * arrayNumbers[rightPtr];
            if (leftValue > rightValue) {
                arr[index] = rightValue;
                rightPtr++;
            } else {
                arr[index] = leftValue;
                leftPtr--;
            }
            index++;

        }
        while (leftPtr >= 0) {
            arr[index++] = arrayNumbers[leftPtr] * arrayNumbers[leftPtr];
            leftPtr--;
        }
        while (rightPtr <= n - 1) {
            arr[index++] = arrayNumbers[rightPtr] * arrayNumbers[rightPtr];
            rightPtr++;
        }
        return arr;
    }
}