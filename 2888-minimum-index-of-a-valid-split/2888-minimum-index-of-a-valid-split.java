class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int el = nums.get(0);
        int cnt = 1;

        for(int i = 1 ; i < n ;i++){
            if(cnt == 0){
                el = nums.get(i);
                cnt = 1;
            }else if(nums.get(i) == el){
                cnt++;
            }else{
                cnt--;
            }
        }
        int total = 0;
        for(int i = 0 ; i < n ;i++){
            if(nums.get(i) == el) total++;
        }
        int x = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums.get(i) == el){
                x++;
                total--;
            }
            if(x > (i + 1) / 2  && total > (n - i - 1) / 2) return i;
        }
        return -1;
    }
}


/*class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer , Integer> map1 = new HashMap<>();
        Map<Integer , Integer> map2 = new HashMap<>();

        for(int x : nums){
            map2.put(x , map2.getOrDefault(x , 0) + 1);
        }

        for(int i = 0 ; i < n ; i++){
            map1.put(nums.get(i) , map1.getOrDefault(nums.get(i) , 0) + 1);
            map2.put(nums.get(i) , map2.getOrDefault(nums.get(i) , 0) - 1);
            if(map1.get(nums.get(i)) > (i + 1) / 2 && map2.get(nums.get(i)) > (n - i -1) / 2) return i;
        }
        return -1;
    }
} */