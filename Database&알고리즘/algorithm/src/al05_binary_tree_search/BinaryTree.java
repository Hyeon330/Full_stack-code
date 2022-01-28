package al05_binary_tree_search;

public class BinaryTree<K, V> {
	// 객체 1개를 저장할 노드 클래스
	static class Node<K, V> {
		private K key; // key
		private V data; // data
		private Node<K, V> left; // 왼쪽
		private Node<K, V> right; // 오른쪽노드

		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		// 키
		public K getKey() {
			return key;
		}

		// 데이터
		public V getData() {
			return data;
		}
	}// Node

	private Node<K, V> root; // 루트노드

	BinaryTree() {
		root = null; // 루트노드 초기화
	}

	// public Node<K, V> comp(Node<K, V> node, K key1, K key2) {
	// // key1 - key2 = 0 : key1과 key2가 같다.
	// // = + : 왼쪽
	// // = - : 오른쪽
	// int result = ((Comparable<K>) key1).compareTo(key2);
	// if (result == 0) {
	// return node;
	// } else if (result < 0) {
	// return node.left;
	// } else {
	// return node.right;
	// }

	// // return ((Comparable<K>) key1).compareTo(key2);
	// }

	// 노드추가(위치를 찾아서 노드추가)
	// public void addNode(Node<K, V> node, K key, V data) {
	// // 비교
	// Node<K, V> result = comp(node, key, node.getKey());

	// if (result == node) { // 이미 있는 키값일 때
	// System.out.println("리턴");
	// return;
	// } else {
	// if (result == null) { // node의 왼쪽이 비어있으면, 새로운 노드를 왼쪽에 생성한다.
	// System.out.println("ggg");
	// result = new Node<K, V>(key, data, null, null);
	// } else {
	// System.out.println("zzz");
	// addNode(result, key, data);
	// }
	// }
	// }

	public int comp(K key1, K key2) {
		// key1 - key2 = 0 : key1과 key2가 같다.
		// = + : 왼쪽
		// = - : 오른쪽

		return ((Comparable<K>) key1).compareTo(key2);
	}

	public void addNode(Node<K, V> node, K key, V data) {
		// 비교

		int result = comp(key, node.getKey());

		if (result == 0) { // 이미 있는 키값일 때
			return;
		} else if (result < 0) { // 음수 : 왼쪽노드 검색
			if (node.left == null) { // node의 왼쪽이 비어있으면, 새로운 노드를 왼쪽에 생성한다.
				node.left = new Node<K, V>(key, data, null, null);
			} else {
				addNode(node.left, key, data);
			}
		} else { // 양수 : 오른쪽노드 검색
			if (node.right == null) {
				node.right = new Node<K, V>(key, data, null, null);
			} else {
				addNode(node.right, key, data);
			}
		}
	}

	// 노드추가
	public void add(K key, V data) {
		if (root == null) {
			// 루트가 비어있으면 data를 노드를 만들어 root에 대입하면된다.
			root = new Node<K, V>(key, data, null, null);
		} else {
			// 루트가 비어있지 않으면 key를 이용하여 위치를 찾아서 추가해야한다.
			addNode(root, key, data);
		}
	}

	// 노드 삭제
	public boolean remove(K key) { // key는 입력 받은 키
		Node<K, V> point = root;// root
		Node<K, V> parent = null;// 부모
		boolean isLeftChild = true;// 왼쪽, 오른쪽 노드인지의 정보가 필요함

		while (true) {
			if (point == null) {// point는 root이기 때문에 root가 없으면 값들이 존재하지 않는다.
				return false; // 함수 종료
			}
			// 삭제할 노드 찾기
			int cond = comp(key, point.getKey());
			// 입력받은 key와 루트의 키를 비교하여
			// 0이나오면 두수가 같은 것이고
			// 1이면 입력한 값이 더 큰것이고
			// -1이면 입력한 값이 더 작은것이다.

			if (cond == 0) { // 삭제할 노드 찾았기 때문에 루프문에서 빠져나간다.
				break;
			} else {
				parent = point; // 현재 노드를 parent에 넣어주고,
								// 다음노드로 넘어가는 이유는
								// 찾은 노드를 삭제한 후 빈 공간에
								// 부모의 노드를 이어줘야 하기 때문에
				if (cond < 0) {
					point = point.left; // cond가 -1이 나왔기 때문에
										// 다음으로 비교해 볼 노드는
										// 바로 왼쪽의 노드이다.
					isLeftChild = true;
				} else {
					point = point.right; // cond가 1이 나왔기 때문에
											// 다음으로 비교해 볼 노드는
											// 바로 왼쪽의 노드이다.
					isLeftChild = false;
				}
			}
		}
		// 위의 루프문이 끝나고 입력한 값과 동일한 값을 찾아서 부모노드 즉, 삭제할노드가 정해짐
		// left노드가 없을 때 삭제할 노드의 right를 부모노드의 left에 대입한다.
		if (point.left == null) {
			// 삭제할 노드가 root이면 오른쪽노드를 root
			if (point == root) {
				root = point.right;
			} else if (isLeftChild) {
				parent.left = point.right;
			} else {
				parent.right = point.right;
			}
		} else if (point.right == null) { // 삭제할 노드의 right가 없을 때
			if (point == root) {
				root = point.left;
			} else if (isLeftChild) {
				parent.left = point.left;
			} else {
				parent.right = point.left;
			}
		} else { // left노드와 right노드가 모두 있을 때
					// point의 자식들중 제일 큰 노드 구하기
			parent = point;
			Node<K, V> maxNode = point.left;
			isLeftChild = true;
			while (maxNode.right != null) {
				parent = maxNode;
				maxNode = maxNode.right;
				isLeftChild = false;
			}

			point.key = maxNode.key;
			point.data = maxNode.data;

			if (isLeftChild) {
				parent.left = maxNode.left;
			} else {
				parent.right = maxNode.left;
			}
		}
		// 노드 삭제
		System.out.println(key + "번 회원이 삭제되었습니다.");

		return true;

	}

	// 노드 검색
	public V search(K key) {
		Node<K, V> point = root;

		while (true) {
			if (point == null) {
				return null;
			}
			// 입력받은 키와 point가 있는 키를 크기를 구하여
			// 음수가 나오면 key가 크다, 0이 나오면, 양수가 나오면
			int result = comp(point.getKey(), key);
			if (result == 0) { // key와 같은 정보를 가진 Data검색됨
				return point.getData();
			} else if (result > 0) {
				point = point.left;
			} else {
				point = point.right;
			}
		}
	}

	public void subNodePrint(Node<K, V> node) {
		if (node != null) {
			subNodePrint(node.left);
			System.out.println(node.getKey() + " " + node.data);
			subNodePrint(node.right);
		}
	}

	// 노드출력
	public void print() {
		if (root == null) {// 노드가 비어 있을 때
			System.out.println("등록된 회원이 없습니다.");
		} else {
			subNodePrint(root);
		}
	}
}
