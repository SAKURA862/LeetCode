package 剑指Offer_46_把数字翻译成字符串;

class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = s.charAt(i) - '0';
        }

        int pper = 1, per = 1, cur = 1;
        for(int i = 2; i <= n; i++){
            cur = per;
            if(canTogether(nums[i - 1], nums[i - 2])){
                cur += pper;
            }
            pper = per;
            per = cur;
        }
        return cur;
    }

    private boolean canTogether(int cur, int pre){
        if(pre == 0 || pre > 2) return false;
        return pre != 2 || cur < 6;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(25));
        System.out.println(solution.translateNum(2147483647));
        System.out.println(solution.translateNum(0));
        System.out.println(solution.translateNum(1));
        System.out.println(solution.translateNum(41895632));
        System.out.println(solution.translateNum(10000000));
        System.out.println(solution.translateNum(100000001));
    }
}
