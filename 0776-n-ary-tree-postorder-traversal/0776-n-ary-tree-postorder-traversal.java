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
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        if(root == null) return list;
        while(!st.isEmpty()){
            Node node = st.pop();
            list.add(node.val);

            for(int i = 0 ; i < node.children.size() ; i++){
                st.push(node.children.get(i));
            }
        }
        Collections.reverse(list);
        return list;
    }
}

/*class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(list , root);
        return list;
    }
    private void helper(List<Integer> list , Node root){
        if(root == null) return ;

        for(int i = 0 ; i < root.children.size() ; i++){
            helper(list , root.children.get(i));
        }
        list.add(root.val);
    }
} */