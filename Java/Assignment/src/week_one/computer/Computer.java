package week_one.computer;

import java.util.ArrayList;
import java.util.Scanner;

public class Computer {
    Monitor monitor = new Monitor();
    Keyboard keyboard = new Keyboard();
    Mouse mouse = new Mouse();
    Desktop desktop = new Desktop();

    public void vueAllModel() {
        System.out.println("Monitor : " + this.monitor.model);
        System.out.println("keyboard : " + this.keyboard.model);
        System.out.println("mouse : " + this.mouse.model);
        System.out.println("desktop : " + this.desktop.vueAllProduct());
    }
}

class Monitor {
    String model = "X-over 270X 144 Curved"; // 모델명
    String color = "black"; // 색상
    int inch = 27; // 인치
    int resolutionWidth = 1920; // 해상도 가로
    int resolutionLength = 1080; // 해상도 세로
    int refreshRate = 144; // 주사율
    boolean monitorPower; // 전원
    String output;

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String out) {
        this.output = out;
    }

    // 모니터 전원 on/off
    public void powerOnOff() {
        this.monitorPower = !this.monitorPower;
    }

}

class Keyboard {
    String model = "CORSAIR K65 RAPIDFIRE RGB";

    public String Input() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        return str;
    }
}

class Mouse {

    String model = "Logitech G PRO";

    public void clickRight() {
        System.out.println("Right click!!");
    }

    public void clickLeft() {
        System.out.println("Left click!!");
    }
}

class Desktop {
    String cpu = "AMD Ryzen 5600X";
    String mainBoard = "ASUS B550M-K";
    String ssd = "Samsung 970 EVO M.2 NVMe";
    String memory1;
    String memory2 = "GeIL DDR4-3200 8GB";
    String memory3;
    String memory4 = "GeIL DDR4-3200 8GB";
    String VGA = "ZOTAC GeForce GTX1070 MINI D5 8GB";
    String power = "SuperFlower SF-650F";

    public ArrayList<String> vueAllProduct() {
        ArrayList<String> allProduct = new ArrayList<String>();
        allProduct.add(cpu);
        allProduct.add(mainBoard);
        allProduct.add(ssd);
        allProduct.add(memory1);
        allProduct.add(memory2);
        allProduct.add(memory3);
        allProduct.add(memory4);
        allProduct.add(VGA);
        allProduct.add(power);

        return allProduct;
    }

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public void setssd(String ssd) {
        this.ssd = ssd;
    }

    public void setMemory1(String memory1) {
        this.memory1 = memory1;
    }

    public void setMemory2(String memory2) {
        this.memory2 = memory2;
    }

    public void setMemory3(String memory3) {
        this.memory3 = memory3;
    }

    public void setMemory4(String memory4) {
        this.memory4 = memory4;
    }

    public void setVGA(String VGA) {
        this.VGA = VGA;
    }

    public void setpower(String power) {
        this.power = power;
    }
}