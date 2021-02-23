// Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
// return the number of negative numbers in grid.

// For each array, use binary search to find the index of the first negative number, then, calculate
// the length of negative numbers in that array.
// Sum up number of negatives in each array, and return at the end
// Time: O(mlogn), Space: O(1)

class Solution {
    public static void main(String[] args) {
        int [][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.print(new Solution().countNegatives(grid));
    }
    public int countNegatives(int[][] grid) {
        int countNeg = 0;
        for(int i = 0; i < grid.length; i++) {
            int [] arr = grid[i];
            int left = 0;
            int right = arr.length-1;
            while(left < right - 1) {
                int mid = left + (right - left) / 2;
                if(arr[mid] >= 0) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            if(arr[left] >= 0 && arr[right] >= 0) {
                continue;
            }
            else {
                if(arr[left] < 0) {
                    countNeg += arr.length - left;
                }
                else {
                    countNeg += arr.length - right;
                }
            }
        }
        return countNeg;
    }
}
