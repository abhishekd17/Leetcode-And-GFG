class Solution {
    public int[] minOperations(String s) {
        int n = s.length();

        int pref[] = new int[n + 1];
        int suff[] = new int[n + 1];

        for(int i = 0 ; i < n ; i++){
            pref[i + 1] = pref[i] + (s.charAt(i) == '1' ? 1 : 0);
            suff[n - i - 1] = suff[n - i] + (s.charAt(n - i - 1) == '1' ? 1 : 0);
        }

        for(int i = 1 ; i < n ; i++ ){
            pref[i] += pref[i - 1];
            suff[n - i - 1] += suff[n - i];
        }
        // for(int i = 0 ; i < n + 1 ; i++){
        //     System.out.println(pref[i] + " "+ suff[i]);
        // }

        int ans[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = pref[i] + suff[i + 1];
        }
        return ans;
    }
}

/*class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];

        for(int i =0 ; i < n ; i++){
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                if(boxes.charAt(j) == '1'){
                    cnt += Math.abs(i - j);
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
} */