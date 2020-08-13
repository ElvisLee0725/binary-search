// Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in ascending order, find the starting and ending position of
// a given target value.

//Your algorithm's runtime complexity must be in the order of O(log n).

//If the target is not found in the array, return [-1, -1].

// Use Binary Search, while loop until left is next to right index, check the element at left and right index
// to determine which one is the first or last
// Use a helper function helper(int [] nums, int target, boolean findFirst) to do binary search
// If arr[mid] < target: left = mid + 1
// Else if arr[mid] > target: right = mid - 1
// When arr[mid] equals the target, if is findFirst, right = mid; Else, left = mid
// After BS, need to check whether to return left or right depending on findFirst or findLast

public class Solution {
    public static void main(String[] args) {
        int [] pos = new Solution().searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.print(pos[0] + ", " + pos[1]);

    }

    public int[] searchRange(int [] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int [] res = new int[]{-1, -1};
        res[0] = helper(nums, target, true);
        res[1] = helper(nums, target, false);

        return res;
    }

    public int helper(int [] arr, int t, boolean findFirst) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;

            if(arr[mid] < t) {
                left = mid + 1;
            }
            else if(arr[mid] > t) {
                right = mid - 1;
            }
            else {
                if(findFirst) {
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
        }

        if(arr[left] != t && arr[right] != t) {
            return -1;
        }

        if(findFirst) {
            return arr[left] == t ? left : right;
        }
        else {
            return arr[right] == t ? right : left;
        }
    }
}
