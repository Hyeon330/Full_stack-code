package al03_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import al03_stack_queue.IntQueue.EmptyIntQueueException;
import al03_stack_queue.IntQueue.OverflowIntQueueException;

public class IntQueueMain {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 메뉴를 입력받는 메소드
    static String getMenu() throws IOException {
        System.out.println("[Menu]1.enQueue, 2.dequeue, 3.peek, 4.info 0.end");
        System.out.print("==>");
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        IntQueue queue = new IntQueue(5);

        while (true) {
            String menu = getMenu();
            System.out.println();
            if (menu.equals("0")) {
                break;
            } else {
                switch (menu) {
                    case "1": // 큐에 데이터 추가s
                        System.out.print("enQueue : ");
                        int data = Integer.parseInt(br.readLine());
                        try {
                            queue.enqueue(data);
                        } catch (OverflowIntQueueException e) {
                            System.out.println("Memory is Full!!");
                        }
                        break;
                    case "2": // 큐의 데이터 가져오기(제일 앞에)
                        try {
                            int result = queue.dequeue();
                            System.out.println("deQueue : " + result);
                        } catch (EmptyIntQueueException e) {
                            beer();
                        }
                        break;
                    case "3": // 제일 앞의 값을 구하여 출력
                        try {
                            int result = queue.peek();
                            System.out.println("Front : " + result);
                        } catch (EmptyIntQueueException e) {
                            beer();
                        }
                        break;
                    case "4": // info: 큐의 크기, 데이터의 수, front 인덱스, rear 인덱스, 처음 값, 마지막 값을 구하라.
                        System.out.printf("Queue Size\t: %d\n", queue.getCapacity());
                        System.out.printf("Data Count\t: %d\n", queue.getDataCnt());
                        System.out.printf("front index\t: %d\n", queue.getFront());
                        System.out.printf("front value\t: %d\n", queue.peek());
                        System.out.printf("rear index\t: %d\n", queue.getRear());
                        System.out.printf("rear value\t: %d\n", queue.getRearData());
                        break;
                    default:
                        System.out.println("Wrong Number!!");
                        break;
                }
            }
            System.out.println();
        }

        System.out.println("End.");
    }

    static void beer() {
        System.out.println("Memory is beer~");
    }
}