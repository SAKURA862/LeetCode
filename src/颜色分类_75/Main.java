package 颜色分类_75;

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                swap(nums, p0, i);
                if(p0 < p1) swap(nums, p1, i);
                p0++; p1++;
            }
            else if (nums[i] == 1){
                swap(nums, p1, i);
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
