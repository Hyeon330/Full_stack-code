package Day_5_assign.soccer;

public class SoccerMain {
    public static void main(String[] args) {

        Soccer soccer = new Soccer();

        String[] team1Names = { "메시", "날강두", "피를로", "베컴", "피케", "푸욜" };
        String[] team2Names = { "손흥민", "케인", "박지성", "제라드", "라모스", "루이스" };

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

        for (int i = 0; i < team1Names.length; i++) {
            team1.playerList[i].setName(team1Names[i]);
        }
        for (int i = 0; i < team2Names.length; i++) {
            team2.playerList[i].setName(team2Names[i]);
        }

        System.out.println("경기 시작합니다!!");
        System.out.println("==========================================================");

        team1.playerList[0].ballStateChange();
        for (int a = 0; a <= 90; a += (int) (Math.random() * 10)) {
            for (int t = 0; t < allTeam.length; t++) {
                for (int k = 0; k < allTeam[t].playerList.length; k++) {
                    if (allTeam[t].playerList[k].ball) {
                        System.out.println("현재 공은 " + allTeam[t].playerList[k].getName() + "선수에게 있습니다.\n");
                    }
                }
            }
            int randEvent = (int) (Math.random() * 8) + 2;
            for (int j = 0; j < randEvent; j++) { // 1회마다 이벤트 발생 슛을 날릴시 1회 종료
                for (int t = 0; t < allTeam.length; t++) { // 공이 어떤 팀에 있는지 체크
                    int shootCk = 0;
                    int passCk = 0;
                    for (int k = 0; k < allTeam[t].playerList.length; k++) { // 공이 누구에게 있는지 체크
                        if (allTeam[t].playerList[k].ball) { // 공이 있는 사람을 찾으면 행동(이벤트: 슛, 패스, 태클 당함) 발생
                            if (j == randEvent - 1) { // j가 마지막까지 오면 공을 갖고 있는 선수가 슛을 날림
                                System.out.println("[" + a + "분" + "]");
                                shootCk = 1; // 슛을 날렸는지 체크 값이 1이면 for(t)를 빠져나감
                                System.out.println(allTeam[t].playerList[k].getName() + " 슛!!!");
                                System.out.println();
                                if (allTeam[t].playerList[k].shoot() > 2) { // 골이 들어감
                                    if (t == 0) {
                                        soccer.Goal1();
                                    } else {
                                        soccer.Goal2();
                                    }
                                    System.out.println("들어갔어요!!!");
                                    System.out.println("현재 스코어 " + soccer.score1 + " : " + soccer.score2);
                                } else { // 골이 빗나감
                                    System.out.println("아!! 아쉽게 빗나갑니다.");
                                }
                                System.out.println();
                                allTeam[t].playerList[k].ballStateChange(); // 현재 공을 들고 있는 선수가 공을 놈
                                if (t == 0) { // 슛을 했기때문에 상대방 선수에게 공을 넘겨 줌
                                    allTeam[1].playerList[0].ballStateChange();
                                } else {
                                    allTeam[0].playerList[0].ballStateChange();
                                }
                                break;
                            } else { // 태클/패스 이벤트
                                if ((int) (Math.random() * 4) == 0) { // 태클
                                    int randPlayer = (int) (Math.random() * allTeam[t].playerList.length);
                                    if (t == 0) {
                                        System.out
                                                .println(allTeam[1].playerList[randPlayer].getName() + "선수의 태클!!");

                                        if (allTeam[1].playerList[randPlayer].tackle() > 1) {
                                            System.out.println("실패합니다~~");
                                        } else {
                                            System.out.println("성공합니다!!");
                                            allTeam[t].playerList[k].ballStateChange();
                                            allTeam[1].playerList[randPlayer].ballStateChange();
                                            System.out.println("공은 " + allTeam[t].playerList[k].getName()
                                                    + "선수에서 " + allTeam[1].playerList[randPlayer].getName()
                                                    + "선수로 넘어갑니다!!");
                                            j -= j - 1;
                                        }

                                    } else {
                                        System.out
                                                .println(allTeam[0].playerList[randPlayer].getName() + "선수의 태클!!");

                                        if (allTeam[0].playerList[randPlayer].tackle() > 1) {
                                            System.out.println("실패합니다~~");
                                        } else {
                                            System.out.println("성공합니다!!");
                                            allTeam[t].playerList[k].ballStateChange();
                                            allTeam[0].playerList[randPlayer].ballStateChange();
                                            System.out.println("공은 " + allTeam[t].playerList[k].getName()
                                                    + "선수에서 " + allTeam[0].playerList[randPlayer].getName()
                                                    + "선수로 넘어갑니다!!");
                                            j -= j - 1;
                                        }
                                    }
                                    System.out.println();

                                } else { // 패스
                                    int nextPlayer = 0;
                                    while (true) {
                                        nextPlayer = (int) (Math.random() * allTeam[t].playerList.length);
                                        if (!allTeam[t].playerList[nextPlayer].ball) { // 패스할 시 같은 선수 나오는 것 방지
                                            break;
                                        }
                                    }
                                    System.out.println(allTeam[t].playerList[k].getName() + " 선수가 "
                                            + allTeam[t].playerList[nextPlayer].getName() + "에게 패스합니다.");

                                    if (allTeam[t].playerList[k].pass() == 0) { // 패스 실수
                                        nextPlayer = (int) (Math.random() * allTeam[t].playerList.length);
                                        int whatTeam = (int) (Math.random() * 2);

                                        allTeam[t].playerList[k].ballStateChange();

                                        System.out.println(
                                                "아!!" + allTeam[t].playerList[k].getName() + "선수 왜 저렇게 패스하죠?!");
                                        allTeam[whatTeam].playerList[nextPlayer].ballStateChange();
                                        // 랜덤한 선수에게 공이감
                                        System.out
                                                .println("공은 " + allTeam[whatTeam].playerList[nextPlayer].getName()
                                                        + "선수에게 갔습니다.");
                                        if (t != whatTeam) {
                                            j = randEvent - j;
                                        }
                                    } else { // 패스 성공
                                        allTeam[t].playerList[k].ballStateChange();
                                        allTeam[t].playerList[nextPlayer].ballStateChange();
                                    }
                                    System.out.println();
                                }
                                passCk = 1;
                                break;
                            }
                        }
                        if (shootCk == 1 || passCk == 1) { // 슛을 날렸는지 체크 값이 1이면 for(k)를 빠져나감
                            break;
                        }
                    }
                    if (shootCk == 1 || passCk == 1) { // 슛을 날렸는지 체크 값이 1이면 for(t)를 빠져나감
                        break;
                    }
                }
                a += 1;
                if (a == 90) {
                    break;
                }
            }

        }
        System.out.println("==========================================================");
        System.err.println("경기 종료합니다!!!");

        System.out.println("최종 스코어 " + soccer.score1 + " : " + soccer.score2);

        if (soccer.score1 > soccer.score2) {
            System.out.println("Team1 win!!");
        } else if (soccer.score1 < soccer.score2) {
            System.out.println("Team2 win!!");
        } else {
            System.out.println("무승부");
        }
    }
}
