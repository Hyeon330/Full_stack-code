package Day_5_assign.soccer;

public class Soccer {

    Soccer() {
        System.out.println("축구 시뮬레이션 게임!!");
        System.out.println("============================");
        System.out.println("선수들의 이름을 정해주세요!!");
        System.out.println();
    }

    int score1;
    int score2;

    public void Goal1() {
        this.score1++;
    }

    public void Goal2() {
        this.score2++;
    }

}

class Team {
    String teamName;
    Player FW1 = new PlayerFW();
    Player FW2 = new PlayerFW();
    Player MD1 = new PlayerMD();
    Player MD2 = new PlayerMD();
    Player DF1 = new PlayerDF();
    Player DF2 = new PlayerDF();
    Player[] playerList = { FW1, FW2, MD1, MD2, DF1, DF2 };

    public void playerNames() {
        System.out.println(this.FW1.getName());
        System.out.println(this.FW2.getName());
        System.out.println(this.MD1.getName());
        System.out.println(this.MD2.getName());
        System.out.println(this.DF1.getName());
        System.out.println(this.DF2.getName());
    }

}

class Player {
    private String name;
    Boolean ball = false;
    int baseShoot = 5; // 기본 슈팅 능력치
    int basePass = 5; // 기본 패스 능력치
    int baseTackle = 3; // 기본 태클 능력

    public boolean ballStateChange() {
        this.ball = !this.ball;
        return this.ball;
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