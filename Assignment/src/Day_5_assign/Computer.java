package Day_5_assign;

import java.util.Scanner;

public class Computer {

}

class Monitor {
    String Model = "X-Over 270X 커브드"; // 모델명
    String color = "black"; // 색상
    int inch = 27; // 인치
    int resolutionWidth = 1920; // 해상도 가로
    int resolutionLength = 1080; // 해상도 세로
    int refreshRate = 144; // 주사율
    boolean monitorPower; // 전원
    private String output;

    // 모니터 전원 on/off
    public void powerOnOff() {
        this.monitorPower = !this.monitorPower;
    }

    public void setoutput(String input) {
        this.output = input;
    }

    public String getoutput() {
        return this.output;
    }
}

class Keyboard {
    String Model = "CORSAIR K65 RAPIDFIRE RGB 은축";

    public void input() {
        Scanner sc = new Scanner(System.in);
        Monitor monitor = new Monitor();

        String str = sc.nextLine();
        monitor.setoutput(str);
        monitor.getoutput();

        sc.close();
    }
}

class Mouse {

}

class Desktop {

}