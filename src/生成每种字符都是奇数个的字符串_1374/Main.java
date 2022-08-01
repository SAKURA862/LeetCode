package 生成每种字符都是奇数个的字符串_1374;

class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if((n & 1) == 0){
            for(int i = 0; i < n - 1; i++){
                sb.append('a');
            }
            sb.append('b');
        }
        else{
            for(int i = 0; i < n; i++){
                sb.append('a');
            }
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
