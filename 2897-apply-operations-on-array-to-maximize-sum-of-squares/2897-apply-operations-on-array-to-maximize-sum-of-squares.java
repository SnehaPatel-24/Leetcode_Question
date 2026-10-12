import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCounts = new int[31];
        
        // 1. Count total set bits at each position
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }
        
        long totalSum = 0;
        
        // 2. Greedily construct the k largest numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (bitCounts[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCounts[bit]--; 
                }
            }
            // 3. Square the number and accumulate modulo MOD
            totalSum = (totalSum + currentNum * currentNum) % MOD;
        }
        
        return (int) totalSum;
    }
}
