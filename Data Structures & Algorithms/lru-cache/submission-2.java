public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    int cap;
    Map<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node) { // prev node next
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) { // prev node right
        Node prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        node.prev = prev;
        this.right.prev = node;
        
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node mru = this.cache.get(key);
            remove(mru);
            insert(mru);
            return mru.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }
        Node newNode = new Node(key, value);
        this.cache.put(key, newNode);
        insert(newNode);

        if (this.cache.size() > this.cap) {
            Node lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }
}
