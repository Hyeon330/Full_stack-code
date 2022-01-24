package al03_stack_queue;

import java.util.Scanner;

import al03_stack_queue.IntStack.EmptyIntStackException;
import al03_stack_queue.IntStack.OverflowIntStackException;

public class IntStackMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Stack size : ");
		int max = s.nextInt();

		// ���ð�ü ����
		IntStack stack = new IntStack(max);

		while (true) {
			// ���罺���� �����Ͱ����� ������ ũ�⸦ ����ϰ�
			System.out.print("Data -> " + stack.getPoint());
			System.out.println(", Memory -> " + stack.getCapacity());
			// �޴�ǥ�� : push, pop, peek, print, search, empty, stack����ǥ��, ����
			System.out.println("[Option]1.push, 2.pop, 3.peek, 4.print, 5.search, 6.empty, 7.info, 8.exit");
			int menu = s.nextInt();
			if (menu == 8)
				break;
			// ����, ����, ��� -> ������, char, String
			switch (menu) {
			
			case 1: // ���ÿ� ���� �߰��Ѵ�.
				System.out.print("Push Number : ");
				int data = s.nextInt();
				try {
					stack.push(data);
				} catch (OverflowIntStackException oise) {
					System.out.println("Stack is Full!!");
				}
				break;
				
			case 2: // ���ÿ��� ���� ���´�.
				try {
					System.out.println("Pop : " + stack.pop());
				} catch (EmptyIntStackException eise) {
					emptyMsg();
				}
				break;
				
			case 3: // ���ÿ��� ���� �����ִ� ������ ��������
				try {
					System.out.println("Top of Number : " + stack.peek());
				} catch (EmptyIntStackException eise) {
					emptyMsg();
				}
				break;
				
			case 4:
				// ������ ��� ������ ���
				stack.print();
				break;
				
			case 5: // �˻� : ���� �Է��ϸ� ���� �ִ� index���ϱ�
				System.out.print("�˻��� ������ : ");
				int search = s.nextInt();
				int idx = stack.indexOf(search);
				if (idx >= 0)
					System.out.println(search + "�� ������ " + idx + "��ġ�� �����մϴ�.");
				else 
					System.out.println(search + "�� ���ÿ� �����ϴ�.");
				break;
				
			case 6: // ������ ����ִ��� Ȯ��
				if(stack.isEmpty()) {
					emptyMsg();
				} else {
					System.out.println("���ÿ� �����Ͱ� �ֽ��ϴ�.");
				}
				break;
				
			case 7: // ���� ���� ǥ��
				System.out.println("������ ũ�� : " + stack.getCapacity());
				System.out.println("�������� ���� : "+stack.getPoint());
				System.out.println("������ ���� ���� : " + (stack.isEmpty() ? "beer":"������ ����"));
				System.out.println("���� ������ �뷮 : "+(stack.isFull() ? "Full":"��������"));
				break;
			default:
				break;
			}
			System.out.println();
		}
		s.close();
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
	
	public static void emptyMsg() {
		System.out.println("Stack is beer~");
	}
}
