public class MaximumReversedSubarray {

    // reverse an array
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            //elements start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // find the maximum subarray sum
    private static int maxSubArraySum(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    //maximum subarray sum in a reversed array
    public static int maxReversedSubarraySum(int[] arr) {
        reverseArray(arr);
        return maxSubArraySum(arr);
    }

    public static void main(String[] args) {
        int[] array = {1, -3, 4, -2, -1, 6};
        int result = maxReversedSubarraySum(array);

        System.out.println("Maximum reversed subarray sum: " + result);
    }
}
