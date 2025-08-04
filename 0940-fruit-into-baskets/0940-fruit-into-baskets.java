// jai maa saraswati
class Solution {
    public int totalFruit(int[] nums) {
        int n=nums.length;
        int r=0 ,l=0 ,maxi=0;
        HashMap<Integer ,Integer> map=new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r] , 0 )  + 1);
            if(map.size()>2){
                map.put(nums[l] , map.get(nums[l]) - 1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            if(map.size()<=2){
                maxi=Math.max(maxi,r - l +1);
            }
            r++;
        }
        return maxi;
    }
}

/*class Solution {
    public int totalFruit(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int l=0 ,r=0 ,maxi=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.size()>2){
                while(map.size()>2){
                    map.put(nums[l],map.get(nums[l]) - 1);
                    if(map.get(nums[l])==0){
                        map.remove(nums[l]);
                    }
                    l++;
                }
            }
                maxi=Math.max(maxi , r-l+1);
                r++;
        }
        return maxi;
    }
}*/

/*class Solution {
    public int totalFruit(int[] nums) {
        int n=nums.length;
        int maxi=0;
       for(int i=0;i<n;i++){
        HashSet<Integer> set=new HashSet<>();
        for(int j=i;j<n;j++){
            set.add(nums[j]);
            if(set.size()<=2){
                int len=j-i+1;
                maxi=Math.max(len , maxi);
            }else{
                break;
            }
        }
       }
       return maxi;
    }
}
*/



// O(N^2)
/*class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            HashMap<Integer ,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(fruits[j] , map.getOrDefault(fruits[j],0)+1);
                if(map.size()>2) break;
                int total=0;
               for(int num : map.values()){
                total+=num;
               }
               maxi=Math.max(total,maxi);
            }
        }
        return maxi;
    }
}*/
