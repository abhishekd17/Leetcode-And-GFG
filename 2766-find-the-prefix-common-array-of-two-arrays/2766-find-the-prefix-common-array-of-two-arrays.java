class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int freq[] = new int[n + 1];

        int ans[] = new int[n];
        int cnt = 0;
        for(int i = 0 ; i  < n ; i++){
            if(freq[a[i]] > 0) cnt++;
            freq[a[i]]++;

            if(freq[b[i]] > 0) cnt++;
            freq[b[i]]++;

            ans[i] = cnt;
        }
        return ans;
    }
}

// brute force 
/*class Solution {
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
} */