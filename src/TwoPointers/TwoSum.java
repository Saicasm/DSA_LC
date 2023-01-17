package TwoPointers;

import java.util.Arrays;


//  LeetCode167. Two Sum II - Input Array Is Sorted
//  Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//  Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//  The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//  Your solution must use only constant extra space.
//
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
//        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
public class TwoSum {
    public static void main(String[] args) {
//        logger.info("Test");
        int[] arrayNumbers = new int[]{ 2,7,11,15 };// initialising the array
        int target = 9;
        int[] resultArray= twoSum(arrayNumbers,target);
        System.out.println(Arrays.toString(resultArray));

    }
    private static int[] twoSum(int[] arrayOfNumbers, int targetSum) {
        // Create two pointers namely left and right which are pointing to first and last element of the array
        int leftPtr=0;
        int rightPtr=arrayOfNumbers.length-1;

        while(leftPtr<rightPtr){
            int sum=arrayOfNumbers[leftPtr]+arrayOfNumbers[rightPtr];
            // Check if the sum is equal and if so return the indexes of the elements
            if(sum==targetSum){
                return new int[] {leftPtr+1,rightPtr+1};
            }
            // if the sum is greater than the target then decrease the ptr
            else if(sum>targetSum) rightPtr--;
                // if the sum is lesser than the target then increase the ptr
            else leftPtr++;
        }
        // if there is none then return the following
        return new int[] {-1,-1};

    }


}
