//Program to solve the tower of Hanoi using recurssion
public class TowerOfHanoi{
    public static void solveHanoi(int n, char source, char auxiliary, char target)
    {
        if(n == 1)
        {
            System.out.printf("Move disk 1 from %c to %c\n", source, target);
            return;
        }

        solveHanoi(n-1, source, target, auxiliary);
        System.out.printf("Move disk %d from %c to %c\n", n, source, target);
        solveHanoi(n-1, auxiliary, source, target);
    }

    public static void main(String[] args)
    {
        int numdisks = 3;
        solveHanoi(numdisks, 'A', 'B', 'C');
    }
}