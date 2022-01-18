public class Inheritance {
    public static void main(String[] args) {
        // Mother mother = new Mother();

        Son son = new Son();
        son.printMotherAge();

        son.setBoodType("A");
        System.out.println(son.getBoodType());
    }
}

// 부모 클래스 정의
class Mother {
    int motherAge = 50;
    String hometown = "경상도";
    boolean isMarried = true;
    String bloodType = "O";

    public Mother() {
        System.out.println("Welcome ot super class");
    }
}

// 자식 클래스 정의(부모 클래스 상속)
class Son extends Mother {
    int sonAge = 23;
    String hometown = "서울";
// String boodType; << 정말 선언하지 않았는데 변수가 존재하는지?

    public Son() {
        System.out.println("welcome to sub class");
    }

    public void printMotherAge() {
        System.out.println("Mother's Age : "
         + super.motherAge);
    }

    public String getBoodType(){
        return this.bloodType;
    }

    public void setBoodType(String bloodType){
        this.bloodType = bloodType;
    }

}