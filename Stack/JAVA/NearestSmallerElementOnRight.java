

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementOnRight {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerElementOnRight(arr)));
    }

    public static int[] nearestSmallerElementOnRight(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){ //res[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
                res[i]=-1;
            }
            else{
                res[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }
}
