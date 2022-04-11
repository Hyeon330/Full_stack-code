package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("D:/study/Multi Campus/Project-soboon/District.txt"));
		
		String line = null;
		String[] line_s = null;
		
		int cnt = 0;
		while(cnt != 5) {
			line = br.readLine();
			
			if(line == null) break;
			
			line_s = line.split("\t");
			System.out.println(line_s[0]+" || "+line_s[1]+" || "+line_s[2]);
		}
	}

}
