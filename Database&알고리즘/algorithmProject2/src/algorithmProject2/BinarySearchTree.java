package algorithmProject2;

public class BinarySearchTree<K, V> {

    static class Node<K, V> {
        private K num;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K num, V data, Node<K, V> left, Node<K, V> right) {
            this.num = num;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getNo() {
            return num;
        }

        public V getData() {
            return data;
        }
    }

    private Node<K, V> root;

    BinarySearchTree() {
        root = null;
    }

    public int comp(K num1, K num2) {
        return ((Comparable<K>) num1).compareTo(num2);
    }

    // 노드 추가
    public void add(K num, V data) {
        if (root == null) {
            root = new Node<K, V>(num, data, null, null);
        } else {

        }
    }
}
