class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int a : apple) sum += a;
        Arrays.sort(capacity);
        int x = 0;
        int i = capacity.length - 1;
        int ans = 0;
        
        while(sum > x){
            x += capacity[i];
            i--;
            ans++;
        }        
        return ans;
    }
}
