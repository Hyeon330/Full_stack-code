package Day_5_assign;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("========================= Nation ===========================");
        System.out.println();

        Korea korea = new Korea();
        korea.eatingKimchi();
        korea.eatingKimchi();
        America USA = new America();
        USA.spendMilitaryBudget(32);
        NorthKorea NK = new NorthKorea();
        NK.makeNuclear();
        NK.makeNuclear();
        NK.makeNuclear();

        System.out.println();
        System.out.println("======================== Computer ==========================");
        System.out.println();

        Computer computer = new Computer();
        boolean power = false;
        computer.board.powerOnOff(power);

        System.out.println();
        System.out.println("======================== Lotto ============================");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        Lotto lotto = new Lotto();

        System.out.print("로또 몇 줄? : ");
        int num = sc.nextInt();
        System.out.println();

        ArrayList<LottoNumDto> lottoLine = new ArrayList<LottoNumDto>();
        lottoLine = lotto.LottoNums(num);

        for (int i = 0; i < lottoLine.size(); i++) {
            int lineNum = i + 1;
            System.out.print(lineNum + " : ");
            for (Integer j : lottoLine.get(i).getMainNum()) {
                System.out.print(j + " ");
            }
            System.out.println(" 보너스 넘버 : " + lottoLine.get(i).getBonusNum());
        }

        sc.close();

        System.out.println();
        System.out.println("========================= RSP ============================");
        System.out.println();

        RSP player1 = new RSP();
        RSP player2 = new RSP();

        RSP.Play(player1.Choice(), player2.Choice());

    }
}
