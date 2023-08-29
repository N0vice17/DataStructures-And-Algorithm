package Searching_Algorithm;
import java.util.*;
public class Binary_Searching_2D_Array {
    static int[] search(int[][]arr,int element){
        int row =0;
        int coloumn =arr.length-1;
            while(row<arr.length && coloumn>=0){
                if(arr[row][coloumn]==element){
                    return new int[]{row,coloumn};
                }
                else if(element>arr[row][coloumn]){
                    row++;
                }
                else if(element<arr[row][coloumn]){
                    coloumn--;
                }
            }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        int[][] arr={{10,20,30,40},{11,25,35,45},{28,29,37,49},{33,34,38,50}};
        int element=28;
        System.out.println(Arrays.toString(search(arr,element)));
    }
}
