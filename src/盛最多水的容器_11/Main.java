package 盛最多水的容器_11;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = (r - l) * Math.min(height[l], height[r]);
        while (l < r){
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
