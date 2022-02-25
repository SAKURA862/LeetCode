package 爱生气的书店老板_1052;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int n = customers.length;
        if(minutes >= n){
            for(int x : customers) ans += x;
            return ans;
        }

        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                ans += customers[i];
                customers[i] = 0;
            }
        }

        int max = 0;
        for(int i = 0; i < minutes; i++){
            max += customers[i];
        }
        for(int i = 1; i <= n - minutes; i++){
            int j = i + minutes;
            max = Math.max(max, max - customers[i - 1] + customers[j - 1]);
        }
        return ans + max;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
