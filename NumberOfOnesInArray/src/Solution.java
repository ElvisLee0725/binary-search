public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfOnesInArray(new int[]{0,1}));
    }

    // Use binary seach to find the index of the left most 1
    // Return arr.length - index
    // Time: O(logN), Space: O(1)
    public int numOfOnesInArray(int [] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        else if(arr.length == 1) {
            return arr[0] == 1 ? 1 : 0;
        }
        int left = 0;
        int right = arr.length;
        while(left < right-1) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == 1) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        // Edge Case: There is no 1s in the array
        if(right == arr.length) {
            return 0;
        }
        return arr[left] == 1 ? arr.length - left : arr.length - right;
    }
}
