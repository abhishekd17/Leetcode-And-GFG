class Solution {
    class TrieNode{
        TrieNode links[] = new TrieNode[2];
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        for(int num : nums){
            TrieNode node = root;
            for(int i = 31 ; i >= 0 ; i--){
                int bit = (num >> i) & 1;
                if(node.links[bit] == null){
                    node.links[bit] = new TrieNode();
                }
                node = node.links[bit];
            }
        }

        int ans = 0;
        for(int num : nums){
            int curr = 0;
            TrieNode node = root;
            for(int i = 31 ; i >= 0 ; i--){
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - (bit);
                if(node.links[oppositeBit] != null){
                    curr |= (1 << i);
                    node = node.links[oppositeBit];
                }else{
                    node = node.links[bit];
                }
            }
            ans = Math.max(ans ,curr);
        }
        return ans;
    }
}











/*class Solution {
    class TrieNode{
        TrieNode links[] = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums){
        TrieNode root = new TrieNode();

        for(int num : nums){
            TrieNode node = root;
            for(int i = 31 ;i >= 0 ; i--){
                int bit = (num >> i) & 1;
                if(node.links[bit] == null){
                    node.links[bit] = new TrieNode();
                }
                node = node.links[bit];
            }
        }
        int ans = 0;
        for(int num : nums){
            TrieNode node= root;
            int currXor = 0;
            for(int i = 31 ; i >= 0 ; i--){
                int bit = (num >> i ) & 1;
                int oppositeBit = 1 - bit;
                if(node.links[oppositeBit] != null){
                    currXor |= (1 << i);
                    node = node.links[oppositeBit];
                }else{
                    node = node.links[bit];
                }
            }
            ans = Math.max(ans , currXor);
        }
        return ans;
    }
}




class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int ans =0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                ans = Math.max(ans , nums[i] ^ nums[j]);
                System.out.println(ans + " " + nums[i] + " " + nums[j]);
            }
        }
        return ans;
    }
} */ 