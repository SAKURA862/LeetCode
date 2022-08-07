package 函数的独占时间_636;

import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>(); // {idx, 开始运行的时间}
        int[] res = new int[n];
        for (String log : logs) {
            String[] arr = log.split(":");
            int idx = Integer.parseInt(arr[0]);
            String type = arr[1];
            int timestamp = Integer.parseInt(arr[2]);
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exclusiveTime(3, new ArrayList<>(Arrays.asList("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3")))));
    }
}
