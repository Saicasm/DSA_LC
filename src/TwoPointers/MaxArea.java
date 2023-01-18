package TwoPointers;

/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] heights = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };// initialising the array
        int result = getMaximunAread(heights);
        System.out.println(result);
    }

    private static int getMaximunAread(int[] heights) {
        int n = heights.length;
        // Define MIN Area, left and right pointer
        int l = 0, r = n - 1, maxArea = Integer.MIN_VALUE;
        while (l < r) {
            // Get the max val of min height of left and right point cause there can't be
            // slant in the container and already defined maxvalue
            int area = Math.max((r - l) * Math.min(heights[l], heights[r]), maxArea);
            // Keep updating the max value
            maxArea = Math.max(area, maxArea);
            if (heights[l] > heights[r]) {
                r--;
            } else
                l++;

        }
        return maxArea;
    }
}
