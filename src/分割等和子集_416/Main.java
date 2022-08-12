package 分割等和子集_416;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int x : nums){
            sum += x;
        }
        int m = sum / 2;
        if(m * 2 != sum) return false;
        int[] f = new int[m + 1];
        for(int i = 1; i < n; i++){
            for(int j = m; j >= 1; j--){
                f[j] = f[j];
                if(j >= nums[i]){
                    f[j] = Math.max(f[j], f[j - nums[i]] + nums[i]);
                }
            }
        }
        return f[m] == m;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
