class Solution {
    private long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long ans=helper(5,even) * helper( 4 , odd);
        return (int)(ans % MOD);
    }
    public long helper(long x , long n){
        if(n==0) return 1;
        long ans=helper(x,n/2);
        if(n%2==0) return (ans*ans)%MOD;
        else return (x*ans*ans)%MOD;
        
    }
}
