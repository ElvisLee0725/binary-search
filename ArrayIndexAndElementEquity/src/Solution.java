// Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

// Case 1: if the value at mid index is smaller, then check right half
// Case 2: if the value at mid index is bigger, then check left half
// Case 3: If mid == arr[mid], keep checking if there are still valid index at left hand side unless mid is 0 or arr[mid-1] < mid-1
// After the while loop, just return -1
// Time: O(logn), Space: O(1)

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{0,1,2,3};
        System.out.print(new Solution().method(arr));
    }
    public int method(int [] arr) {
        int left = 0;
        int right = arr.length-1;
        int lowestIdx = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid == arr[mid]) {
                lowestIdx = mid;
                if(mid == 0 || arr[mid-1] < mid-1) {
                    break;
                }
                else {
                    right = mid-1;
                }
            }

            if(mid > arr[mid]) {
                left = mid + 1;
            }
            else if(mid < arr[mid]) {
                right = mid - 1;
            }
        }

        return lowestIdx == Integer.MAX_VALUE ? -1 : lowestIdx;
    }
}
