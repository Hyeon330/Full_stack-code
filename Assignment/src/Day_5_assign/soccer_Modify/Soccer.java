package Day_5_assign.soccer_Modify;

import java.util.Scanner;

// scooer, team, player을 어떻게 상속시킬지 모르겠어서
// player을 상속한 공격수, 미드필더, 수비수 클래스를 만들었습니다.
public class Soccer {

    private Player haveBallP; // 현재 공을 갖고있는 선수 정보
    private Team haveBallT; // 공을 갖고있는 팀 정보
    private Team otherTeam;
    private Team[] allTeam; // 양팀의 모든 정보가 들어있음

    Soccer() {
        System.out.println("축구 시뮬레이션 게임!!");
        System.out.println("=================================");
        System.out.println("선수들의 이름을 정해주세요!!");
        System.out.println();
    }

    public void Goal() {

    }

    public Team[] getAllteam() {
        return this.allTeam;
    }

    public void setAllTeam(Team[] allTeam) {
        this.allTeam = allTeam;
    }

    public Player getHaveBallP() {
        return this.haveBallP;
    }

    public Team getHaveBallT() {
        return this.haveBallT;
    }

    public String[] inputPlayeName(String[] playerNames) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < playerNames.length; i++) {
            System.out.print(i + 1 + "번 ");
            playerNames[i] = sc.nextLine();
        }
        sc.close();

        return playerNames;
    }

    // 현제 어떤 팀의 어떤 선수가 공을 잡고있는지 세팅하는 메서드
    public void setHaveBallPandT() {
        for (int team = 0; team < this.allTeam.length; team++) {
            for (int kickerNum = 0; kickerNum < this.allTeam[team].playerList.length; kickerNum++) {
                if (this.allTeam[team].playerList[kickerNum].ball) {
                    this.haveBallP = this.allTeam[team].playerList[kickerNum];
                    this.haveBallT = this.allTeam[team];
                    if (team == 0) {
                        this.otherTeam = this.allTeam[1];
                    } else {
                        this.otherTeam = this.allTeam[0];
                    }

                    break;
                }
            }
        }
    }

    // 슛 이벤트 발생
    public void ShootEvent(Team team1, Team team2, int minute) {
        int goalAndmissed = 0;
        System.out.println("[" + minute + "분" + "]");
        System.out.println(this.haveBallP.getName() + " 슛!!!");
        System.out.println();
        if (this.haveBallP.shoot() > 2) { // 골이 들어감
            this.haveBallT.Goal();
            System.out.println("들어갔어요!!!");
            System.out.println("현재 스코어 " + team1.score + " : " + team2.score);
            goalAndmissed = 0;
        } else { // 골이 빗나감
            System.out.println("아!! 아쉽게 빗나갑니다.");
            goalAndmissed = 5;
        }
        HaveBallChange(this.haveBallT, this.otherTeam, goalAndmissed);
        System.out.println();
    }

    // 태클 이벤트 발생
    public void TackleEvent(Team otherTeam) {
        int randPlayerNum = (int) (Math.random() * haveBallT.playerList.length);
        System.out.println(otherTeam.playerList[randPlayerNum].getName() + "선수의 태클!!");
        if (otherTeam.playerList[randPlayerNum].tackle() > 1) {
            System.out.println("실패합니다~~");
        } else {
            System.out.println("성공합니다!!");
            randPlayerChange(otherTeam, randPlayerNum);
            System.out.println("공은 " + this.haveBallP.getName()
                    + "선수에서 " + otherTeam.playerList[randPlayerNum].getName()
                    + "선수로 넘어갑니다!!");
        }
    }

    // 패스 이벤트 발생
    public void PassEvent(int event) {
        int nextPlayer = 0;
        while (true) {
            nextPlayer = (int) (Math.random() * this.haveBallT.playerList.length);
            if (!haveBallT.playerList[nextPlayer].ball) { // 패스할 시 같은 선수 나오는 것 방지
                break;
            }
        }
        System.out.println(this.haveBallP.getName() + " 선수가 "
                + haveBallT.playerList[nextPlayer].getName() + "선수에게 패스합니다.");

        if (this.haveBallP.pass() == 0) { // 패스 실수
            PassMissed(event);
        } else { // 패스 성공
            this.haveBallP.ballStateChange();
            haveBallT.playerList[nextPlayer].ballStateChange();
        }
        System.out.println();
    }

    // 패스 실수 이벤트 발생
    public void PassMissed(int event) {
        int nextPlayer = 0;
        int whatTeam = 0;
        while (true) {
            nextPlayer = (int) (Math.random() * this.haveBallT.playerList.length);
            whatTeam = (int) (Math.random() * 2);
            if (!allTeam[whatTeam].playerList[nextPlayer].ball) { // 패스할 시 같은 선수 나오는 것 방지
                break;
            }
        }
        System.out.println("아!!" + this.haveBallP.getName() + "선수 왜 저렇게 패스하죠?!");
        this.haveBallP.ballStateChange();
        allTeam[whatTeam].playerList[nextPlayer].ballStateChange();
        // 랜덤한 선수에게 공이감
        System.out.println("공은 " + allTeam[whatTeam].playerList[nextPlayer].getName() + "선수에게 갔습니다.");
        if (this.getHaveBallT() != allTeam[whatTeam]) {
            event -= event - 1;
        }
    }

    // 슛을 쏘고 골이 들어가거나, 빗나갔을 때 공을 상대선수에게 넘겨주는 메서드
    public void HaveBallChange(Team team1, Team team2, int playerNum) {
        this.haveBallP.ballStateChange();
        if (this.haveBallT == team1) { // 볼 갖고있는 팀 변경
            team2.playerList[playerNum].ballStateChange();
        } else {
            team1.playerList[playerNum].ballStateChange();
        }
    }

    // 태클을 걸릴 시 태클을 건 선수로 공이 넘어감
    public void randPlayerChange(Team otherTeam, int randPlayerNum) {
        haveBallP.ballStateChange();
        otherTeam.playerList[randPlayerNum].ballStateChange();
    }
}

class Team {
    String teamName;
    int score = 0;

    // 선수 생성
    Player[] playerList = { new PlayerFW(), new PlayerFW(), new PlayerMD(), new PlayerMD(), new PlayerDF(),
            new PlayerDF() };

    public void Goal() {
        this.score++;
    }
}

class Player {
    private String name;
    Boolean ball = false;
    int baseShoot = 4; // 기본 슈팅 능력치
    int basePass = 5; // 기본 패스 능력치
    int baseTackle = 3; // 기본 태클 능력치

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

    public void ballStateChange() {
        this.ball = !this.ball;
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