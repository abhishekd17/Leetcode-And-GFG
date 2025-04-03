class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        List<int[]> list = new ArrayList<>(); 
        int ones = 0;
        for(int i = 0 ; i < n ;){
            if(s.charAt(i) == '0'){
                int start = i;
                while( i < n && s.charAt(i) == '0'){
                    i++;
                }
                list.add(new int[]{start  , i - start});
            }else{
                ones++;
                i++;
            }
        }
        if(list.size() < 2) return ones;
        int maxi = 0;
        for(int i = 0 ; i < list.size() - 1; i++){
            boolean l = list.get(i)[0] + 1 < n ? s.charAt(list.get(i)[0] + list.get(i)[1]) == '1' : true;
            boolean r = list.get(i + 1)[0] - 1 >= 0 ? s.charAt(list.get(i + 1)[0] - 1) == '1' : true;
            if(l & r) maxi = Math.max(maxi , list.get(i)[1] + list.get(i + 1)[1]);
        }
        return maxi + ones;
    }
}