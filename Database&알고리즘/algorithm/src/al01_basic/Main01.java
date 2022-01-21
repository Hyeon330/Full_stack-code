package al01_basic;

import java.time.Year;
import java.util.Scanner;

public class Main01 {
	/*
	 ½ÇÇà
	 1Çà. ÀÔ·Â¹ÞÀ» ³âµµÀÇ °¹¼ö
	 
	 ½ÇÇà
	 6
	 4 100 400 2000 2001 2004
	 #1 À±³â
	 #2 Æò³â
	 #3 À±³â
	 #4 À±³â
	 #5 Æò³â
	 #6 À±³â
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
				System.out.println(" À±³â");
			} else {
				System.out.println(" Æò³â");
			}
		}
	}

}
