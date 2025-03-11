// Jai Maa Saraswati
// optimal
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int arr[]={-1,-1,-1}; // lastseen
        int cnt=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            arr[ch-'a']=i;
            // if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1){
                cnt+=(1+Math.min(arr[0] ,Math.min(arr[1],arr[2])));
            // }
        }
        return cnt;
    }
}


// better
/*class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        HashMap<Character, Integer> map=new HashMap<>();
        int l=0 , r=0 , ans=0;
        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                ans+=n-r;
                char chl=s.charAt(l);
                map.put(chl,map.get(chl)-1);
                if(map.get(chl)==0){
                    map.remove(chl);
                }
                l++;
            }
            r++;
        }
        return ans;

    }
}*/


// brute force
/*class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int cntA=0 ,cntB=0,cntC=0;
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                if(ch=='a') cntA++;
                if(ch=='b') cntB++;
                if(ch=='c') cntC++;
                if(cntA>=1 && cntB>=1 && cntC>=1 && (cntA+cntB+cntC)>=3) ans++;
            }
        }
        return ans;
    }
}*/