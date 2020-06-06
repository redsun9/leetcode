package basic;

import java.util.*;

@SuppressWarnings("unchecked")
public class AvlTree<Key, Value> {
    private final Comparator<? super Key> comparator;
    private Node root;

    public AvlTree() {
        comparator = null;
    }

    public AvlTree(Comparator<? super Key> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return x.height;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (comparator != null) {
            Node x = getEntryUsingComparator(root, key);
            if (x == null) return null;
            return x.val;
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) key;
            Node x = getEntryUsingComparable(root, k);
            if (x == null) return null;
            return x.val;
        }
    }

    private Node getEntryUsingComparator(Node x, Key key) {
        if (x == null) return null;
        int cmp = comparator.compare(key, x.key);
        if (cmp < 0) return getEntryUsingComparator(x.left, key);
        else if (cmp > 0) return getEntryUsingComparator(x.right, key);
        else return x;
    }

    private Node getEntryUsingComparable(Node x, Comparable<? super Key> key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return getEntryUsingComparable(x.left, key);
        else if (cmp > 0) return getEntryUsingComparable(x.right, key);
        else return x;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        if (comparator != null) {
            root = putEntryUsingComparator(root, key, val);
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) key;
            root = putEntryUsingComparable(root, k, val);
        }
        assert check();
    }

    private Node putEntryUsingComparator(Node x, Key key, Value val) {
        if (x == null) return new Node((Key) key, val, 0, 1);
        int cmp = comparator.compare(key, x.key);
        if (cmp < 0) {
            x.left = putEntryUsingComparator(x.left, key, val);
        } else if (cmp > 0) {
            x.right = putEntryUsingComparator(x.right, key, val);
        } else {
            x.val = val;
            return x;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private Node putEntryUsingComparable(Node x, Comparable<? super Key> key, Value val) {
        if (x == null) return new Node((Key) key, val, 0, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = putEntryUsingComparable(x.left, key, val);
        } else if (cmp > 0) {
            x.right = putEntryUsingComparable(x.right, key, val);
        } else {
            x.val = val;
            return x;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private Node balance(Node x) {
        if (balanceFactor(x) < -1) {
            if (balanceFactor(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if (balanceFactor(x) > 1) {
            if (balanceFactor(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    private int balanceFactor(Node x) {
        return height(x.left) - height(x.right);
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;
        if (comparator != null) {
            root = deleteUsingComparator(root, key);
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) key;
            root = deleteUsingComparable(root, k);
        }

        assert check();
    }

    private Node deleteUsingComparator(Node x, Key key) {
        int cmp = comparator.compare(key, x.key);
        if (cmp < 0) {
            x.left = deleteUsingComparator(x.left, key);
        } else if (cmp > 0) {
            x.right = deleteUsingComparator(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                Node y = x;
                x = min(y.right);
                x.right = deleteMin(y.right);
                x.left = y.left;
            }
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private Node deleteUsingComparable(Node x, Comparable<? super Key> key) {
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = deleteUsingComparable(x.left, key);
        } else if (cmp > 0) {
            x.right = deleteUsingComparable(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                Node y = x;
                x = min(y.right);
                x.right = deleteMin(y.right);
                x.left = y.left;
            }
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("called deleteMin() with empty symbol table");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("called deleteMax() with empty symbol table");
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x;
        if (comparator != null) {
            x = floorUsingComparator(root, key);
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) key;
            x = floorUsingComparable(root, k);
        }
        if (x == null) return null;
        else return x.key;
    }

    private Node floorUsingComparator(Node x, Key key) {
        if (x == null) return null;
        int cmp = comparator.compare(key, x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floorUsingComparator(x.left, key);
        Node y = floorUsingComparator(x.right, key);
        if (y != null) return y;
        else return x;
    }

    private Node floorUsingComparable(Node x, Comparable<? super Key> key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floorUsingComparable(x.left, key);
        Node y = floorUsingComparable(x.right, key);
        if (y != null) return y;
        else return x;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x;
        if (comparator != null) {
            x = ceilingUsingComparator(root, key);
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) key;
            x = ceilingUsingComparable(root, k);
        }
        if (x == null) return null;
        else return x.key;
    }

    private Node ceilingUsingComparator(Node x, Key key) {
        if (x == null) return null;
        int cmp = comparator.compare(key, x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceilingUsingComparator(x.right, key);
        Node y = ceilingUsingComparator(x.left, key);
        if (y != null) return y;
        else return x;
    }

    private Node ceilingUsingComparable(Node x, Comparable<? super Key> key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceilingUsingComparable(x.right, key);
        Node y = ceilingUsingComparable(x.left, key);
        if (y != null) return y;
        else return x;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException("k is not in range 0-" + (size() - 1));
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        if (comparator != null) {
            return rankUsingComparator(root, key);
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) key;
            return rankUsingComparable(root, k);
        }
    }

    private int rankUsingComparator(Node x, Key key) {
        if (x == null) return 0;
        int cmp = comparator.compare(key, x.key);
        if (cmp < 0) return rankUsingComparator(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rankUsingComparator(x.right, key);
        else return size(x.left);
    }

    private int rankUsingComparable(Node x, Comparable<? super Key> key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rankUsingComparable(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rankUsingComparable(x.right, key);
        else return size(x.left);
    }

    public Iterable<Key> keys() {
        return keysInOrder();
    }

    public Iterable<Key> keysInOrder() {
        Queue<Key> queue = new ArrayDeque<>(size());
        keysInOrder(root, queue);
        return queue;
    }

    private void keysInOrder(Node x, Queue<Key> queue) {
        if (x == null) return;
        keysInOrder(x.left, queue);
        queue.offer(x.key);
        keysInOrder(x.right, queue);
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> queue = new LinkedList<>();
        if (comparator != null) {
            keysUsingComparable(root, queue, lo, hi);
        } else {
            Comparable<? super Key> l = (Comparable<? super Key>) lo;
            Comparable<? super Key> h = (Comparable<? super Key>) hi;
            keysUsingComparable(root, queue, l, h);
        }
        return queue;
    }

    private void keysUsingComparable(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = comparator.compare(lo, x.key);
        int cmphi = comparator.compare(hi, x.key);
        if (cmplo < 0) keysUsingComparable(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.offer(x.key);
        if (cmphi > 0) keysUsingComparable(x.right, queue, lo, hi);
    }

    private void keysUsingComparable(Node x, Queue<Key> queue, Comparable<? super Key> lo, Comparable<? super Key> hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keysUsingComparable(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.offer(x.key);
        if (cmphi > 0) keysUsingComparable(x.right, queue, lo, hi);
    }

    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");
        if (comparator != null) {
            if (comparator.compare(lo, hi) >= 0) return 0;
        } else {
            Comparable<? super Key> l = (Comparable<? super Key>) lo;
            if (l.compareTo(hi) > 0) return 0;
        }
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    private boolean check() {
        if (!isBST()) System.out.println("Symmetric order not consistent");
        if (!isAVL()) System.out.println("AVL property not consistent");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
        if (!isRankConsistent()) System.out.println("Ranks not consistent");
        return isBST() && isAVL() && isSizeConsistent() && isRankConsistent();
    }

    private boolean isAVL() {
        return isAVL(root);
    }

    private boolean isAVL(Node x) {
        if (x == null) return true;
        int bf = balanceFactor(x);
        if (bf > 1 || bf < -1) return false;
        return isAVL(x.left) && isAVL(x.right);
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (comparator != null) {
            if (min != null && comparator.compare(x.key, min) <= 0) return false;
            if (max != null && comparator.compare(x.key, max) >= 0) return false;
            return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
        } else {
            Comparable<? super Key> k = (Comparable<? super Key>) x.key;
            if (min != null && k.compareTo(min) <= 0) return false;
            if (max != null && k.compareTo(max) >= 0) return false;
            return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
        }
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        if (comparator != null) {
            for (Key key : keys())
                if (comparator.compare(key, select(rank(key))) != 0) return false;
        } else {
            for (Key key : keys())
                if (((Comparable<? super Key>) key).compareTo(select(rank(key))) != 0) return false;
        }
        return true;
    }

    private class Node {
        private final Key key;   // the key
        private Value val;       // the associated value
        private int height;      // height of the subtree
        private int size;        // number of nodes in subtree
        private Node left;       // left subtree
        private Node right;      // right subtree

        public Node(Key key, Value val, int height, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.height = height;
        }
    }
}
