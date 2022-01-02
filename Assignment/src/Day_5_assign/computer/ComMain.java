package Day_5_assign.computer;

public class ComMain {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.vueAllModel();
        System.out.println();

        System.out.print("키보드 입력 : ");
        String str = computer.keyboard.Input();
        computer.monitor.setOutput(str);
        System.out.println(computer.monitor.getOutput());

        System.out.println();
        computer.mouse.clickRight();
        computer.mouse.clickRight();
    }
}
