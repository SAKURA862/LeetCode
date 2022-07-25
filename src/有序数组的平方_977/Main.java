package 有序数组的平方_977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[j + 1];
        for(int k = j; k >= 0; k--){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                res[k] = nums[i] * nums[i];
                i++;
            }
            else{
                res[k] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
