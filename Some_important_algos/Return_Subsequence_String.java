package Some_important_algos;
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
    public static void main(String[]args){
        String []arr=subsequence("abc");
        for(String it:arr){
            System.out.println(it);
        }
    }
}
