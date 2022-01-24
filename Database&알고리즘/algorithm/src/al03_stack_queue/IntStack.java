package al03_stack_queue;

public class IntStack {

	int capacity; // �ִ�� ������ �� �ִ� ��ü�� ��
	int stk[]; // ������ ������ �� �ִ� �迭�� ����
	int point; // stack�� ä���� ���� ��ġ +1

	IntStack() {
	}

	IntStack(int max) {
		capacity = max; // ���� ������ �� �ִ� ũ��
		point = 0;
		stk = new int[max];
	}

	// �������� ���� �����ϴ� �޼ҵ�
	public int getPoint() {
		return point;
	}

	// �޸�ũ�⸦ �����ϴ� �޼ҵ�
	public int getCapacity() {
		return capacity;
	}

	public int push(int data) throws OverflowIntStackException {
		if (point >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[point++] = data;
	}

	// ������ ���� ���߿� ����� ��ġ��(point -1)�� ���� ���� �ϴ� �޼���
	public int pop() throws EmptyIntStackException {
		// ������ ��������� empty���� �߻���Ŵ
		if (point <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[--point];
	}

	// ���� ���� �ִ� ������(point -1)�� �����Ѵ�.
	public int peek() throws EmptyIntStackException {
		if (point <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[point - 1];
	}

	// stack�� ��� ������ ����ϱ�
	public void print() {
		if (point <= 0) {
			IntStackMain.emptyMsg();
		} else {
			for (int i = 0; i < point; i++) {
				System.out.println("stk[" + i + "]=" + stk[i]);
			}
		}
	}
	
	// �������� index���ϱ�
	public int indexOf(int search) {
		for (int i = point-1; i >=0; i--) { // point-1, point-2, point-3
			if(stk[i]==search) {
				return i;
			}
		}
		return -1;
	}
	
	// ���ÿ� �����Ͱ� �����ϴ��� Ȯ���ϴ� �޼���
	public boolean isEmpty() {
		// beer������ true
		return point<=0;
	}
	
	public boolean isFull() {
		return point>=capacity;
	}

	// �����÷ο� �߻��� ����ó�� Ŭ����
	@SuppressWarnings("serial")
	class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		};
	}

	// ������ ������� �� �߻���ų ���� Ŭ����
	@SuppressWarnings("serial")
	class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		};
	}
}
