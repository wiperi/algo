/*
 * 1.2.5.4和1.2.5.5
 * 
 * 创建一个自定义抽象数据类型（ADT），并使用接口，继承，方法重写等java特性
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

package Chap1_Fundamental.Section2_ADT;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Man类是一种为了模拟人们之间的三角恋爱关系创建的抽象数据类型，一个Man可以loves另一个Man，并同时被多个Man
 * loved，Man实现了Compareable和Iterable接口
 */
public class _5_4_Man extends Object implements Comparable<_5_4_Man>, Iterable<_5_4_Man> {

    // instance variables
    private String name;
    private _5_4_Man loves;
    private ArrayList<_5_4_Man> lovedBy = new ArrayList<>();

    /**
     * Constructor of Man
     * 
     * @param name 指定姓名
     */
    _5_4_Man(String name) {
        this.name = name;
    }

    /**
     * 指定Man loves的对象，并在对方的lovedBy中留下记录
     * 
     * @param thatMan
     */
    public void loves(_5_4_Man thatMan) {
        this.loves = thatMan;
        thatMan.lovedBy.add(this);
    }

    /**
     * 返回当前对象loves的对象的引用，若没有则返回null
     * 
     * @return 当前对象的loves对象
     */
    public _5_4_Man loves() {
        return this.loves;
    }

    /**
     * 返回当前Man的受欢迎程度，由loves him的人数决定
     * 
     * @return number of people who loves him
     */
    public int popularity() {
        return lovedBy.size();
    }

    /**
     * 
     * @return 返回姓名
     */
    public String getName() {
        return name;
    }

    /**
     * Return a string representing this man's relationship.
     * <p>
     * Including whom he loves and whom is loved by.
     */
    @Override
    public String toString() { // 重写Java类的默认方法toString()

        String str = "";
        for (_5_4_Man man : lovedBy) {
            str = str.concat(", ");
            str = str.concat(man.getName());
        }
        if (str == "") {
            str = str.concat(" no one.");
        }

        if (loves != null) {
            return name + " loves " + loves.name + " and he is loved by " + str;
        } else {
            return name + " loves no one. Cold, and he is loved by " + str;
        }
    }

    @Override
    public boolean equals(Object that) { // 重写java类默认方法
        if (this == that)
            return true;

        if (that == null)
            return false;

        if (this.getClass() != that.getClass())
            return false;
        _5_4_Man thatMan = (_5_4_Man) that;

        if (this.name == thatMan.name)
            return true;

        return true;
    }

    /**
     * 对比两人的受欢迎程度（loved by的次数）
     * 
     * @return 两人受欢迎程度的差值
     */
    @Override
    public int compareTo(_5_4_Man thatMan) {
        int gap = this.popularity() - thatMan.popularity();
        return gap;
    }

    /**
     * 类似遍历链表，Man之间通过loves的关系连接
     */
    @Override
    public Iterator<_5_4_Man> iterator() {
        return new Iterator<_5_4_Man>() { // 内部匿名类的定义

            // 使用 Man.this 来获取当前实例的引用，Man.this
            // 表示当前实例的引用，它是一个特殊的语法，允许你在内部类中引用外部类的实例
            private _5_4_Man currentLoves = _5_4_Man.this;

            @Override
            public boolean hasNext() {
                return currentLoves == null ? false : true;
            }

            @Override
            public _5_4_Man next() {
                _5_4_Man ret = currentLoves;
                currentLoves = currentLoves.loves;
                return ret;
            }

        };
    }

    public static void main(String[] args) {
        _5_4_Man tom = new _5_4_Man("tom");
        _5_4_Man tina = new _5_4_Man("tina");

        tom.loves(tina);

        // foreach语句的含义：对于一个Iterable的数据类型tom，进行迭代，每次迭代将其中一个元素的地址赋给变量man
        for (_5_4_Man man : tom) {
            System.out.println(man.toString());
        }
    }
}