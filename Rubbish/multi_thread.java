package Rubbish;
import java.util.Arrays;

public class multi_thread {
    public static void use_threads(String[] args) {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("th1 runs " + i);
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("th2 runs " + i);
                }
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("th3 runs " + i);
                }
            }
        });

        th3.start();
        th1.start(); // Start thread 1
        th2.start(); // Start thread 2
    }

    class SleepSort {
        public static void main(String[] args) {
            int[] arr = { 5, 3, 1, 4, 2 };
            int[] sortedArr = new int[arr.length];

            Thread[] threads = new Thread[arr.length];

            for (int i = 0; i < arr.length; i++) {
                final int index = i;
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(arr[index] * 100); // Sleep for number seconds
                            sortedArr[index] = arr[index];
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threads[i].start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Arrays.sort(sortedArr);

            System.out.println("Sorted numbers: " + Arrays.toString(sortedArr));
        }

        static public void sort(int[] arr) {
            Thread[] threads = new Thread[arr.length];
            for (int i = 0; i < arr.length; i++) {
                final int index = i;
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(arr[index] * 1);
                            System.out.println(arr[index] + " ");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threads[i].start();
            }
        }
    }

    public static void main(String[] args) {
        SleepSort.sort(new int[] { 1, 1000, 2, 3, 4, 5 });
    }
}