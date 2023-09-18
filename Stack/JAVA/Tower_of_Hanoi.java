import java.util.*;
class Tower_Of_Hanoi
{
    
    static void towerOfHanoi(int n, char from_rod,char aux_rod ,char to_rod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, to_rod, aux_rod);
        towerOfHanoi(1, from_rod, aux_rod, to_rod);
        towerOfHanoi(n-1, aux_rod,from_rod,to_rod);
    }
     
    
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of disks");
        int n=in.nextInt(); // Number of disks
        towerOfHanoi(n,'A','B','C');  // A, B and C are names of rods
    }
}