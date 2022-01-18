package Day_7;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person(8602192222111L);
        Person p2 = new Person(8602192222111L);

        if (p1 == p2) {
            System.out.println("eqauls == true");
        } else {
            System.out.println("eqauls == false"); // 서로다른 주소 참조
        }

        if (p1.equals(p2)) {
            System.out.println("eqauls == true"); // 서로 같은 값
        } else {
            System.out.println("eqauls == false");
        }
    }
}

class Person {
    long id;

    Person(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            return id == ((Person) obj).id;
        } else {
            return false;
        }
    }
}
