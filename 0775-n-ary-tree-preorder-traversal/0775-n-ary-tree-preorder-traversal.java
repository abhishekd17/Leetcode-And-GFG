/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root ,List<Integer> list ){
        if(root == null) return;

        list.add(root.val);

        for(int i =0 ;  i < root.children.size() ; i++ ){
            helper(root.children.get(i) , list);
        }
    }
}

/*class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node node = st.pop();
            list.add(node.val);

            for(int i = node.children.size() - 1 ; i >= 0 ; i--){
                st.push(node.children.get(i));
            } 
        }
        return list;
    }
} */