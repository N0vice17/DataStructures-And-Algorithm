import Tree.*;
import LinkedList.*;
import Tries_and_Huffman_Coding.*;
import java.util.*;
public class Trial {
    public static void main(String[]args){
    	Scanner input=new Scanner(System.in);
    	int n=input.nextInt();
    	int dp[]=new int[n+1];
    	for(int i=1;i<=n;i++) {
    		int min=Integer.MAX_VALUE;
    		for(int j=1;j*j<=i;j++) {
    			min=Math.min(min, dp[i-j*j]);
    		}
    		dp[i]=min+1;
    	}
    	System.out.println(dp[n]);
    }    
}
