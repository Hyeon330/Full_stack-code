public class OOP {
    public static void main(String[] args) {
        Car car = new Car();
        car.numOfTires = 4;
        car.on();
        System.out.println(car.numOfTires);
        System.out.println(car.와이퍼);

        Human human = new Human();
        human.age = 1;

        System.out.println(human.getAge());

        human.grow();
        human.grow();
        human.grow();
        human.grow();

        System.out.println(human.getAge());

    }
}
