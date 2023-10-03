import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Date;

public class man {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            // 可能引发异常的代码
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // 捕获并处理ArithmeticException异常
            System.out.println("An arithmetic exception occurred: " + e.getMessage());
        } finally {
            // 无论是否发生异常，这里的代码都会执行
            System.out.println("Finally block executed.");

            Date date = new Date(12, 12, 1);
            Bag<Integer> bag = new Bag<Integer>();
            
            Set<String> a = new HashSet<>(100);
            





        }
    }

    public static int divide(int num1, int num2) {
        // 尝试除法操作，可能引发ArithmeticException异常
        return num1 / num2;
    }
}
