package test;
/*삼성 아카데미 - 최빈수 구하기(1204번)*/
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Integer[] grade = new Integer[101];		// 0~100점까지 배열(각 점수별로 개수가 배열에 등록될 것임)
		int num = 0;							// 점수의 개수가 들어갈 변수
		int result = 0;							// 최빈수가 들어갈 변수
		
		// 배열 전부 초기화
		for (int i = 0; i < grade.length; i++) {
			grade[i] = 0;
		}

		// 테스트케이스 회수 입력
		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			bf.readLine(); // case번호 입력버퍼 뺴주기
			String inputGrade = bf.readLine(); // 점수 입력
			StringTokenizer st = new StringTokenizer(inputGrade);	// 입력한 점수 토크나이저 형식으로 바꿔 줌
			while (st.hasMoreTokens()) {
				grade[Integer.parseInt(st.nextToken())]++;	// 각 점수위치의 배열의 개수를 올려줌
			}

			for (int j = 0; j < grade.length; j++) {	// 점수별로 개수 비교
				if (num < grade[j] || (num == grade[j] && Arrays.asList(grade).indexOf(num) < j)) {
					// 가장 많이나온 점수의 개수 < 현재 점수의 개수 || ( 가장 많이나온 점수의 개수 == 현재 점수의 개수 && 가장 많이 나온 점수 < 현재 점수)
					// 위의 조건 만족시 진입
					num = grade[j];	// 가장 많이나온 점수의 개수 변경
					result = j;		// 최빈수 변경
				}
			}
			System.out.println("#" + (i+1) + " " + result);	// 출력
			
			// 밑에 3개 전부 초기화
			Arrays.fill(grade, 0);	
			num = 0;
			result = 0;
		}
	}
}
