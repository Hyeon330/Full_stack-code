package algorithmProject2;

import java.util.Scanner;

public class Main {

	static class Data {
		private Integer num;
		private String name;

		final int NO = 1;
		final int NAME = 2;

		public Integer getNo() {
			return num;
		}

		@Override
		public String toString() {
			return name;
		}

		public void inputData(Menu m, int sw) {
			System.out.println(m.getMessage());

			if ((sw & NO) == NO) {
				System.out.print("상품 번호 입력 : ");
				num = Integer.parseInt(s.nextLine());
			}
			if ((sw & NAME) == NAME) {
				System.out.print("상품명 입력 : ");
				name = s.nextLine();
			}
			System.out.println();
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
			System.out.println();
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
					break;

				case DELETE:

					break;

				case SEARCH:

					break;

				case ALL_PRODUCT:

					break;

				default:
					break;
			}
		} while (m != Menu.TERMINATE);
	}

}
