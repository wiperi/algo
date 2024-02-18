package Rubbish.LearnJava._30_Generic;

/**
 * 关键字 interface 用于定义一个接口
 * 
 * 接口是一个特殊的抽象类，它只包含抽象方法、常量和默认方法
 * 
 * 抽象方法：
 * 定义方法，但不提供具体的实现，将方法的实现交给
 * 实现该接口的类来完成，不同的类实现相同的方法，从而实现多
 * 态
 * 
 * 默认方法：
 * 默认方法的存在可以在不修改每一个实现类的情况下
 * 拓展接口，一个接口可以有多个默认方法，接口需要实现默认方
 * 法，这样实现类如果不实现它，则使用默认的方法，如果实现它
 * ，则覆盖接口提供的默认方法
 */
public interface _10_My_Interface {

    public static final int ege = 2;

    public <T> void print(T a);
}