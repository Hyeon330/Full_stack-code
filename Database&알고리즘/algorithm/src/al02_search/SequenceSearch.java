package al02_search;

import java.util.Scanner;

// �����˻�(linearSearch, SequenceSearch)
public class SequenceSearch {
	// for���� �̿��Ͽ� �˻��ϱ�
	// key�� ���� �ִ� ��ġ�� ���Ͽ� index�� ��ȯ�ϴ� �޼ҵ�
	static int linearSearch1(int[] data, int n, int key) {
		// �迭���� key���� �˻��ϸ� index�� �����Ѵ�.
		// ���� �˻��� index�� ������ -1�� �����Ѵ�
		for (int i = 0; i < n; i++) {
			if(data[i]==key) {
				return i;
			}
		}
		
		return 0;
	}
	
	// while���� �̿��� ��������ġ �˻�
	static int linearSearch2(int[] data, int n, int k) {
		// �迭���� key���� �˻��Ͽ� index�� �����Ѵ�.
        // ���� �˻��� index�� ������ -1�� �����Ѵ�.
        int i=0;
        while(true) { // 0,1,2,3....
            if(i==n) {// i index��ġ�� �����ϴ°�
                return -1;
            }
            if(data[i]==k) { // �˻��� �����͸� ã�� ���
                return i;
            }
            // ���� index�� ���� Ȯ���ϱ� ���� index�� 1����
            ++i;  // ++i, i++, i=i+1, i+=1 �� �� �ϳ�
        }
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �������� ���� �Է� : �迭�� ����
		System.out.print("�����ͼ�->");
		int n = sc.nextInt();
		// �迭�� ����
		int data[] = new int[n];	// 5-> 0,1,2,3,4
		
		// ������ �Է�
		for (int i = 0; i < n; i++) {
			System.out.print("data["+i+"]=");
			data[i] = sc.nextInt();
		}
		// ã�� ���ڸ� �Է¹޴´�.
		System.out.print("�˻��� ������->");
		int key = sc.nextInt();
		
		// for�� �̿��� �����˻� ȣ��
		int idx = linearSearch1(data, n, key);
		if(idx>0) { // �˻��� �����Ͱ� ���� ��
			System.out.println(key + "�� data[" + idx +"]��ġ�� �ֽ��ϴ�.");
		} else { // �˻��� ������ ������
			System.out.println(key + "�� �������� �ʴ� �������Դϴ�.");
		}
		
		int idx2 = linearSearch2(data, n, key);
		if(idx>0) { // �˻��� �����Ͱ� ���� ��
			System.out.println(key + "�� data[" + idx2 +"]��ġ�� �ֽ��ϴ�.");
		} else { // �˻��� ������ ������
			System.out.println(key + "�� �������� �ʴ� �������Դϴ�.");
		}
		
		sc.close();
	}

}
