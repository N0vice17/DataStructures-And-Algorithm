package Stack;
import java.util.*;
public class infixTopostfix {
    int sp;
    char ch[];
    int i;

    infixTopostfix(int n) {
        ch = new char[n];
        sp = -1;
    }

    void convert(char c[]) {

        char result[] = new char[c.length];
        int k = 0;
        char s, s2;
        for (i = 0; i < c.length; i++) {
            s = c[i];
            if (check(s)) {
                result[k++] = s;

            } else {
                while (sp != -1 && (order(s) <= order(ch[sp])) && s != '(') {
                    s2 = pop();
                    if (s2 == '(') {
                        break;

                    } else if (s2 != '(') {
                        result[k++] = s2;
                    }
                }
                if (s != ')') {
                    push(s);
                }

            }

        }
        while (sp != -1) {
            result[k++] = pop();
        }

        for (i = 0; i < k; i++) {
            if (result[i] != '(' && result[i] != ')') {
                System.out.print(result[i]);
            }
        }

    }

    boolean check(char p) {
        return ((p >= '0' && p <= '9') || (p >= 'a' && p <= 'z') || (p >= 'A' && p <= 'Z'));
    }

    int order(char t) {
        switch (t) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '$':
                return 3;
            default:
                System.out.println("invalid");
                return (-1);

        }
    }

    void push(char a) {
        sp++;
        ch[sp] = a;
    }

    char pop() {
        return (ch[sp--]);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the expression");
        String expre;
        expre = in.next();
        char cc[] = expre.toCharArray();
        infixTopostfix ob = new infixTopostfix(cc.length);
        ob.convert(cc);

    }
}