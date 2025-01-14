class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int ans[] = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ;i++){
            set.add(a[i]);
            int cnt = 0;
            for(int j = 0 ; j <=i ; j++){
                if(set.contains(b[j])) cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}