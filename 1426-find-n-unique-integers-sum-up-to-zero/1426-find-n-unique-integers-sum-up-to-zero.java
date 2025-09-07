class Solution {
    public int[] sumZero(int n) {
        if (n == 1)
            return new int[] { 0 };
        int arr[] = new int[n];
        if (n % 2 == 1)
            arr[n / 2] = 0;

        int x = 0;
        for (int i = 1; i <= n / 2; i++) {
            arr[i - 1] = -i;
            arr[n - i] = i;
        }

        return arr;
    }
}