package al03_stack_queue;

import java.util.Scanner;

import al03_stack_queue.IntStack.EmptyIntStackException;
import al03_stack_queue.IntStack.OverflowIntStackException;

public class IntStackMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Stack size : ");
		int max = s.nextInt();

		// 스택객체 생성
		IntStack stack = new IntStack(max);

		while (true) {
			// 현재스택의 데이터개수와 스택의 크기를 출력하고
			System.out.print("Data -> " + stack.getPoint());
			System.out.println(", Memory -> " + stack.getCapacity());
			// 메뉴표시 : push, pop, peek, print, search, empty, stack정보표시, 종료
			System.out.println("[Option]1.push, 2.pop, 3.peek, 4.print, 5.search, 6.empty, 7.info, 8.exit");
			int menu = s.nextInt();
			if (menu == 8)
				break;
			// 변수, 수식, 상수 -> 정수형, char, String
			switch (menu) {
			
			case 1: // 스택에 값을 추가한다.
				System.out.print("Push Number : ");
				int data = s.nextInt();
				try {
					stack.push(data);
				} catch (OverflowIntStackException oise) {
					System.out.println("Stack is Full!!");
				}
				break;
				
			case 2: // 스택에서 값을 얻어온다.
				try {
					System.out.println("Pop : " + stack.pop());
				} catch (EmptyIntStackException eise) {
					emptyMsg();
				}
				break;
				
			case 3: // 스택에서 제일 위에있는 데이터 가져오기
				try {
					System.out.println("Top of Number : " + stack.peek());
				} catch (EmptyIntStackException eise) {
					emptyMsg();
				}
				break;
				
			case 4:
				// 스택의 모든 데이터 출력
				stack.print();
				break;
				
			case 5: // 검색 : 값을 입력하면 값이 있는 index구하기
				System.out.print("검색할 데이터 : ");
				int search = s.nextInt();
				int idx = stack.indexOf(search);
				if (idx >= 0)
					System.out.println(search + "는 스택의 " + idx + "위치에 존재합니다.");
				else 
					System.out.println(search + "는 스택에 없습니다.");
				break;
				
			case 6: // 스택이 비어있는지 확인
				if(stack.isEmpty()) {
					emptyMsg();
				} else {
					System.out.println("스택에 데이터가 있습니다.");
				}
				break;
				
			case 7: // 스택 정보 표시
				System.out.println("스택의 크기 : " + stack.getCapacity());
				System.out.println("데이터의 갯수 : "+stack.getPoint());
				System.out.println("데이터 존재 유무 : " + (stack.isEmpty() ? "beer":"데이터 있음"));
				System.out.println("남은 데이터 용량 : "+(stack.isFull() ? "Full":"여유있음"));
				break;
			default:
				break;
			}
			System.out.println();
		}
		s.close();
		System.out.println("프로그램이 종료되었습니다.");
	}
	
	public static void emptyMsg() {
		System.out.println("Stack is beer~");
	}
}
