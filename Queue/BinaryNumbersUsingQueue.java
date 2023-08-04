// Program to Generate Binary Numbers from 1 to n using Queue

import java.util.*;
class Generate
{
    public static String[] generateNumbers(int n)
    {
        String num[] = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i = 0; i < n; i++)
        {
            num[i] = q.poll();
            String num1 = num[i] + "0";
            String num2 = num[i] + "1";
            q.offer(num1);
            q.offer(num2);
        }
        return num;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result[] = generateNumbers(n);
        for(String num : result)
            System.out.println(num + "\t");
    }
}
