// Given two sorted arrays of integers of the same length, determine the median of the combined sorted array.
//
// The median of an array of sorted numbers corresponds to the middle element, if the array has an odd number
// of elements, and the average of the two middle elements if the array has an even number of elements.
//
// For the interviewer: This example happens to have the two arrays be of even length. If your interviewee ask
// 'what if they two arrays are of different length', it shows they are thinking of other situations.

import java.util.Arrays;

// Input:  	[1, 12, 13, 26, 38], []
// Output:	16
// (because the median of [1, 2, 12, 13, 15, 17, 26, 30, 38, 45] equals 16)
public class Solution {
    public static void main(String[] args) {
        int [] arr1 = new int[]{1, 12, 13, 26, 38};
        int [] arr2 = new int[]{2, 15, 17, 30, 45};
        System.out.println(new Solution().getMedium2(arr1, arr2));
    }

    // Each round, delete half from arr1 and half from arr2
    // Until arr1 and arr2 are in length 2, we can get the medium from them.
    // Time: O(logN), Space: O(logN)
    public int getMedium2(int [] arr1, int [] arr2) {
        if(arr1.length == 2 && arr2.length == 2) {
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
        }

        // Find the middle from arr1 and arr2
        // Case 1: mid1 < mid2, remove everything before mid1 in arr1 and everything after mid2 in arr2
        // Case 2: mid1 > mid2, remove everything after mid1 in arr1 and everything before mid2 in arr2
        int mid1 = (arr1.length - 1) / 2;
        int mid2 = (arr2.length - 1) / 2;

        if(arr1[mid1] < arr2[mid2]) {
            return getMedium2(Arrays.copyOfRange(arr1, mid1, arr1.length), Arrays.copyOfRange(arr2, 0, mid2 + 1));
        }
        else {
            return getMedium2(Arrays.copyOfRange(arr1, 0, mid1 + 1), Arrays.copyOfRange(arr2, mid2, arr2.length));
        }
    }

    public int getMedium(int [] arr1, int [] arr2) {
        int i = 0;
        int j = 0;
        int count = 0;
        Integer ele1 = null;
        Integer ele2 = null;
        while(i < arr1.length && j < arr2.length) {
            int min = 0;
            if(arr1[i] < arr2[2]) {
                min = arr1[i];
                i++;
            }
            else {
                min = arr2[j];
                j++;
            }
            count++;
            if(count == (arr1.length + arr2.length) / 2) {
                ele1 = min;
            }
            else if(count == (arr1.length + arr2.length) / 2 + 1) {
                ele2 = min;
                break;
            }
        }
        // Edge Case: When elements in one array are smaller than the other
        if(i == 0) {
            ele2 = arr1[i];
        }
        else if(j == 0) {
            ele2 = arr2[j];
        }
        return (ele1 + ele2) / 2;
    }
}
