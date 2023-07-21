package Week0_JavaTest;
/* 测试Java构造器 */
public class Puppy {
    public Puppy(String name) {
        // 这个构造器仅有一个参数：name
        System.out.println("The dog's name is " + name);
    }

    public Puppy() {
        // 编译器默认使用无参的构造器
    }

    /* 这是一个嵌套类 */
    public class Collar {
        public Collar(String color) {
            // 这个构造器仅有一个参数：name
            System.out.println("Its collar colored in: " + color);
        }
    }

    public static void main(String[] args) {

        // 下面的语句将创建一个Puppy对象
        Puppy poopoo = new Puppy("poopoo");

        Collar poopoo_collar = new Puppy().new Collar("Red");

        // 调用另一个类的方法，由于该方法是static method，所以不需要实例化，可以直接调用
        HelloWorld.main(new String[] {});

        HelloWorld.static_method_saying_goodbye();
    }
}