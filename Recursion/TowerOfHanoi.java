public class TowerOfHanoi {
    public static void move(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
        } else {
            move(n - 1, source, destination, auxiliary);
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            move(n - 1, auxiliary, source, destination);
        }
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // Example number of disks
        move(numberOfDisks, 'A', 'B', 'C');
    }
}
