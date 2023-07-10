public class Puppy {
    public Puppy(String name) {
        // 这个构造器仅有一个参数：name
        System.out.println("小狗的名字是 : " + name);
    }

    public Puppy() {
        // 编译器默认使用无参的构造器
    }

    /* 这是一个嵌套类 */
    public class SecondPuppy {
        public SecondPuppy(String name) {
            // 这个构造器仅有一个参数：name
            System.out.println("the dog's name is: " + name);
        }
    }

    public static void main(String[] args) {

        // 下面的语句将创建一个Puppy对象
        Puppy myPuppy = new Puppy("tommy");
        

        SecondPuppy mySecondPuppy = new Puppy("andy").new SecondPuppy("James");
        
        HelloWorld.main(new String[] {});
        
        HelloWorld.staticmethod();
    }

}