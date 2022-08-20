package 检查单词是否为句中其他单词的前缀_1455;

class Solution {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        int idx = -1;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        TrieNode root = buildTrie(words);
        int n = searchWord.length();
        TrieNode p = root;
        for(int i = 0; i < n; i++){
            int t = searchWord.charAt(i) - 'a';
            if(p.next[t] == null) return -1;
            p = p.next[t];
        }
        return p.idx + 1;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        int len = words.length;
        for(int k = 0; k < len; k++){
            TrieNode p = root;
            int n = words[k].length();
            for(int i = 0; i < n; i++){
                int t = words[k].charAt(i) - 'a';
                if(p.next[t] == null){
                    p.next[t] = new TrieNode();
                }
                p = p.next[t];
                if(p.idx == -1) p.idx = k;
            }
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPrefixOfWord("i love eating burger", "burg"));
    }
}
