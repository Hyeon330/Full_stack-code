package al03_stack_queue;

public class IntQueue {
    int capacity; // 큐의 크기
    int queue[]; // 큐의 메모리를 선언

    int front; // 제일 앞 위치
    int rear; // 마지막 위치
    int dataCnt;// queue의 데이터 개수

    public IntQueue() {
    }

    public IntQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    // 큐에 데이터 추가
    public int enqueue(int data) throws OverflowIntQueueException {
        // 데이터가 가득 찼는지 확인
        // capacity:용량, dataCnt:현재데이터수
        overFlow();
        // 데이터를 큐에 담는다(rear:위치에)
        queue[rear++] = data;
        dataCnt++; // 데이터의 수 증가
        // rear위치를 링형으로 처리하기
        if (rear == capacity) {
            rear = 0;
        }
        return data;
    }

    // 큐에서 데이터를 얻어오기 메서드
    public int dequeue() throws EmptyIntQueueException {
        empty();
        // 큐에 남은 데이터가 있을 때 실행됨
        dataCnt--; // 남은 객체의 수를 1감소

        int deData = queue[front++];

        // front의 값이
        if (front == capacity)
            front = 0;

        return deData;
    }

    // 큐의 제일 앞(front)값 출력
    public int peek() throws EmptyIntQueueException {
        empty();
        return queue[front];
    }

    // info: 큐의 크기, 데이터의 수, front 인덱스, rear 인덱스,
    // 처음 값, 마지막 값을 구하라.

    // 큐의 크기
    public int getCapacity() {
        return capacity;
    }

    // 큐의 데이터 수
    public int getDataCnt() {
        return dataCnt;
    }

    // front index
    public int getFront() {
        return front;
    }

    // rear index
    public int getRear() {
        return rear;
    }

    // 마지막 값
    public int getRearData() {
        return queue[rear - 1];
    }

    // 오버플로우 발생
    public void overFlow() throws OverflowIntQueueException {
        if (capacity <= dataCnt) {
            throw new OverflowIntQueueException();
        }
    }

    // 큐가 비어 있을경우 예외
    public void empty() throws EmptyIntQueueException {
        if (dataCnt <= 0) {
            throw new EmptyIntQueueException();
        }
    }

    // 큐가 비어있을때 Empty예외 클래스
    class EmptyIntQueueException extends RuntimeException {
        EmptyIntQueueException() {
        }
    }

    // 오버플로우 발생시 처리할 예외
    class OverflowIntQueueException extends RuntimeException {
        OverflowIntQueueException() {
        }
    }
}
