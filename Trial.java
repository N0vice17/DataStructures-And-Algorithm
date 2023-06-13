import Tree.*;
import LinkedList.*;
import Tries_and_Huffman_Coding.*;
import java.util.*;
import Graphs.*;
public class Trial {
    public static boolean recur(int[]arr,int sum,int ind,int k){
        if(ind==arr.length){
            if(sum==k){
                return true;
            }
            return false;
        }
        boolean ans1=recur(arr,sum+arr[ind],ind+1,k);
        boolean ans2=recur(arr,sum,ind+1,k);
        return ans1|ans2;
    }
	public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int arr[]={4,3,5,2};
        int k=1;
        System.out.println(recur(arr,0,0,k));
    }
}
