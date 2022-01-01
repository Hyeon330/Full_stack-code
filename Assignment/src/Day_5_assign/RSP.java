package Day_5_assign;

import java.util.ArrayList;

public class RSP {

    int Choice() {

        int result = (int) (Math.random() * 3);

        return result;
    }

    static void Play(int Player1, int Player2) {
        ArrayList<String> cho = new ArrayList<String>();
        cho.add("가위");
        cho.add("바위");
        cho.add("보");

        System.out.print("Player1 : " + cho.get(Player1));
        System.out.println("    Player2 : " + cho.get(Player2));

        System.out.println();
        if (Player1 == Player2) {
            System.out.println("무승부");

        } else if ((Player1 == 1 && Player2 == 2) ||
                (Player1 == 2 && Player2 == 0) ||
                (Player1 == 0 && Player2 == 1)) {
            System.out.println("Player2 승");
        } else {
            System.out.println("Player1 승");
        }
    }

}