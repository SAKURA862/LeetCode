package 轮转数组_189;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] tmp = new int[k];
        for(int i = 0; i < k; i++){
            tmp[i] = nums[n - k + i];
        }
        for(int i = n - k - 1; i >= 0; i--){
            nums[i + k] = nums[i];
        }
        for(int i = 0; i < k; i++){
            nums[i] = tmp[i];
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
