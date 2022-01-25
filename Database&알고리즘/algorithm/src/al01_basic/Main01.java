package al01_basic;

import java.util.Scanner;

public class Main01 {
	/*
	 * 실행
	 * 1행. 입력받을 년도의 갯수
	 * 
	 * 실행
	 * 6
	 * 4 100 400 2000 2001 2004
	 * #1 윤년
	 * #2 평년
	 * #3 윤년
	 * #4 윤년
	 * #5 평년
	 * #6 윤년
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			y[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.print("#" + (i + 1));
			if (y[i] % 4 == 0 && y[i] % 100 != 0 || y[i] % 400 == 0) {
				System.out.println(" 윤년");
			} else {
				System.out.println(" 평년");
			}
		}
		sc.close();
	}

}
