package test;
/*삼성 아카데미 - 최빈수 구하기(1204번)*/
import java.io.*;
import java.util.StringTokenizer;

public class Solution_X {
	public static void main(String[] args) throws IOException   {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] grades = new int[1000];
		int count = 0;
		int max_g = 0;
		int max_c = 0;

		int[] T = new int[Integer.parseInt(bf.readLine())];

		for (int c = 0; c < T.length; c++) {
			T[c] = Integer.parseInt(bf.readLine());
			
			String grade = bf.readLine();
			StringTokenizer st = new StringTokenizer(grade);
			for (int i = 0; i < grades.length; i++) {
				grades[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < grades.length; i++) {
				count = 0;
				for (int j = 0; j < grades.length; j++) {
					if (grades[i] == grades[j]) {
						count++;
					}
				}
				if (max_c < count) {
					max_c = count;
					max_g = grades[i];
				} else if (max_c == count && max_g < grades[i]) {
					max_g = grades[i];
				}
			}
			System.out.println("#"+T[c]+" "+ max_g);
			System.out.println(max_c);
			max_g=0;
			max_c=0;
		}
	}
}
