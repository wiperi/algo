package LearnJava._20_Object_And_Class;

/*
 * 说明：
 * 
 * 该文件展示了一个类的基本结构
 */
public class _10_Dog {

    // 成员变量，存储器和类的对象一样，在类被实例化为对象时生成，类被销毁时销毁
    private int age;
    private String breed;

    // 如果省略访问控制修饰符，那么默认为public
    String color;

    /*
     * 构造方法：
     * 
     * 每个类都有构造方法。如果没有显式地为类定义构造方法，Java 编译器将会为该类提供一个默认构造方法（无参构造方法）。
     * 在创建一个对象的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。
     */
    _10_Dog(int age, String breed, String color) {

        // 局部变量，作用域限于方法体内，自动销毁
        int dogAge = age;

        // this指代本类，super指代父类
        this.age = dogAge;
        this.breed = breed;
        this.color = color;
    }

    // 方法
    public String getBreed() {
        return breed;
    }

    // 方法，但省略了访问控制修饰符
    int getAge() {
        return age;
    }

    public static void main(String[] args) {

        /*
         * 创建对象：
         * 
         * 对象是根据类创建的。在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：
         * 
         * 声明：声明一个对象，包括对象名称和对象类型。
         * 实例化：使用关键字 new 来创建一个对象。
         * 初始化：使用 new 创建对象时，会调用构造方法初始化对象。
         */
        _10_Dog Hanson = new _10_Dog(3, "bulldog", "yellow");

        // 调用对象的方法，访问并打印对象的属性
        System.out.println("This is Hanson. He is a " + Hanson.getBreed() + " and he is " + Hanson.color);
        System.out.printf("He is %d years old", Hanson.getAge());
    }
}
