package 移除元素_27;

class Solution {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int fast = 0;
        int slow;
        for (slow = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
