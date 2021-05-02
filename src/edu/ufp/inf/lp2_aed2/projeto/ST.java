package edu.ufp.inf.lp2_aed2.projeto;

public class ST<Key extends Comparable<Key>, Value> {

    private Node root;             // root of BinaryTree

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Key getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Value getVal() {
            return val;
        }

       // @Override
       /* public String toString() {
            return "Node{" + "key=" + key + ", val=" + val + '}';
        }*/
    }

    // does there exist a key-value pair with given key?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key, or null if no such key exists
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp != 0) {
            Value v = get(x.left, key);
            if (v == null) {
                return get(x.right, key);
            } else {
                return v;
            }
        } else {
            return x.val;
        }
    }
}
