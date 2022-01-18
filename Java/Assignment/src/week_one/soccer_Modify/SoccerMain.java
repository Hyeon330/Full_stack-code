package week_one.soccer_Modify;

public class SoccerMain {
    public static void main(String[] args) {

        Soccer soccer = new Soccer();

        int playerNum = 6;
        String[] team1Names = new String[playerNum];
        String[] team2Names = new String[playerNum];
        // 원래는 직접 입력해야함
        // System.out.println("1팀 입력");
        // team1Names = soccer.inputPlayeName(team1Names);
        // System.out.println();
        // System.out.println("2팀 입력");
        // team2Names = soccer.inputPlayeName(team2Names);

        String[] exTeam1Names = { "메시", "날강두", "피를로", "베컴", "피케", "푸욜" };
        String[] exTeam2Names = { "손흥민", "케인", "박지성", "제라드", "라모스", "퍼디난드" };
        for (int i = 0; i < exTeam1Names.length; i++) {
            team1Names[i] = exTeam1Names[i];
            team2Names[i] = exTeam2Names[i];
        }

        System.out.print("1팀 : ");
        for (String s : team1Names) {
            System.out.print(s + " ");
        }
        System.err.println();
        System.out.print("2팀 : ");
        for (String s : team2Names) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println();

        Team team1 = new Team();
        Team team2 = new Team();
        Team[] allTeam = { team1, team2 };
        soccer.setAllTeam(allTeam);

        for (int i = 0; i < team1Names.length; i++) {
            team1.playerList[i].setName(team1Names[i]);
        }
        for (int i = 0; i < team2Names.length; i++) {
            team2.playerList[i].setName(team2Names[i]);
        }

        System.out.println("경기 시작합니다!!");
        System.out.println("==========================================================");

        int startHaveBall = (int) (Math.random() * 2);
        allTeam[startHaveBall].playerList[0].ballStateChange(); // 경기 시작시 랜덤한 팀의 1번 선수에서 시작
        for (int minute = 0; minute <= 90; minute += (int) (Math.random() * 10)) {
            soccer.setHaveBallPandT();
            System.out.println("현재 공은 " + soccer.getHaveBallP().getName() + "선수에게 있습니다.");
            System.out.println();
            int randEvent = (int) (Math.random() * 8) + 3;
            for (int event = 0; event < randEvent; event++) { // 1회마다 이벤트 발생 슛을 날릴시 1회 종료
                soccer.setHaveBallPandT();
                if (event == randEvent - 1) {
                    soccer.ShootEvent(team1, team2, minute);
                } else {
                    if ((int) (Math.random() * 4) == 0) { // 태클 거는 이벤트가 나올 확율 1/4
                        if (soccer.getHaveBallT() == team1) {
                            soccer.TackleEvent(team2);
                        } else {
                            soccer.TackleEvent(team1);
                        }
                        event -= event - 1;
                        System.out.println();
                    } else { // 패스
                        soccer.PassEvent(event);
                    }
                }
                minute += 1;
                if (minute == 90) {
                    break;
                }
            }

        }
        System.out.println("==========================================================");
        System.err.println("경기 종료합니다!!!");

        System.out.println("최종 스코어 " + team1.score + " : " + team2.score);

        if (team1.score > team2.score) {
            System.out.println("Team1 win!!");
        } else if (team1.score < team2.score) {
            System.out.println("Team2 win!!");
        } else {
            System.out.println("무승부");
        }
    }
}
