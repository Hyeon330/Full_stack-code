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

	public int comp(K key1, K key2) {
		// key1 - key2 = 0 : key1과 key2가 같다.
		// = + : 오른쪽
		// = - : 왼쪽

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
	public boolean remove(K key) {
		Node<K, V> point = root;
		Node<K, V> parent = null;
		boolean isLeftChild = true; // 초기화(왼쪽에 있는지 없는지는 모름)

		while (true) {
			if (point == null) {
				return false;
			}
			int cond = comp(key, point.getKey());
			if (cond == 0) {
				break;
			} else {
				parent = point;
				if (cond < 0) {
					point = point.left;
					isLeftChild = true;
				} else {
					point = point.right;
					isLeftChild = false;
				}
			}
		}

		if (point.left == null) {
			if (point == root) {
				root = point.right;
			} else if (isLeftChild) {
				parent.left = point.right;
			} else {
				parent.right = point.right;
			}
		} else if (point.right == null) {
			if (point == root) {
				root = point.left;
			} else if (isLeftChild) {
				parent.left = point.left;
			} else {
				parent.right = point.left;
			}
		} else {
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
			int result = comp(point.getKey(), key);
			if (result == 0) {
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
