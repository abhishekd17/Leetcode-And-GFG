class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n =  matrix.length;
        int m = matrix[0].length;
        Map<String , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String s = "";
            for(int j = 0; j < m ; j++){
                if(matrix[i][0] == 0){
                    s += matrix[i][j];
                }else{
                    s += 1 - matrix[i][j];
                }
            }
            map.put(s , map.getOrDefault(s , 0) + 1);
        }
        // int ans = 0;
        // for(String s: map.keySet()){
        //     ans = Math.max(ans , map.get(s));
        // }
        return Collections.max(map.values());
    }
}