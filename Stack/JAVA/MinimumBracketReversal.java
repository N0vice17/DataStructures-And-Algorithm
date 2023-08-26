package Stack;
import java.util.*;
/*For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.If the expression can't be balanced, return -1. */
public class MinimumBracketReversal {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String str=input.next();
        Stack<Character>stack=new Stack<>();
        if(str.length()%2==0){
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()==false){
                    if(stack.peek()=='{'){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                }
                else{
                    stack.push(c);
                }
            }
        }
        char c1=' ';
        char c2=' ';
        int count=0;
        while(!stack.isEmpty()){
            c1=stack.peek();
            stack.pop();
            c2=stack.peek();
            stack.pop();
            if(c1==c2){
                count=count+1;
            }
            else{
                count=count+2;
            }
        }
        System.out.println(count);
        }
        else{
            System.out.println(-1);
        }
        input.close();
    }
}
