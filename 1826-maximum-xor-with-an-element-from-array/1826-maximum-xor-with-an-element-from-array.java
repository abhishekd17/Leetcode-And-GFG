import java.util.*;
class Node{
    Node[] links;

    Node(){
        links = new Node[2];
    }

    boolean containsKey(int ind){
        return links[ind] != null;
    }

    Node get(int ind){
        return links[ind];
    }

    void put(int ind , Node node){
        links[ind] = node;
    }
}

class Trie{
    Node root ;
    Trie(){
        root = new Node();
    }

    void insert(int num){
        Node node = root;
        for(int i = 31 ; i >= 0 ; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit , new Node());
            }
            node = node.get(bit);
        }
    }

    int findMax(int num){
        Node node = root;
        int maxNum = 0;
        for(int i = 31 ; i >= 0 ; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)){
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            }else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;
        int ans[] = new int[q];
        ArrayList<Query> oQ= new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < q ; i++){
            oQ.add(new Query(queries[i][0] , queries[i][1] , i));
        }

        Collections.sort(oQ,Comparator.comparingInt(p -> p.threshold));

        Trie trie = new Trie();
        int i = 0; 
        for(Query query : oQ ){
            while(i < n && nums[i] <= query.threshold){
                trie.insert(nums[i]);
                i++;
            }

            if(i != 0){
                ans[query.index] = trie.findMax(query.value); 
            }else{
                ans[query.index] = -1;
            }
        }
        return ans;
    }
}

class Query{
    int value ;
    int threshold;
    int index;

    Query(int value , int threshold , int index){
        this.value = value;
        this.threshold = threshold;
        this.index = index;
    }
}