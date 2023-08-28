package Stack;

import java.util.*;

public class multipleStacks {
    int topA, topB, stack[];

    multipleStacks(int max)// parameterised constructor
    {
        topA = -1;
        topB = max;
        stack = new int[max];
    }

    void pushA(int n)// pushing into A
    {
        if (topA == topB - 1)// checking for overflowing
        {
            System.out.println("Stack A Overflows");
        } else {
            ++topA;
            stack[topA] = n;
        }
    }

    void pushB(int n)// pushing into stack B
    {
        if (topB - 1 == topA)// checking for overflowing
        {
            System.out.println("Stack B Overflows");
        } else {
            --topB;
            stack[topB] = n;
        }
    }

    int popA()// poping from A
    {
        if (topA == -1) {
            System.out.println("Stack A underflows");
            return (-999);
        } else {
            int value;
            value = stack[topA];
            --topA;
            return (value);
        }
    }

    int popB()// poping from B
    {
        if (topB == stack.length) {
            System.out.println("Stack B underflows");
            return (-999);
        } else {
            int value;
            value = stack[topB];
            ++topB;
            return (value);
        }
    }

    void displayA() {
        if (topA == -1) {
            System.out.println("Stack A is empty");
        }
        int i;
        System.out.println("Stack A");
        for (i = topA; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    void displayB() {
        if (topB == stack.length) {
            System.out.println("Stack B is empty");
        }
        int i;
        System.out.println("Stack B");
        for (i = topB; i < stack.length; i++) {
            System.out.println(stack[i]);
        }
    }
}