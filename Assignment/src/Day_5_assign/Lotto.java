package Day_5_assign;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {

    LottoNumDto lottoDto = null;
    ArrayList<Integer> lottoNum = null;
    ArrayList<LottoNumDto> lottoNums = new ArrayList<LottoNumDto>();

    public ArrayList<LottoNumDto> LottoNums(int num) {

        int randNum = 0;

        for (int i = 1; i <= num; i++) {
            lottoDto = new LottoNumDto();
            lottoNum = new ArrayList<Integer>();

            for (int j = 0; j < 7; j++) {
                randNum = (int) (Math.random() * 45 + 1);
                if (lottoNum.contains(randNum)) {
                    j--;
                } else if (j == 6) {
                    lottoDto.setBonusNum(randNum);
                } else {
                    lottoNum.add(randNum);
                }
            }
            Collections.sort(lottoNum);

            lottoDto.setMainNum(lottoNum);
            lottoNums.add(lottoDto);
        }

        return lottoNums;
    }
}

class LottoNumDto {

    private ArrayList<Integer> mainNum = new ArrayList<Integer>();
    private int bonusNum;

    public ArrayList<Integer> getMainNum() {
        return mainNum;
    }

    public void setMainNum(ArrayList<Integer> mainNum) {
        this.mainNum = mainNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }
}