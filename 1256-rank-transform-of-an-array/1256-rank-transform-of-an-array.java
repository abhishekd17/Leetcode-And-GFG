class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int ans[]=arr.clone();
        Map<Integer, Integer> map=new HashMap<>();
        Arrays.sort(ans);
        int rank=1;
        for(int num:ans){
            if(!map.containsKey(num)){
                map.put(num,rank++);
            }
        }

        int res[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}