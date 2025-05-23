class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < (1 << n) ; i++){
            ans.add(start ^ i ^ (i >> 1));
        }
        return ans;
    }
}


/*class Solution {
    public List<Integer> circularPermutation(int p, int start) {
        int n = (int)Math.pow(2 , p);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(i ^ (i >> 1));
        }
        List<Integer> ans = new ArrayList<>();
        boolean flag = false;
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            if(list.get(i) == start){
                k = i;
                flag = true;
            }
            if(flag) ans.add(list.get(i));
            else continue;
        }
        for(int i = 0 ; i < k ; i++){
            ans.add(list.get(i));
        }
        return ans;
    }
} */