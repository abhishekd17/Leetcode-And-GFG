class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l=0;
        int r=0;
        int cnt=0;
        while(l < players.length && r < trainers.length){
            if(players[l] <= trainers[r]){
                cnt++;
                l++;
                r++;
            }else{
                r++;
            }
        }
        return cnt;
    }
}