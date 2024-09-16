// jai maa saraswati
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(s.length()==0) return 0;
        int hash[]=new int[256];
        int l=0;
        int r=0;
        int maxi=0;
        Arrays.fill(hash,-1);
        while(r<n){
            char ch=s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l=hash[ch]+1;
                }
            }
            int len=r-l+1;
            maxi=Math.max(len,maxi);
            hash[ch]=r;
            r++;
        }
        return maxi;
    }
}


//brute force
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxi=0;
        for(int i=0;i<n;i++){
            HashMap<Character , Integer> map=new HashMap<>();
            boolean duplicate=false;
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)>1){
                    duplicate=true;
                    break;
                }
                maxi=Math.max(maxi,j-i+1);
            }
            if(duplicate){
                continue;
            }
        }
        return maxi;
    }
}*/
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxi=0;
        for(int i=0;i<n;i++){
            int hash[]=new int[256];
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]==1) break;
                int len=j-i+1;
                maxi=Math.max(len,maxi);
                hash[s.charAt(j)]=1;
            }
        }
        return maxi;
    }
}*/