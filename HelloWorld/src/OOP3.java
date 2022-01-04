public class OOP3 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    String name;

    void view() {
    };

    abstract void disp();
}

class Lion extends Animal {
    @Override
    void disp() {
        System.out.println("사자");
    }
}

class Tiger extends Animal {
    @Override
    void disp() {
        System.out.println("호랑이");
    }
}

interface catWorld {
    public void call();
}

class InterfaceTest implements catWorld {
    @Override
    public void call() {
        System.out.println("야옹야옹");
    }

    public static void main(String[] args) {
        InterfaceTest it = new InterfaceTest();
        it.call();
    }
}