public class Parent {
    private int a = 10; // 설명 필요
    public int b = 20;
}

class Child extends Parent {
    // public int b = 20;
    public int c = 30;
    void display() {
        // System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class PrivateTest {
    public static void main(String[] args) {
        // 선언, 객체화 : Parent, Child
        Parent parent = new Parent();
        Child child = new Child();

        child.display();
    }
}