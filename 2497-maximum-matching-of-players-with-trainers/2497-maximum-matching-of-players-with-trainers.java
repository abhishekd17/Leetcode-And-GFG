class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0 , j = 0 , n = players.length , m = trainers.length;
        int cnt = 0;
        while(i < n && j < m){
            if(trainers[j] >= players[i]){
                i++;
                j++;
                cnt++;
            }else{
                j++;
            }
        }
        return cnt;
    }
}