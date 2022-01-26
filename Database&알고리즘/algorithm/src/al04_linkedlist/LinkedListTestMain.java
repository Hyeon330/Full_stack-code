package al04_linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListTestMain {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    // 번호와 이름을 저장할 수 있는 내부 클래스
    static class Data {
        private Integer no;
        private String name;

        static final int NO = 1; // 번호를 입력받을지 확인
        static final int NAME = 2;

        // String 리턴으로 값을 반환
        @Override
        public String toString() {
            return no + " : " + name;
        }

        public void scanData(String msg, int s) throws IOException {
            // s에는 1, 2, 3중에 하나 들어감
            if ((s & NO) == NO) {
                System.out.print("번호->"); // 번호입력
                no = Integer.parseInt(bf.readLine());
            }
            if ((s & NAME) == NAME) {
                System.out.print("이름->"); // 이름입력
                name = bf.readLine(); // 공백을 기준으로 1단어를 입력
            }
        }
    }

    enum Menu {
        ADD_FIRST("머리에 노드 삽입"),
        ADD_LAST("꼬리에 노드 삽입"),
        REMOVE_FIRST("머리 노드 삭제"),
        REMOVE_CURRENT("선택 노드 삭제"),
        DUMP("모든 노드 출력"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx)
                    return m;
            }
            return null;
        }

        Menu(String str) {
            message = str;
        }

        String getMessage() {
            return message;
        }
    }

    // 메뉴를 표시하고 메뉴의 index를 입력받아 선택한 메뉴 객체를 리턴하는 메서드
    static Menu selectMenu() throws IOException {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal() + 1, m.getMessage());
            }
            System.out.print("->");
            key = Integer.parseInt(bf.readLine()) - 1;
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) throws IOException {
        Menu menu; // 선택한 메뉴
        LinkedListTest<Data> list = new LinkedListTest<>();

        do {
            Data data;
            // 메뉴가 표시
            menu = selectMenu();
            switch (menu) {
                case ADD_FIRST: // 머리에 노드 삽입
                    data = new Data();
                    data.scanData("머리에노드삽입", Data.NO | Data.NAME);
                    list.addFirst(data);// List에 저장
                    break;
                case ADD_LAST: // 꼬리에 노드 삽입
                    data = new Data();
                    data.scanData("꼬리노드삽입", Data.NO | Data.NAME);
                    list.addLast(data);// List에 저장
                    break;
                case REMOVE_FIRST: // 머리 노드 삭제
                    list.removeFirst();
                    break;
                case REMOVE_CURRENT: // 선택 노드 삭제
                    list.removeCurrent();
                    break;
                case DUMP: // 모든 노드 출력
                    list.dump();
                    break;
                default:
                    break;
            }
        } while (menu != Menu.TERMINATE);
        System.out.println("프로그램 종료");
    }
}
