package Day_5_assign;

public class Computer {

    MainBoard board = new MainBoard();
    CPU cpu = new CPU();
    Memory ram = new Memory();
    SSD ssd = new SSD();
    GraphicCard VGA = new GraphicCard();
    PowerSP powerSP = new PowerSP();
}

class MainBoard {

    int num = 123132;

    boolean powerOnOff(boolean power) {
        power = !power;
        if (power) {
            System.out.println("On!!");
        } else {
            System.out.println("Off!!");
        }

        return power;
    }
}

class CPU {

    int plus(int a, int b) {

        return a + b;
    }

    int minus(int a, int b) {

        return a - b;
    }

    int mul(int a, int b) {

        return a * b;
    }

    int div(int a, int b) {

        return a / b;
    }

    int mod(int a, int b) {

        return a % b;
    }
}

class Memory {

}

class SSD {

}

class GraphicCard {

}

class PowerSP {

}