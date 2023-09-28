import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class getaverage {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\15617\\Documents\\92_MyGithub\\Algo\\grade.txt");

        int[] grade = in.readAllInts();

        StdArrayIO.print(grade);

        StdOut.println("\n" + StdStats.mean(grade));

    }
}
