package NOI_2001_DAY1_T1_食物链;


import java.util.Scanner;

/**
 * 带权并查集
 */
class Solution{
    private int[] pre;
    private int[] re;
    int n;

    public int getNumberOfLies(int n, int[][] relation){
        this.n = n;
        int m = relation.length;
        pre = new int[n];
        re = new int[n];
        for(int i = 0; i < n; i++) pre[i] = i;
        int ans = 0;
        for(int i = 0; i < m; i++){
            int k = relation[i][0], x = relation[i][1], y = relation[i][2];
            if(x >= n || x < 0 || y >= n || y < 0){
                ans++;
                continue;
            }
            int a = find(x);
            int b = find(y);
            // 他说x与y是同类
            if(k == 1){
                // x与y是同一组且分别与根节点关系不同，假话
                if(a == b && re[x] != re[y]){
                    ans++;
                    continue;
                }
                // x与y不在同一组，无关系，合并
                if(a != b){
                    pre[a] = b;
                    // 向量运算
                    re[a] = (re[y] - re[x] + 3) % 3;
                }
            }
            // 他说x捕食y
            else if(k == 2){
                // x与y在同一组且不是x捕食y，假话
                if(a == b && (re[x] - re[y] + 3) % 3 != 1){
                    ans++;
                    continue;
                }
                // x与y不在同一组，无关系，合并
                if(a != b){
                    pre[a] = b;
                    re[a] = (1 + re[y] - re[x] + 3) % 3;
                }
            }
        }
        return ans;
    }

    private int find(int x){
        if(pre[x] != x){
            int prex = pre[x];
            pre[x] = find(pre[x]);
            re[x] = (re[x] + re[prex]) % 3;
        }
        return pre[x];
    }
}


/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] relation = new int[m][3];
            for(int i = 0; i < m; i++){
                relation[i][0] = scanner.nextInt();
                relation[i][1] = scanner.nextInt() - 1;
                relation[i][2] = scanner.nextInt() - 1;
            }
            System.out.println(solution.getNumberOfLies(n, relation));
        }
    }
}
