// Given two sorted arrays of integers of the same length, determine the median of the combined sorted array.
//
// The median of an array of sorted numbers corresponds to the middle element, if the array has an odd number
// of elements, and the average of the two middle elements if the array has an even number of elements.
//
// For the interviewer: This example happens to have the two arrays be of even length. If your interviewee ask
// 'what if they two arrays are of different length', it shows they are thinking of other situations.

// Input:  	[1, 12, 13, 26, 38], []
// Output:	16
// (because the median of [1, 2, 12, 13, 15, 17, 26, 30, 38, 45] equals 16)
public class Solution {
    public static void main(String[] args) {
        int [] arr1 = new int[]{4, 5, 6};
        int [] arr2 = new int[]{1, 2, 3};
        System.out.println(new Solution().getMedium(arr1, arr2));
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
