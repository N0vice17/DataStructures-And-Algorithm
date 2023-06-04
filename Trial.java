import Tree.*;
import LinkedList.*;
import Tries_and_Huffman_Coding.*;
import java.util.*;
public class Trial {
	public static int helper(int[]arr,int []arr1,int sum,int ind,int w) {
		if(ind>=arr.length) {
			if(w==0) {
				return sum;
			}
			return 0;
		}
		int ans=helper(arr,arr1,sum+arr[ind],ind+1,w-arr1[ind]);
		int ans1=helper(arr,arr1,sum,ind+1,w);
		return Math.max(ans, ans1);
	}
    public static void main(String[]args){
    	Scanner input=new Scanner(System.in);
    	int arr[]= {100,200,300};
    	int arr1[]= {20,25,30};
    	int w=50;
    	System.out.println(helper(arr,arr1,0,0,w));
    }   
}
