package abst;

public class Test {
    public static void main(String[] args) {
        
    }
}

class Haha {

    public class HHAA{

        HHAA(){

        }

        void hoho(){
            System.out.println("hoho");
        }

        public int Sum(int a, int b){
            return a+b;
        }
    }

    public Haha (String s, String h){
        System.out.println(s);
        System.out.println(h);
    }

    void hello() {
        System.out.println("hello");
    }
}

class Except {
    public static void main(String[] args) {
        method1();
        System.out.println();
        method2();
        
    }

    static void method1() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            System.out.println("나까지 실행하고 return해!!");
        }
    }

    static void method2() {
        try {
            System.out.println("예외 없음~");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("나까지 실행하고 return해!!");
        }
    }
}
