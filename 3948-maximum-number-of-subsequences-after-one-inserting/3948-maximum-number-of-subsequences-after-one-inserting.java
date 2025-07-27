class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length();

        long pre[] = new long[n + 1];
        long suf[] = new long[n + 1];

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == 'L'){
                pre[i + 1] = 1;
            }
            pre[i + 1] += pre[i];
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == 'T'){
                suf[i] = 1;
            }
            suf[i] += suf[i + 1];
        }

        long c = 0;
        long pc = 0;
        long l = 0;
        long t = 0;

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == 'C'){
                c += pre[i] * suf[i + 1];
                l += ( pre[i] + 1 ) * suf[i + 1];
                t += pre[i] * (suf[i + 1] + 1);
            }else{
                pc = Math.max(pc , pre[i] * suf[i]);
            }
        }
        c += pc;
        return Math.max(c , Math.max(l , t));
    }
}