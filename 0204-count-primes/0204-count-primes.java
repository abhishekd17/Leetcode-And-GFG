//optimal
class Solution {
    public int countPrimes(int n) {
        int arr[]=new int[n+1];
        Arrays.fill(arr,1);
        for(int i=2;i*i<n;i++){
            if(arr[i]==1){
                for(int j=i*i;j<n;j+=i){
                    arr[j]=0;
                }
            }
        }

        int cnt=0;
        for(int i=2;i<n;i++){
            if(arr[i]==1) cnt++;
        }
        return cnt;
    }
}

// better
/*class Solution {
    public int countPrimes(int n) {
        int arr[]=new int[n+1];
        Arrays.fill(arr,1);
        for(int i=2;i<n;i++){
            if(arr[i]==1){
                for(int j=2*i;j<n;j+=i){
                    arr[j]=0;
                }
            }
        }

        int cnt=0;
        for(int i=2;i<n;i++){
            if(arr[i]==1) cnt++;
        }
        return cnt;
    }
}*/

// brute force
/*class Solution {
    private boolean prime(int n){
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        int cnt=0;
        for(int i=2;i<n;i++){
                if(prime(i)){
                    cnt++;
                }
        }
        return cnt;
    }
}*/