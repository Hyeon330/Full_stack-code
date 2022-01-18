public class OOP2 {
    public static void main(String[] args) {
        Product p1 = new Product(2000000);
        System.out.println("hello world!");
        // X



    }
   
}

// X
class Product {
    String color = "red";
    boolean motor = false;
    int width = 123;
    int height = 111;
    int depth = 333;
    int price = 3000000;

    Product(){
        System.out.println("This is construct func.");
    }

    Product(int price){
        this(price, true, "red");
        System.out.println("This is construct func.");
        this.price = price;
        System.out.println(price);
    }

    Product(int price, boolean motor){
        System.out.println("This is construct func.");
        this.price = price;
        this.motor = motor;
        System.out.println(price);
        System.out.println(motor);
    }

    Product(int price, boolean motor, String color){
        System.out.println("This is construct func.");
        this.price = price;
        this.motor = motor;
        this.color = color;
        System.out.println(price);
        System.out.println(motor);
        System.out.println(color);
      }

    void motorOn () {
        this.motor = true;
        System.out.println(this.motor);
    }

    void motorOff () {
        this.motor = false;
        System.out.println(this.motor);
    }

    boolean motorOnOff(){
        this.motor = !this.motor;
        System.out.println(this.motor);
        return this.motor;
    }

    int setPrice(int price) {
        System.out.println("Validation function");
        System.out.println("Database save");
        this.price = price;
        System.out.println(this.price);
        System.out.println("Logging");
        return this.price;
    }
    
    String print() {
        return "이 오토바이의 색깔은 : " + this.color + " 이고, 이 오토바이의 가격은 : " + this.price + " 입니다.";
    }

    String print(int a) {
        return a + "되는가?";
    }

    String print(int a, int b) {
        return a + "되는가?";
    }

    String print(String a, int b) {
        return a + "";
    }

    String print(int a, String name, int price, boolean isExists) {
        return a + "되는가?";
    }

    void print2() {
        System.out.println("이 오토바이의 색깔은 : " + this.color + " 이고, 이 오토바이의 가격은 : " + this.price + " 입니다.");
    }
}
