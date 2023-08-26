// Java Program to convert an Infix Expression to a Prefix Expression using Stack.
/*
  An infix expression is basically the algebraic expression which we write normally. On the other hand, a prefix expression is a special
  way of representing an infix expression, where after each operation, the operator is written before the operands.

  For example, 
  Suppose the infix operation is A+B*(C/D + E) - F
  The prefix of the expression becomes +A-*B+/CDEF
*/

package Stack;
import java.util.*;
public class InfixToPrefixConverter {
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private static int getPrecedence(char op) {
      /*
        This method returns the precedence of the operator. 
        Arguments: char
        Return type: int
      */
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    public static String infixToPrefix(String infix) {
      /*
        This method converts the infix expression to prefix expresison, by utilising stacks.
        Arguments: String
        Return type: String
      */
        Stack<Character> stack_operator = new Stack<>();
        Stack<String> stack_operand = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack_operand.push(Character.toString(ch));
            } else if (ch == ')') {
                stack_operator.push(ch);
            } else if (ch == '(') {
                while (!stack_operator.isEmpty() && stack_operator.peek() != ')') {
                    char op = stack_operator.pop();
                    String o1 = stack_operand.pop();
                    String o2 = stack_operand.pop();
                    String temp = op + o1 + o2;
                    stack_operand.push(temp);
                }
                stack_operator.pop();
            } else if (isOperator(ch)) {
                while (!stack_operator.isEmpty() && getPrecedence(stack_operator.peek()) >= getPrecedence(ch)) {
                    char op = stack_operator.pop();
                    String o1 = stack_operand.pop();
                    String o2 = stack_operand.pop();
                    String temp = op + o1 + o2;
                    stack_operand.push(temp);
                }
                stack_operator.push(ch);
            }
        }

        while (!stack_operator.isEmpty()) {
            char op = stack_operator.pop();
            String o1 = stack_operand.pop();
            String o2 = stack_operand.pop();
            String temp = op + o1 + o2;
            stack_operand.push(temp);
        }

        return stack_operand.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression: ");
        String infixExpression = sc.nextLine();
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}
