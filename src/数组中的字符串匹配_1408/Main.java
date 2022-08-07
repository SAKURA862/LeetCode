package 数组中的字符串匹配_1408;

import java.util.*;

/**
 * 暴力
 */
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }
}

/**
 * kmp
 */
class Solution2 {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        int n = words.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(words[i].length() >= words[j].length()){
                    if(kmp(words[i], words[j]) >= 0) res.add(words[j]);
                }
                else{
                    if(kmp(words[j], words[i]) >= 0) res.add(words[i]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private int kmp(String s, String p){
        int m = s.length(),
            n = p.length();
        int[] next = getNextArray(p);
        for(int i = 0, j = 0; i < m; i++){
            while (j > 0 && s.charAt(i) != p.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == p.charAt(j)){
                j++;
            }
            if(j == n) {
                return i - j + 1;
            }
        }
        return -1;
    }

    // 构建next数组
    private int[] getNextArray(String s){
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0;
        for(int i = 1, j = 0; i < n; i++){
            while (j > 0 && s.charAt(j) != s.charAt(i)){
                j = next[j - 1];
            }
            if(s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

/**
 * ac自动机
 */
class Solution3 {

    private class AcAutomaton{
        private class TrieNode{
            TrieNode[] next = new TrieNode[26];
            TrieNode fail;
            List<Integer> exist = new ArrayList<>();
        }

        // trie树的根
        private TrieNode root = new TrieNode();

        // 记录单词出现次数，因为每个单词至少出现一次(即它自身)
        // 所以最后只返回出现次数大于1的单词
        private Map<String, Integer> count = new HashMap<>();

        public AcAutomaton(String[] words) {
            // 构建trie树
            buildTrie(words);
            // 初始化fail指针
            initFail();
        }

        /**
         * 查找每个单词出现次数
         * @param s 待查找字符串(本题中是由所有单词拼接而成的)
         * @return
         */
        public Map<String, Integer> getOccurrencesNumber(String s){
            int n = s.length();
            TrieNode p = root;
            out:
            for(int i = 0; i < n; i++){
                // 分隔符直接跳过
                if(s.charAt(i) == '$') continue;
                int idx = s.charAt(i) - 'a';
                // 当当前节点没有该子节点时，通过fail指针到另一个节点上查找是否有该子节点
                // 因为另一个节点也有可能没有，所以此过程是循环的，使用while语句
                while (p.next[idx] == null){
                    // 如果已经到达root，说明没有单词和当前字符串有相等前后缀
                    // 直接从root重新开始
                    if(p == root) continue out;
                    // 否则通过fail指针移动
                    else p = p.fail;
                }
                p = p.next[idx];
                // 若当前节点存储着单词长度信息，则根据长度截取出单词
                // 并将该单词的计数+1
                if(p.exist.size() > 0){
                    for(int x : p.exist){
                        String tmp = s.substring(i - x + 1, i + 1);
                        count.put(tmp, count.getOrDefault(tmp, 0) + 1);
                    }
                }
            }
            return count;
        }

        /**
         * 构建trie树
         * @param words 构建trie树使用的单词集合
         */
        private void buildTrie(String[] words){
            for(String s : words){
                TrieNode p = root;
                int n = s.length();
                for(int i = 0; i < n; i++){
                    int idx = s.charAt(i) - 'a';
                    if(p.next[idx] == null){
                        p.next[idx] = new TrieNode();
                    }
                    p = p.next[idx];
                    if(i == n - 1){
                        p.exist.add(n);
                    }
                }
            }
        }

        /**
         * 初始化fail指针
         */
        private void initFail(){
            // 通过bfs初始化fail指针
            Queue<TrieNode> q = new LinkedList<>();
            // 遍历第二层节点
            for(TrieNode t : root.next){
                if(t != null){
                    // 第二层节点的fail指针一定指向root
                    t.fail = root;
                    // 将第二层节点加入队列
                    q.add(t);
                }
            }
            while (!q.isEmpty()){
                TrieNode cur = q.poll();
                for(int i = 0; i < 26; i++){
                    TrieNode p = cur;
                    if(cur.next[i] == null) continue;
                    // 假设正在初始化fail指针的节点为node，其父节点为father，node是father的第i个子节点
                    // 则node的fail指针取决于father.fail是否有第i个子节点
                    // 若有则node.fail = father.fail的第i个子节点
                    // 否则需要对father.fail.fail进行相同的判断
                    // 直到找到满足条件的节点(p.fail.next[i] != null)或者回到root(p == root)
                    // 若回到root则node.fail = root
                    // 因此此处应使用while循环判断
                    while (p != root && p.fail.next[i] == null){
                        p = p.fail;
                    }
                    // 如果回到root，则node.fail = root
                    if(p == root){
                        cur.next[i].fail = root;
                    }
                    // 否则node.fail = p.fail的第i个子节点(p.fail.next[i])
                    else{
                        cur.next[i].fail = p.fail.next[i];
                        // 连接上fail指针后判断:
                        // 若fail指针指向的节点是终止节点，则将该结点维护的单词长度添加到当前节点中
                        if(p.fail.next[i].exist.size() > 0){
                            cur.next[i].exist.addAll(p.fail.next[i].exist);
                        }
                    }
                    // 将这个子节点加入队列，继续bfs
                    q.add(cur.next[i]);
                }
            }
        }
    }

    public List<String> stringMatching(String[] words) {
        // 初始化ac自动机
        AcAutomaton acAutomaton = new AcAutomaton(words);
        // 将所有单词拼接到一起形成字符串s，如果某个单词是其他单词的子字符串
        // 那么它在这个字符串中出现的次数将大于1 (每个单词都会至少出现一次，因为它自身也包含在这个字符串s中)
        // 最终只要返回所有出现次数大于1的字符串即可
        StringBuilder sb = new StringBuilder();
        for(String s : words){
            // 在每个单词之间需要添加分隔符，以免两个单词拼接处刚好包含某单词导致出现干扰，如:
            // ["aab", "bcc", "bb"] 正常返回结果为[]，如果没有添加分隔符则会返回["bb"]
            // 如果没有加分隔符，则ac自动机会在字符串"aabbcc"中寻找到单词"bb"
            // 如果加了分隔符，则字符串s为"aab$bcc$"，这样就不会误判断单词"bb"
            sb.append(s).append('$');
        }
        Map<String, Integer> count = acAutomaton.getOccurrencesNumber(sb.toString());
        List<String> res = new ArrayList<>();
        // 找出所有出现次数大于1的单词
        count.forEach((s, cnt) -> {
            if(cnt > 1) res.add(s);
        });
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String[] arr = new String[10000];
        for(int i = 0; i < 10000; i++){
            int len = random.nextInt(20);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++){
                sb.append((char) (random.nextInt(26) + 'a'));
            }
            arr[i] = sb.toString();
        }

        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

//        System.out.println(solution.stringMatching(new String[]{"uexk","aeuexkf","wgxih","yuexk","gxea","yuexkm","ypmfx","jjuexkmb","wqpri","aeuexkfpo","kqtnz","pkqtnza","nrbb","hmypmfx","krqs","jjuexkmbyt","zvru","ypmfxj"}));
        long startTime = System.currentTimeMillis();
        List<String> res = solution.stringMatching(arr);
        long overTime = System.currentTimeMillis();
        System.out.println("暴力解法: " + (overTime - startTime));

//        long startTime2 = System.nanoTime();
//        List<String> res2 = solution2.stringMatching(arr);
//        long overTime2 = System.nanoTime();
//        System.out.println("kmp算法: " + (overTime2 - startTime2));

        long startTime3 = System.currentTimeMillis();
        List<String> res3 = solution3.stringMatching(arr);
        long overTime3 = System.currentTimeMillis();

        System.out.println("ac自动机: " + (overTime3 - startTime3));
    }
}
