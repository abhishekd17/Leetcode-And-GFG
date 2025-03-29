class Solution {
    public boolean checkValidCuts(int n, int[][] nums) {
        int r = nums.length;
        int xAxis[][] = new int[r][2];
        int yAxis[][] = new int[r][2];

        for(int i = 0 ; i < r ; i++){
            xAxis[i][0] = nums[i][0];
            xAxis[i][1] = nums[i][2];
            yAxis[i][0] = nums[i][1];
            yAxis[i][1] = nums[i][3];
        }

        Arrays.sort(xAxis, (a , b) -> Integer.compare(a[0] , b[0]));
        Arrays.sort(yAxis, (a , b) -> Integer.compare(a[0] , b[0]));

        int x = 0 , y = 0;
        int endX = xAxis[0][1] , endY = yAxis[0][1];

        for(int i = 1 ; i < r ; i++){
            if(xAxis[i][0] >= endX){
                x++;
            }
            endX = Math.max(endX , xAxis[i][1]);
            if(yAxis[i][0] >= endY){
                y++;
            }
            endY = Math.max(endY , yAxis[i][1]);
            System.out.println(x + " " + y);
        }

        return (x >= 2 || y >= 2);
    }
}