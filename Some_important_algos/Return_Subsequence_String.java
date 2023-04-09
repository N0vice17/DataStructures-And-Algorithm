package Some_important_algos;
import java.lang.Character.Subset;
import java.util.*;
public class Return_Subsequence_String {
    public static String[]subsequence(String str){
        if(str.length()==0){
            String output[]=new String[1];
            output[0]="";
            return output;
        }
        String[]output=subsequence(str.substring(1));
        String[]output1=new String[2*output.length];
        for(int i=0;i<output.length;i++){
            output1[i]=output[i];
        }
        for(int i=0;i<output.length;i++){
            output1[output.length+i]=str.charAt(0)+output[i];
        }
        return output1;
    }
    public static void printsubsequence(String original,String helper){
        if(original.length()==0){
            System.out.println(helper);
            return;
        }
        printsubsequence(original.substring(1), helper);
        printsubsequence(original.substring(1), helper+original.charAt(0));
    }
    public static void subsets(int start,int arr[],ArrayList<Integer>helper){
        if(start==arr.length){
            for(int i=0;i<helper.size();i++){
                System.out.print(helper.get(i)+" ");
            }
            System.out.println();
            return;
        }
        helper.add(arr[start]);
        subsets(start+1,arr,helper);
        helper.remove(helper.size()-1);
        subsets(start+1,arr,helper);
    }
    public static void main(String[]args){
        int arr[]={5,12,3,17,1,18,15,3,17};
        ArrayList<Integer>helper=new ArrayList<>();
        subsets(0, arr, helper);
    }
}
