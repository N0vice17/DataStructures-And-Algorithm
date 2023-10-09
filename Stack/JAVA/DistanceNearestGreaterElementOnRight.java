
import java.util.Arrays;
import java.util.Stack;

public class DistanceNearestGreaterElementOnRight {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(distanceNearestGreaterElementOnRight(arr)));
    }
    public static int[] distanceNearestGreaterElementOnRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }
}
