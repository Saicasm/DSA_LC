package TwoPointers;

import java.util.Arrays;


/**
 * Leetcode:283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arrayNumbers = new int[]{2, 0, 0, 15};// initialising the array
        int target = 9;
        moveZeros(arrayNumbers);
        moveZerosAlternate(arrayNumbers);
        System.out.println(Arrays.toString(arrayNumbers));
    }

    private static void moveZeros(int[] arrayNumbers) {
        // Check for the base case ; i,e: If the array is less than 2 return
        int number = arrayNumbers.length;
        if (number < 2) return;
        int left = 0;
        int right = 1;
        // This is the end case to end the loop
        while (right < number) {
            // keep iterating till you find non-zero and right will always be at least 1 ptr ahead of left(ofc)
            if (arrayNumbers[left] != 0) {
                left++;
                right++;
            }
            // If you encounter a 0 on right then move ahead without changing order
            else if (arrayNumbers[right] == 0) right++;
                // if left is zero and right is not equal to zero
            else {
                int temp = arrayNumbers[left];
                arrayNumbers[left] = arrayNumbers[right];
                arrayNumbers[right] = temp;
            }

        }
    }

    public static void moveZerosAlternate(int[] numbers) {
        int n = numbers.length;
        if (n < 2) return;
        int j = 0;
        int count = 0;
        while (j < n) {
            // Check if zero is not encountered and in such case fill the element which contains zero with the forward ptr
            if (numbers[j] != 0) {
                numbers[count] = numbers[j];
                count++;
            }
            j++;
        }
        // Fill the rest of the elements with zero
        while (count < n) {
            numbers[count] = 0;
            count++;
        }

    }

}
