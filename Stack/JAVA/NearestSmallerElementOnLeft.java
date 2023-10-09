
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementOnLeft {
    public static void main(String[] args) {
        int arr[] = new int[] { 4, 5, 2, 10, 8 };
        System.out.println(Arrays.toString(nearestSmallerElementOnLeft(arr)));
    }

    public static int[] nearestSmallerElementOnLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) { // res[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }
}
