package LearnJava._20_ObjectAndClass;

import LearnJava._10_Fundamental._10_HelloWorld;

/*
 * 嵌套类：
 * 
 * Java中有四种类型的嵌套类：
 * 
 * 静态嵌套类（Static Nested Class）：静态嵌套类是一个被 static 修饰的嵌套类。
 * 它与外部类之间没有直接的引用关系，可以直接通过外部类名访问它，并且不依赖于外
 * 部类的实例。静态嵌套类可以访问外部类的静态成员。
 * 
 * 非静态嵌套类（Non-static Nested Class）或内部类（Inner Class）：非静态嵌
 * 套类是一个没有被 static 修饰的嵌套类。它与外部类之间有一个隐式的引用关系，
 * 需要通过外部类的实例来创建内部类的对象。内部类可以访问外部类的所有成员，包括
 * 私有成员。
 * 
 * 局部类（Local Class）：局部类是在方法或作用域内部定义的类。它的作用域限定在
 * 定义它的方法或作用域内部。局部类可以访问其外部作用域的变量，但只能访问被声明
 * 为 final 或实际上是 final 的变量。
 * 
 * 匿名类（Anonymous Class）：匿名类是一种没有显式定义名称的类，它通常用作单次
 * 使用的类。它们在声明的同时被实例化，并且可以扩展类或实现接口。匿名类通常用于
 * 创建事件处理程序、线程等。
 */
public class _20_NestedClass {

    public Node first;

    // 这是一个简单的非静态嵌套类
    private class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String args[]) {

        // 由于Node是非静态嵌套类，所以必须先实例化它的外部类
        _20_NestedClass nest = new _20_NestedClass();
        // 然后才能创建Node
        nest.first = new _20_NestedClass().new Node(233, null);
        System.out.println(nest.first.val);
        System.out.println(nest.first.next);

        // 通过impot指令添加其他的类，文件夹，包。然后就可以调用其他类的方法
        // 由于这些方法是静态的，所以不需要实例化它们的类
        _10_HelloWorld.main(new String[] {});
        _10_HelloWorld.static_method_saying_goodbye();
    }
}