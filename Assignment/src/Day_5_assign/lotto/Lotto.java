package Day_5_assign.lotto;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {

    LottoNumDto lottoDto = null;
    ArrayList<Integer> lottoNum = null;
    ArrayList<LottoNumDto> lottoNums = new ArrayList<LottoNumDto>();

    public ArrayList<LottoNumDto> LottoNums(int num) {

        int randNum = 0;

        for (int i = 1; i <= num; i++) {
            this.lottoDto = new LottoNumDto();
            this.lottoNum = new ArrayList<Integer>();

            for (int j = 0; j < 7; j++) {
                randNum = (int) (Math.random() * 45 + 1);
                if (this.lottoNum.contains(randNum)) {
                    j--;
                } else if (j == 6) {
                    this.lottoDto.setBonusNum(randNum);
                } else {
                    this.lottoNum.add(randNum);
                }
            }
            Collections.sort(this.lottoNum);

            this.lottoDto.setMainNum(this.lottoNum);
            this.lottoNums.add(this.lottoDto);
        }

        return this.lottoNums;
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