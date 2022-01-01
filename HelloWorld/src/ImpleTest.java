public class ImpleTest {
    public static void main(String[] args) {
        InterfaceExam test1 = new InterfaceExam();
        test1.func1();
        System.out.println();
        InterfaceTest1 test2 = new InterfaceExam();
        test2.func1();
    }
}

interface InterfaceTest1 {
    int num = 123;

    void func1();

    void func2();
}

interface InterfaceTest2 {
    int num = 1234;

    void func1();

    void func2();
}

class InterfaceExam implements InterfaceTest1, InterfaceTest2 {

    InterfaceExam() {
        System.out.println("hahaha");
    }

    @Override
    public void func1() {
        System.out.println("hello");

    }

    @Override
    public void func2() {
        System.out.println("world");

    }

}
