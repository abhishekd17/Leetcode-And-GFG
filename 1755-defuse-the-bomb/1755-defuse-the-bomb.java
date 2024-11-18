class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        if(k == 0) return ans;
        int start = 1;
        int end = k;
        int sum = 0;
        if(k < 0){
            k = -k;
            start = n -k;
            end = n -1;
        }
        for(int i = start ; i <= end ;i++) sum += code[i];
        for(int i = 0 ; i < n ; i++){
            ans[i] = sum;
            sum -= code[(start++) % n];
            sum += code[(++end) % n];
        }
        return ans;
    }
}

/*class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if(k == 0){
            Arrays.fill(code , 0);
            return code;
        }
        int ans[] = new int[n];
        if(k > 0){
            for(int i = 0 ; i < n ; i++){
                int sum = 0;
                for(int j = i + 1 ; j <= i + k ; j++){
                    sum += code[j % n];
                }
                ans[i] = sum;
            }
        }
        if(k < 0){
            for(int i = 0; i < n ; i++){
                int sum = 0;
                for(int j = n + k + i ; j < n + i ; j++){
                    sum += code[j % n];
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
} */