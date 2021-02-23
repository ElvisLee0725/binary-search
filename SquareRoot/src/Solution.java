// Given a non-negative integer x, compute and return the square root of x.
// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

// Binary Search
// Define left as 0, right as x / 2
// While left <= right, get the mid number and check if its square is greater than x? If so, set right to mid-1. Else if the square is smaller than x, set left to mid + 1
// If it's equal, then mid is the square root
// Return right at the end since in the end left will equal to right. If the square is greater than x, the answer is the mid - 1, which is right.
// ** Be careful when counting square, it might overflow in int
// Edge Case: When x is less than 2, just return x
// Time: O(logn), Space: O(1)

class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().mySqrt(25));
    }
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int left = 0;
        int right = x / 2;
        long sqr;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            sqr = mid * mid;
            if(sqr > x) {
                right = mid - 1;
            }
            else if(sqr < x) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return right;
    }
}