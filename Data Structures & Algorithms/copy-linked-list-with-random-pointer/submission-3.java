/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>();
        copy.put(null, null);

        Node cur = head;
        while (cur != null) {
            Node c = new Node(cur.val);
            copy.put(cur, c);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node c = copy.get(cur);
            c.next = copy.get(cur.next);
            c.random = copy.get(cur.random);
            cur = cur.next;
        }

        return copy.get(head);
    }
}
