class Solution {
    boolean[] a = new boolean[101];
    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        for(int i = 0 ; i < n ; i++) freq[nums[i]]++;
        helper(100);

        for(int i = 0 ; i <= 100 ; i++){
            if(freq[i] > 0 && !a[freq[i]]) return true;
        }
        return false;
    }
    private void  helper(int n){
        a[0] = true;
        a[1] = true;
        for(int i = 2 ; i * i <= n ;i++){
            if(!a[i]){
                for(int j = i * i ; j <= n ; j += i) a[j] = true;
            }
        }
    }
}