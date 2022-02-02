package 至少是其他数字两倍的最大数_747;

class Solution {
    public int dominantIndex(int[] nums) {
        int max = -0x3f3f3f3f;
        int idx = -1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(max < nums[i]){
                idx = 2 * max <= nums[i] ? i : -1;
                max = nums[i];
            }
            else{
                idx = max >= 2 * nums[i] ? idx : -1;
            }
        }
        return idx;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
