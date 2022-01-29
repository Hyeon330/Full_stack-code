package algorismProject1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");
		int[] grade = new int[s.nextInt()];
		System.out.println();
		
		for (int i = 0; i < grade.length; i++) {
			System.out.print("학생 " + (i + 1) + " 점수 입력 : ");
			grade[i] = s.nextInt();
		}
		
		Sort.quickSort(grade);

		System.out.println();
		System.out.println("성적 순으로 정렬");
		for (int i = 0; i < grade.length; i++) {
			System.out.println((i + 1) + "등 : " + grade[i]);
		}
		s.close();
	}
}
