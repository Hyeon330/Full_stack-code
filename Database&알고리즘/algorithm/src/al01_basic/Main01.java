package al01_basic;

import java.time.Year;
import java.util.Scanner;

public class Main01 {
	/*
	 ����
	 1��. �Է¹��� �⵵�� ����
	 
	 ����
	 6
	 4 100 400 2000 2001 2004
	 #1 ����
	 #2 ���
	 #3 ����
	 #4 ����
	 #5 ���
	 #6 ����
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] y = new int[n];
		for(int i = 0; i<n ; i++) {
			y[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++) {
			System.out.print("#"+(i+1));
			if(y[i]%4==0 && y[i]%100!=0 || y[i]%400==0) {
				System.out.println(" ����");
			} else {
				System.out.println(" ���");
			}
		}
	}

}
