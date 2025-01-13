class Solution {
    public int maxArea(int[] a) {
        int n = a.length;
        int l = 0 , r = n - 1;
        int maxArea = 0;
        while(l < r){
            int height = Math.min(a[l] , a[r]);
            int width = (r - l);
            int area = height * width;
            maxArea = Math.max(area , maxArea);
            if(a[l] > a[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}