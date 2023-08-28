package Searching_Algorithm;
import java.util.Scanner;
public class Linear_Search{
    static int search(int[] arr,int element){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }  
        return -1;
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int element=input.nextInt();
        int[] arr={2,3,4,5,68};
        int Search=search(arr,element);
        System.out.println(Search);
        input.close();
    }
}