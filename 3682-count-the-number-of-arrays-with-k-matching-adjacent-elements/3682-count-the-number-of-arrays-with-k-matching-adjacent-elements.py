class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        return (m * pow(m - 1 , n - k - 1) * comb(n - 1 , k )) % 1000000007;