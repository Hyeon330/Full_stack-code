package algorithmProject2;

import java.util.Scanner;

public class Main {

	static class Data {
		private Integer num;
		private String name;

		final int NO = 1;
		final int NAME = 2;

		public Integer getNum() {
			return num;
		}

		@Override
		public String toString() {
			return name;
		}

		public void inputData(Menu m, int sw) {
			System.out.println();
			System.out.println(m.getMessage());
			if ((sw & NO) == NO) {
				System.out.print("상품 번호 입력 : ");
				num = Integer.parseInt(s.nextLine());
			}
			if ((sw & NAME) == NAME) {
				System.out.print("상품명 입력 : ");
				name = s.nextLine();
			}
		}
	}

	enum Menu {
		ADD("상품 등록"),
		DELETE("상품 삭제"),
		SEARCH("상품 검색"),
		ALL_PRODUCT("전체 상품 조회"),
		TERMINATE("종료");

		private final String message;

		Menu(String msg) {
			message = msg;
		}

		public String getMessage() {
			return message;
		}

		static Menu menuAt(int idx) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx) {
					return m;
				}
			}
			return null;
		}
	}

	static Scanner s = new Scanner(System.in);

	static Menu selectMenu() {
		int menuNo;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal() + 1, m.getMessage());
			}
			System.out.printf("\n메뉴 선택 : ");
			menuNo = Integer.parseInt(s.nextLine()) - 1;
		} while (menuNo < Menu.ADD.ordinal() || menuNo > Menu.TERMINATE.ordinal());
		return Menu.menuAt(menuNo);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer, Data> tree = new BinarySearchTree<>();
		Menu m;
		Data data;

		do {
			m = selectMenu();

			switch (m) {
				case ADD:
					data = new Data();
					data.inputData(m, data.NO | data.NAME);
					tree.add(data.getNum(), data);
					break;

				case DELETE:
					data = new Data();
					data.inputData(m, data.NO);
					boolean result = tree.remove(data.getNum());
					if (result) {
						System.out.println("상품 삭제 완료");
					}
					break;

				case SEARCH:
					data = new Data();
					data.inputData(m, data.NO);
					Data searchData = tree.search(data.getNum());
					if (searchData == null) {
						System.out.println("해당 상품은 존재하지 않습니다.");
					} else {
						System.out.println("상품명 : " + searchData.toString());
					}
					break;

				case ALL_PRODUCT:
					tree.print();
					break;

				default:
					break;
			}
			if (m != Menu.TERMINATE) {
				System.out.println();
			}
		} while (m != Menu.TERMINATE);
		System.out.println("종료합니다.");
	}

}
