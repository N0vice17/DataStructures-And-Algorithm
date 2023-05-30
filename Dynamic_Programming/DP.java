package Dynamic_Programming;
import java.util.*;
public class DP {
	public static int minsquare(int n,int dp[]) {
		if(n==0) {
			return 0;
		}
		int ans=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			if(dp[n-i*i]!=-1) {
				ans=Math.min(ans, dp[n-i*i]);
			}
			else {
				ans=Math.min(ans,minsquare(n-i*i,dp));
				dp[n-i*i]=ans;
			}
		}
		return ans+1;
	}
	public static int fibo(int arr[],int ind) {
		//fibonacci number using dynamic programming 
		if(ind<=1) {
			return ind;
		}
		arr[ind]=fibo(arr,ind-1)+fibo(arr,ind-2);
		return arr[ind];
	}
	public static void main(String[]args) {
		Scanner input=new Scanner(System.in);
		int length=input.nextInt();
		int arr[]=new int[length+1];
		System.out.println(fibo(arr,length));
	}
}
