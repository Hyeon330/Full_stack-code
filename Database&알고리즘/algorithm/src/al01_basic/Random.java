package al01_basic;

public class Random {
/*
1. 1~100까지의 난수를 50만들어 합을 구하라.
2. 한줄에 6개의 난수를 출력하고
3. 마지막줄에 합을 출력한다.
4. Random클래스 사용 불가

실행
15 65 19 54 95 24
69 25 31 69 42 26
 2  8 25 62 95 32
 :
 :
 :
 :
 :
40 65

합=74537
*/
	public static void main(String[] args) {
		int num = 0;
		int result = 0;
		for(int i = 1; i<=50; i++) {
			num = (int) (Math.random() * 100) + 1;
			System.out.printf("%4d", num);
			result += num;
			if(i%6==0) {
				System.out.println();
			}
		}
		System.out.printf("\n%s=%d","합",result);
	}
}
