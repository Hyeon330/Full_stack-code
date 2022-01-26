package al04_linkedlist;

import al04_linkedlist.LinkedListTestMain.Data;

public class LinkedListTest<E extends Data> {
    // 노드 클래스
    class Node<E> {
        private E data;
        private Node<E> next; // 뒤쪽 노드

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedListTest() {
        // head, current를 초기화
        head = null;
        current = null;
    }

    // 머리 노드를 저장 할 변수
    private Node<E> head;
    private Node<E> current;

    // 머리에 노드 삽입
    public void addFirst(E data) {
        // 지금 현재 헤더
        Node<E> point = head;
        head = current = new Node<E>(data, point);
    }

    // 꼬리에 노드 삽입
    public void addLast(E data) {
        if (head == null) { // 저장된 리스트가 없다.
            addFirst(data);
        } else { // 저장된 리스트가 있다.
            Node<E> point = head;
            while (point.next != null) {
                current = point = point.next;
            }
            // point는 next가 null인 노드이다.
            point.next = new Node<E>(data, null);
        }
    }

    // 머리노드 삭제..
    public void removeFirst() {
        if (head != null) { // 노드가 존재하면
            current = head = head.next;
        }
    }

    // 노드삭제
    public void remove(Node<E> delNode) {
        if (head != null) { // 노드 있을 경우
            if (head == delNode) { // 삭제할 노드가 head노드인지 확인
                removeFirst();
            } else {
                Node<E> point = head;
                while (point.next != delNode) { // dellNode의 앞 노드 찾기
                    point = point.next;
                }
                // point는 delNode의 이전노드
                point.next = delNode.next;
                current = point;
            }
        }
    }

    // 선택노드 삭제
    public void removeCurrent() {
        remove(current);
    }

    // 출력
    public void dump() {
        Node<E> point = head;
        while (point != null) {
            System.out.println(point.data);
            point = point.next;
        }
    }
}
