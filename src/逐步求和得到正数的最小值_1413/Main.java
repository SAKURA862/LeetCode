package 逐步求和得到正数的最小值_1413;

class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++){
            nums[i] += nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min > num) min = num;
        }
        return min < 0 ? -min + 1 : 1;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
