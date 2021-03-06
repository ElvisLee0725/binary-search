// You are given an array of positive integers w where w[i] describes the weight of ith index (0-indexed).

// We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1]. pickIndex() should return the integer proportional to its weight in the w array. For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).

// More formally, the probability of picking index i is w[i] / sum(w).

// Imagine there is a line on the ground, each prefix sum has its own proportion. The bigger the number, the bigger its area is. If we through a dart randomly, the bigger chance it lands in bigger propotion.
// Use an array to store prefix sums.
// At pickIndex, get the target by random * totalSum. Then, use binary search to find the index which includes target number.
// Time: O(logn), Space: O(n)
class Solution {
    int totalSum;
    int [] prefixSum;
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        this.prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            this.prefixSum[i] = this.prefixSum[i-1] + w[i];
        }
        this.totalSum = this.prefixSum[w.length-1];
    }

    public int pickIndex() {
        double target = Math.random() * this.totalSum;
        int left = 0;
        int right = this.prefixSum.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(target > this.prefixSum[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
