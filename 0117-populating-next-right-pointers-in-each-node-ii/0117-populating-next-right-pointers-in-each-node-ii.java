class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node l = root.left, r = root.right, n = root.next;

        if (l != null) {
            if (r != null) {
                l.next = r; // Connect left child to right child.
            } else {
                // Connect left child to the next available node's child.
                l.next = findNext(n);
            }
        }

        if (r != null) {
            // Connect right child to the next available node's child.
            r.next = findNext(n);
        }

        // Recur for the right subtree first to ensure the `next` pointers in the next level are set up.
        connect(r);
        connect(l);

        return root;
    }

    private Node findNext(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next; // Move to the next node at the same level.
        }
        return null; // No next node found.
    }
}


// BFS
/*class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            Node rightNode = null;
            for(int i = q.size() ; i > 0  ; i--){
                Node curr = q.poll();
                curr.next = rightNode;
                rightNode = curr;
                if(curr.right != null) q.offer(curr.right);
                if(curr.left != null) q.offer(curr.left);
            }
        }
        return root;
    }
} */