package tryTest;

public class ExecptionEx2 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4); // 실행되지 않는다
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(5);
        }
        System.out.println(6);

    }
}

// class Parent {
// public void Hello() {
// System.out.println("hello");
// }
// }

// class Child extends Parent {
// @Override
// public void Hello() {
// System.out.println("haha");
// }
// }

// class Brother extends Parent {
// @Override
// public void Hello() {
// System.out.println("bro~");
// }
// }

// class Test {
// public static void main(String[] args) {
// Child ch = (Child) new Parent();

// ch.Hello();

// }
// }