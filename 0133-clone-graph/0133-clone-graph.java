/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer , List<Integer>> map = ser(node);
        Node newNode = deser(map , node);
        return newNode;
    }

    private Map<Integer , List<Integer>> ser(Node node){
        Map<Integer , List<Integer>> map = new HashMap<>();
        if(node == null) return map;
        Queue<Node> q = new LinkedList<>();
        Set<Node> vis = new HashSet<>();
        q.offer(node);
        vis.add(node);
        while(!q.isEmpty()){
            Node x = q.poll();
            map.putIfAbsent(x.val , new ArrayList<>());
            for(Node nbr : x.neighbors){
                map.get(x.val).add(nbr.val);
                if(!vis.contains(nbr)){
                    vis.add(nbr);
                    q.offer(nbr);
                }
            }
        }
        return map;
    }

    private Node deser(Map<Integer , List<Integer>> map ,  Node x){
        if(map.isEmpty()) return null;
        Map<Integer , Node> mpp = new HashMap<>();
        for(int val : map.keySet()){
            mpp.put(val , new Node(val));
        }

        for(int val : map.keySet()){
            Node node = mpp.get(val);
            for(int nbr : map.get(val)){
                node.neighbors.add(mpp.get(nbr));
            }
        }
        return mpp.get(x.val);
    }
}