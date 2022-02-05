package 唯一元素的和_1748;

class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[101];
        int sum = 0;
        for(int x : nums){
            if(cnt[x] == 0) sum += x;
            else if(cnt[x] == 1) sum -= x;
            cnt[x]++;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
