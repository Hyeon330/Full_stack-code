package Day_5_assign.lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lotto lotto = new Lotto();

        System.out.print("로또 몇 줄? : ");
        int num = sc.nextInt();
        System.out.println();

        ArrayList<LottoNumDto> lottos = new ArrayList<LottoNumDto>();
        lottos = lotto.LottoNums(num);

        printLotto(lottos);

        sc.close();
    }

    static void printLotto(ArrayList<LottoNumDto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            int lineNum = i + 1;
            System.out.print(lineNum + " : ");
            for (Integer j : lottos.get(i).getMainNum()) {
                System.out.print(j + " ");
            }
            System.out.println(" 보너스 넘버 : " + lottos.get(i).getBonusNum());
        }
    }
}
