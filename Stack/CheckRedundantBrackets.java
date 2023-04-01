package Stack;
import java.util.*;
public class CheckRedundantBrackets {
    /*For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
    A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets. */
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String str=input.next();
        Stack<Character>stack=new Stack<>();
        boolean a =true;
        for(int i=0;i<str.length();i++){
         char c=str.charAt(i);
         if(c!=')'){
             stack.push(c);
         }
         else{
             System.out.println(stack);
             int count=0;
             while(stack.peek()!='('){
                 count++;
                 stack.pop();
             }
             if(count>1){
                 a=false;
             }
             else if(count==0||count==1){
                 a=true;
                 break;
             }
             count=0;
             stack.pop();
         }
        }
        System.out.println(a);
        input.close();
    }
}
