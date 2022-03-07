package 七进制数_504;

class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuffer ans = new StringBuffer();
        boolean isNegative = num < 0;
        num = num < 0 ? -num : num;
        while (num != 0){
            ans.append(num % 7);
            num /= 7;
        }
        if(isNegative) ans.append("-");
        ans = ans.reverse();
        return ans.toString();
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
