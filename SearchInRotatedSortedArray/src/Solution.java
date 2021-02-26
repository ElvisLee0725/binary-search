// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// You are given a target value to search. If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.

//Your algorithm's runtime complexity must be in the order of O(log n).

// Binary Search
// Check if the pivot (sorted array from large to small point) is at left or right half? Then, if target is at
// the sorted half or pivot half

// Case 1: If nums[mid] is the target, just return mid
// Case 2: If nums[mid] < nums[left], then pivot is at left half, check if target is at sorted or pivot side
// Case 3: If nums[mid] > nums[right], then pivot is at right half, check if target is at sorted or pivot side
// Return -1 if nothing is found

// Time: O(logn), Space: O(1)

public class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{6, 1, 2, 3, 4, 5};
        System.out.println(new Solution().search(nums, 2));
    }

    public int search(int [] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
//        int left = 0;
//        int right = nums.length - 1;
//        while(left <= right) {
//            int mid = left + (right - left) / 2;
//            if(nums[mid] == target) {
//                return mid;
//            }
//            else if(nums[mid] < nums[left]) {
//                if(target > nums[mid] && target <= nums[right]) {
//                    left = mid + 1;
//                }
//                else {
//                    right = mid - 1;
//                }
//            }
//            else {
//                if(target >= nums[left] && target < nums[mid]) {
//                    right = mid - 1;
//                }
//                else {
//                    left = mid + 1;
//                }
//            }
//        }
        // return -1;

        // Use Binary Search to find pivot index (the number at left is greater) first.
        // Then, check if the target is within pivot to last index or 0 to pivot - 1, run binary search
        int pivot = findPivot(nums);

        if(target >= nums[pivot] && target <= nums[nums.length-1]) {
            return bs(nums, pivot, nums.length-1, target);
        }
        return bs(nums, 0, pivot - 1, target);
    }
    public int bs(int [] arr, int left, int right, int t) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == t) {
                return mid;
            }
            else if(arr[mid] > t) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findPivot(int [] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // Check if mid is 0 so mid - 1 won't go out of bound
            if(mid == 0 || arr[mid] < arr[mid-1]) {
                return mid;
            }
            else if(arr[mid] > arr[0]) {
                left = mid + 1;
            }
            else {
                // Be careful when moving right index when pivot is at left side; Or the pivot might be missed
                right = mid;
            }
        }
        // When the pivot is not found, it's a sorted array!
        return 0;
    }
}
