
//Leetcode solution
import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;

        int[] minI = new int[nums.length];
        minI[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minI[i] = Math.min(minI[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > minI[j]) {
                while (!stack.isEmpty() && stack.peek() <= minI[j]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }

                stack.push(nums[j]);
            }
        }
        return false;
    }
}
