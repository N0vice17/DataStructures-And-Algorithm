
import java.util.Arrays;
import java.util.Stack;

public class DistanceOfNearestGreaterElementOnLeft {
    public static void main(String[] args) {
        int arr[] = new int[] { 4, 5, 2, 10, 8 };
        System.out.println(Arrays.toString(distanceOfNearestGreaterElementOnLeft(arr)));
    }

    public static int[] distanceOfNearestGreaterElementOnLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
