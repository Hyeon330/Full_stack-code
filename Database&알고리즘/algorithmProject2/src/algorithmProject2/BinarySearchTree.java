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

        public K getNum() {
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

    public void addNode(Node<K, V> node, K num, V data) {
        int result = comp(num, node.getNum());

        if (result == 0) {
            return;
        } else if (result < 0) {
            if (node.left == null) {
                node.left = new Node<K, V>(num, data, null, null);
            } else {
                addNode(node.left, num, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<K, V>(num, data, null, null);
            } else {
                addNode(node.right, num, data);
            }
        }
    }

    public void add(K num, V data) {
        if (root == null) {
            root = new Node<K, V>(num, data, null, null);
        } else {
            addNode(root, num, data);
        }
    }

    public boolean remove(K num) {
        Node<K, V> point = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (point == null) {
                return false;
            }
            int cond = comp(num, point.getNum());

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

            point.num = maxNode.num;
            point.data = maxNode.data;

            if (isLeftChild) {
                parent.left = maxNode.left;
            } else {
                parent.right = maxNode.left;
            }
        }
        return true;

    }

    public V search(K num) {
        Node<K, V> point = root;

        while (true) {
            if (point == null) {
                return null;
            }
            int result = comp(point.getNum(), num);
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
            System.out.println(node.getNum() + " " + node.data);
            subNodePrint(node.right);
        }
    }

    public void print() {
        if (root == null) {
            System.out.println();
            System.out.println("등록된 제품이 없습니다.");
        } else {
            subNodePrint(root);
        }
    }
}
