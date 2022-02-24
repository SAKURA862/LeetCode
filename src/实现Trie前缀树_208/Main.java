package 实现Trie前缀树_208;

class Trie {

    private class TrieNode{
        char val;
        boolean flag;
        TrieNode[] cs = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char val, boolean flag) {
            this.val = val;
            this.flag = flag;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        char[] s = word.toCharArray();
        for(char c : s){
            int idx = c - 'a';
            if(p.cs[idx] == null) p.cs[idx] = new TrieNode(c, false);
            p = p.cs[idx];
        }
        p.flag = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        char[] s = word.toCharArray();
        for(char c : s){
            int idx = c - 'a';
            if(p.cs[idx] != null){
                p = p.cs[idx];
            }
            else return false;
        }
        return p.flag;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        char[] s = prefix.toCharArray();
        for(char c : s){
            int idx = c - 'a';
            if(p.cs[idx] != null){
                p = p.cs[idx];
            }
            else return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
