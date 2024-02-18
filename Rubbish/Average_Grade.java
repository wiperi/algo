package Rubbish;
import edu.princeton.cs.algs4.In;

public class Average_Grade {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\15617\\Documents\\92_MyGithub\\Algo\\Averge.txt");
        int[] arr = in.readAllInts();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum / arr.length);
    }
    
}