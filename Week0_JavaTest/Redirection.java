package Week0_JavaTest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Redirection {
    public static void main(String[] args) {

        /* 
         * 使用重定向
         * 
         * 使用命令提示符(cmd)作为终端环境。
         * 
         * 终端操作如下:
         * $ javac -cp .;./lib/algs4.jar .\Redirection.java
         * 该指令将algs4.jar添加到class path中并编译源代码文件
         * 
         * $ java -cp .;./lib/algs4.jar Redirection < ./redirection_input_file.txt
         * 该指令将input.txt重定向至标准输入中
         * 
         * 输出如下：
         * iufihiu2hif23
         */
        int[] whietlist = In.readInts(args[0]);

        for (int i = 0; i < whietlist.length; i++) {
            StdOut.printf("%d ", whietlist[i]);
        }

        StdOut.print(StdIn.readAll());

    }
}
