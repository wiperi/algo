package Rubbish;

import java.util.Random;

import edu.princeton.cs.algs4.StdArrayIO;

public class random {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            int sum = 0;
            int count = 0;

            // 生成一行随机整数，直到平均值大于80
            while (true) {

                int[] randomNumber = new int[6];
                for (int j = 0; j < 6; j++) {
                    randomNumber[j] = random.nextInt(28) + 70; // 生成70 - 100之间的随机数
                    sum += randomNumber[j];
                }

                count++;

                if (count == 9 && sum / count > 80) {
                    // 打印当前行的随机整数
                    StdArrayIO.print(randomNumber);
                    break;
                } else if (count == 9 && sum / count <= 80) {
                    // 重新开始计算新的行
                    sum = 0;
                    count = 0;
                }
            }
        }
    }
}
