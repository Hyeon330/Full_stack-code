public class OverRdEx1 {

    public static void main(String[] args) {
        // Mother mother = new Mother();
        Son son = new Son();

        son.printMotherAge();
    }
}

class Mother {
    int motherAge = 50;

    Mother() {
        System.out.println("welcome to Super class");
    }

    public void printMotherAge() {
        System.out.println("Mother's Age : " + motherAge);
    }

}

class Son extends Mother {
    int sonAge = 23;

    Son() {
        System.out.println("welcome to sub class");
    }
}

// interface test1 {
// int num = 5;

// public static void func1() {
// System.out.println("hello1");
// }

// public default void func2() {
// System.out.println("world1");
// }
// }

// interface test2 {
// public static void func1() {
// System.out.println("hello2");
// }

// public default void func2() {
// System.out.println("world2");
// }
// }

// class interTest implements test1, test2 {
// public void func1() {

// }

// public void func2() {

// }
// }