/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node l = root.left , r = root.right , n = root.next;

        if(l != null){
            l.next = r;
            if(n != null) r.next = n.left;
            connect(l);
            connect(r);
        }
        return root;
    }
}

/*class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            Node rightNode = null;
            for(int i = q.size() ; i > 0 ; i--){
                Node curr = q.poll();
                curr.next = rightNode;
                rightNode = curr;
                if(curr.right != null){
                    q.offer(curr.right);
                    q.offer(curr.left);
                }
            }
        }
        return root;
    }
} */