public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().squareRoot(98.0));
    }

    public Double squareRoot(Double n) {
        // YOUR WORK HERE
        double left = 0;
        double right = n;
        while(Math.abs(left - right) > 0.000001) {
            double mid = left + (right - left) / 2;
            double sqr = mid * mid;
            if(sqr <= n) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
