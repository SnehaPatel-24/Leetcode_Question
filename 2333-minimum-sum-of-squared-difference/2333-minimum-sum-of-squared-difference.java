
import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diff = new long[n];
        long maxDiff = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = k1 + k2; // total reduction budget, can be distributed freely

        // If total budget can zero out all diffs, answer is 0
        long totalDiffSum = 0;
        for (long d : diff) totalDiffSum += d;
        if (k >= totalDiffSum) return 0;

        // Binary search on the "cap" value: reduce all diffs down to at most `mid`
        long lo = 0, hi = maxDiff;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (canAchieve(diff, mid, k)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        // lo is the smallest cap achievable with budget k
        // Now compute actual cost distribution: reduce everything to "lo",
        // but we may have leftover budget to reduce some elements further to lo-1
        long used = 0;
        for (long d : diff) {
            if (d > lo) used += (d - lo);
        }
        long remaining = k - used;
        // 'remaining' elements that are exactly at cap `lo` can be reduced to lo-1

        // Build final squared sum
        long result = 0;
        for (long d : diff) {
            long capped = Math.min(d, lo);
            if (capped == lo && remaining > 0 && d >= lo && lo > 0) {
                // reduce one more unit on this element
                capped -= 1;
                remaining -= 1;
            }
            result += capped * capped;
        }

        return result;
    }

    // Check if we can reduce all diffs to be <= cap using at most k total reductions
    private boolean canAchieve(long[] diff, long cap, long k) {
        long needed = 0;
        for (long d : diff) {
            if (d > cap) {
                needed += (d - cap);
                if (needed > k) return false; // early exit
            }
        }
        return needed <= k;
    }
}