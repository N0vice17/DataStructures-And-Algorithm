package Searching_Algorithm;
import java.util.*;
public class BinarySearch_UsingRecursion{
	public static int binarysearch(int arr[],int num,int si,int ei){
		if(si>ei){
			return -1;
		}
		int mid = si + (ei - si) / 2;
		if(arr[mid]==num){
			return mid;
		}
		else if(ei>mid){
			return binarysearch(arr,num,mid+1,ei);
		}
		else{
			return binarysearch(arr,num,si,mid-1);
		}
	}
    public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int[]arr={1,2,3,4,5,6,7,8};
		int k=6; 
		System.out.println(binarysearch(arr,k,0,arr.length-1));
		input.close();
	}
}
