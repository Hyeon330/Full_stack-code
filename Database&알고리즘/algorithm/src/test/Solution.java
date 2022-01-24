package test;
/*�Ｚ ��ī���� - �ֺ�� ���ϱ�(1204��)*/
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Integer[] grade = new Integer[101];		// 0~100������ �迭(�� �������� ������ �迭�� ��ϵ� ����)
		int num = 0;							// ������ ������ �� ����
		int result = 0;							// �ֺ���� �� ����
		
		// �迭 ���� �ʱ�ȭ
		for (int i = 0; i < grade.length; i++) {
			grade[i] = 0;
		}

		// �׽�Ʈ���̽� ȸ�� �Է�
		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			bf.readLine(); // case��ȣ �Է¹��� ���ֱ�
			String inputGrade = bf.readLine(); // ���� �Է�
			StringTokenizer st = new StringTokenizer(inputGrade);	// �Է��� ���� ��ũ������ �������� �ٲ� ��
			while (st.hasMoreTokens()) {
				grade[Integer.parseInt(st.nextToken())]++;	// �� ������ġ�� �迭�� ������ �÷���
			}

			for (int j = 0; j < grade.length; j++) {	// �������� ���� ��
				if (num < grade[j] || (num == grade[j] && Arrays.asList(grade).indexOf(num) < j)) {
					// ���� ���̳��� ������ ���� < ���� ������ ���� || ( ���� ���̳��� ������ ���� == ���� ������ ���� && ���� ���� ���� ���� < ���� ����)
					// ���� ���� ������ ����
					num = grade[j];	// ���� ���̳��� ������ ���� ����
					result = j;		// �ֺ�� ����
				}
			}
			System.out.println("#" + (i+1) + " " + result);	// ���
			
			// �ؿ� 3�� ���� �ʱ�ȭ
			Arrays.fill(grade, 0);	
			num = 0;
			result = 0;
		}
	}
}
