class Solution {
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        for(int i = 1 ; i <= n / 2 ; i++){
            int a = i;
            int b = n - i;
            if(isNoZero(a) && isNoZero(b)){
                System.out.println(i + " " + (n - i));
                ans[0] = a;
                ans[1] = b;
            }
        }
        return ans;
    }
    private boolean isNoZero(int x){
        while(x > 0){
            int digit = x % 10;
            if(digit == 0) return false;
            x /= 10;
        }
        return true;
    }
}
