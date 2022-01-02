package Day_5_assign.computer;

public class ComMain {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.vueAllModel();
        System.out.println();

        System.out.print("키보드 입력 : ");
        computer.keyboard.Input();
        System.out.println(computer.monitor.output);
        computer.monitor.printOutput();

        System.out.println();
        computer.mouse.clickRight();
        computer.mouse.clickRight();
    }
}
