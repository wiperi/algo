package Week0_JavaTest;
/* 
 * 本文件用于练习标准输入和输出
 * 
 * 参考资料：
 *     算法（算法第四版）1.1.9.2
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class StandardIO {
    public static void main(String[] args) {

        int myInteger = 1;
        String myString = "end of the line.";

        System.out.print("The difference between function print and function println is ");
        System.out.println("that println funciton will automatically add " + myInteger + " \\n in " + myString);

        StdOut.print(myInteger + " is a int.\nand ");
        StdOut.printf("%d + %d = %d\n", myInteger, myInteger, myInteger + myInteger);

        // 读取一个字符
        StdOut.println("Hit a key to continue.");
        StdIn.readChar();

        // 读取输入流中的所有字符
        StdOut.println("Type some.");
        String messageRead = StdIn.readAll();
        StdOut.println("Here is what you just typed: " + messageRead);

        StandardIO.TestStdDraw.main(new String[] {});
    }

    public class TestStdDraw {
       public static void main(String[] args) {
           StdDraw.setPenRadius(0.05);
           StdDraw.setPenColor(StdDraw.BLUE);
           StdDraw.point(0.5, 0.5);
           StdDraw.setPenColor(StdDraw.MAGENTA);
           StdDraw.line(0.2, 0.2, 0.8, 0.2);
       }
   }
}
