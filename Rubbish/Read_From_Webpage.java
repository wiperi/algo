package Rubbish;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;


public class Read_From_Webpage {
    public static void main(String[] args) {

        In in = new In("https://algs4.cs.princeton.edu/11model/tinyText.txt");

        int[] arr = in.readAllInts();

        StdArrayIO.print(arr);

    }
}
