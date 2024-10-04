class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int i = 1 ;
        int j = n - 2;
        long sum = skill[0] + skill[n - 1];
        long ans = skill[0] * skill[n - 1];
        while(i <= j){
            if(sum == skill[i] + skill[j]){
                ans += (skill[i] * skill[j]);
            }else{
                return -1;
            }
            i++;
            j--;
        }
        return ans;
    }
}