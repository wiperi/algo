package LearnJava._10_Fundamental;

// public为访问修饰符，class为类标识符，HellWorld为类名称，类名称必须与Java源文件名称相同
// 注意：Java的命名规则中不允许用数字开头
public class _10_HelloWorld {

    // 这里为主程序入口
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        _10_HelloWorld.static_method_saying_goodbye();
    }

    // 这是一个静态方法，意味着不需要将它的所属类实例化也可以运行这个方法
    public static void static_method_saying_goodbye() {
        System.out.println("Goodbye, World!");
    }

}