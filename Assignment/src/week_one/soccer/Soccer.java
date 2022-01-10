package week_one.soccer;

// scooer, team, player을 어떻게 상속시킬지 모르겠어서
// player을 상속한 공격수, 미드필더, 수비수 클래스를 만들었습니다.
public class Soccer {

    int score1;
    int score2;

    Soccer() {
        System.out.println("축구 시뮬레이션 게임!!");
        System.out.println("=================================");
        System.out.println("선수들의 이름을 정해주세요!!");
        System.out.println();
    }

    public void Goal1() {
        this.score1++;
    }

    public void Goal2() {
        this.score2++;
    }
}

class Team {
    String teamName;
    Player[] playerList = { new PlayerFW(), new PlayerFW(), new PlayerMD(), new PlayerMD(), new PlayerDF(),
            new PlayerDF() };

}

class Player {
    private String name;
    Boolean ball = false;
    int baseShoot = 4; // 기본 슈팅 능력치
    int basePass = 5; // 기본 패스 능력치
    int baseTackle = 3; // 기본 태클 능력치

    public void ballStateChange() {
        this.ball = !this.ball;
    }

    public int shoot() {
        int result = (int) (Math.random() * this.baseShoot);

        return result;
    }

    public int pass() {
        int result = (int) (Math.random() * this.basePass);

        return result;
    }

    public int tackle() {
        int result = (int) (Math.random() * this.baseTackle);

        return result;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PlayerFW extends Player {
    @Override
    public int shoot() {
        int result = (int) (Math.random() * super.baseShoot + 3); // 공격수 슈팅 능력

        return result;
    }
}

class PlayerMD extends Player {

    @Override
    public int pass() {
        int result = (int) (Math.random() * super.basePass + 3); // 미드필더 패스 능력

        return result;
    }
}

class PlayerDF extends Player {

    @Override
    public int tackle() {
        int result = (int) (Math.random() * super.baseTackle + 2); // 수비수 태클 능력

        return result;
    }
}