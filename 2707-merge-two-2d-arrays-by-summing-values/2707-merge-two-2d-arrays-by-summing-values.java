class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i < n1 ; i++){
            set.add(nums1[i][0]);
        }
        for(int i = 0 ;i < n2 ; i++){
            set.add(nums2[i][0]);
        }
        int ans[][] = new int[set.size()][2];

        int i = 0 , j = 0 , k = 0;
        while(i < n1 && j < n2 ){
            if(nums1[i][0] == nums2[j][0]){
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                k++;
                i++;
                j++;
            }else if(nums1[i][0] > nums2[j][0]){
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
                k++;
            }else{
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
                k++;
            }
        }

        while(i < n1){
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            k++;
            i++;
        }

        while(j < n2){
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            j++;
            k++;
        }
        return ans;
    }
}