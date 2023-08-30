package Some_important_algos;

import java.util.*;

public class Exponentiation {
    // Normal Exponentiation
    public static long exponent(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long temp = exponent(a, b / 2);
            return (temp * temp);
        } else {
            long temp = (exponent(a, (b - 1) / 2) * exponent(a, (b - 1) / 2));
            return (a * temp);
        }
    }

    // Exponentiation with modulo
    public static long exponent1(int a, int b, int c) {
        if (b == 0) {
            return a % c;
        }
        if (b % 2 == 0) {
            long temp = exponent1(a, b / 2, c);
            return (temp * temp % c);
        } else {
            long temp = (exponent1(a, (b - 1) / 2, c) * exponent1(a, (b - 1) / 2, c)) % c;
            return (a * temp % c);
        }
    }

    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        System.out.println(exponent(2, 63));
        // System.out.println(exponent1(3,4,5));
        input.close();
    }
}