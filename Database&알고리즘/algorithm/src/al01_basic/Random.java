package al01_basic;

public class Random {
/*
1. 1~100������ ������ 50����� ���� ���϶�.
2. ���ٿ� 6���� ������ ����ϰ�
3. �������ٿ� ���� ����Ѵ�.
4. RandomŬ���� ��� �Ұ�

����
15 65 19 54 95 24
69 25 31 69 42 26
 2  8 25 62 95 32
 :
 :
 :
 :
 :
40 65

��=74537
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
		System.out.printf("\n%s=%d","��",result);
	}
}
