package Stack;
import java.util.*;
public class BalancedParanthesis {
    public static boolean helper(String str){
		Stack<Character>stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			Character c=str.charAt(i);
			if(c=='('||c=='['||c=='{'){
				stack.push(c);
				//System.out.println(stack.toString());
			}
			else{
				if(stack.isEmpty()){
					return false;
				}
				else{
					if(stack.peek()=='('&&c==')'||stack.peek()=='{'&&c=='}'||stack.peek()=='['&&c==']'){
						stack.pop();
					}
					else{
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String str=input.next();
        System.out.println(helper(str));
		input.close();
    }
}
