package week_one.Nation;

public class Nation {

    private String country;
    public int area;
    public int people;
    static String planet = "earth";

    String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }

    void setArea(int area) {
        this.area = area;
    }

    void setPeople(int people) {
        this.people = people;
    }

}

class Korea extends Nation {

    boolean kimchi = true;

    void eatingKimchi() {
        if (this.kimchi) {
            System.out.println("김치를 먹었습니다.");
            this.kimchi = false;
        } else {
            System.out.println("김치가 다 떨어졌습니다.ㅠㅠ");
            System.out.println("한국에 김치 없는거 실화? 이게 나라냐?");
        }
    }
}

class America extends Nation {

    int militaryBudget = 1000;

    void spendMilitaryBudget(int money) {
        this.militaryBudget -= money;
        System.out.println("국방비가 " + this.militaryBudget + "조 남았습니다.");
    }
}

class NorthKorea extends Nation {

    int nuclear = 0;

    void makeNuclear() {
        nuclear++;
        System.out.println("핵무기를 " + nuclear + "개 생성하였습니다.");
    }
}