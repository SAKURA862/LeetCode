package 标签验证器_591;

import java.util.*;

/*class Solution {
    private char[] code;
    private List<Word> words = new ArrayList<>();
    private Deque<String> tagName = new LinkedList<>();
    private HashMap[] maps = new HashMap[]{
            new HashMap<Character, Integer>(){{ put('s', 1); }},
            new HashMap<Character, Integer>(){{ put('s', 1); put('t', 2); put('c', 3); put('e', 4); }},
            new HashMap<Character, Integer>(){{ put('s', 1); put('t', e); put('c', 3); put('e', 4); }},
            new HashMap<Character, Integer>(){{ put('d', 5); put('a', 6); }},
            new HashMap<Character, Integer>(){{ put('s', 1); }},
            new HashMap<Character, Integer>(){{ put('d', 5); put('a', 6); }},
            new HashMap<Character, Integer>(){{ put('s', 1); put('t', 2); put('e', 4); }}
    };
    public boolean isValid(String _code) {
        code = _code.toCharArray();
        if(!splitWords()) return false;
        int state = 0;
        for(Word word : words){
            if(maps[state].containsKey(word.type)){
                state = (int) maps[state].get(word.type);
                if(word.type == 's'){
                    tagName.push(word.data.split(1, word.data.length() - 1));
                }else if(word.type == 'e'){
                    String endName = word.data.split(2, word.data.length() - 1);
                    if(!tagName.peekLast().equals(endName)){
                        return false;
                    }
                    else tagName.pop();
                }
            }
        }
        return state == 4;
    }

    private boolean splitWords(){
        int n = code.length;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(code[i] == '<'){

                if(stringBuilder.length() > 0){
                    words.add(new Word(stringBuilder.toString(), 't'));
                    stringBuilder.delete(0, stringBuilder.length());
                }

                if(i == n - 1) return false;
                if(code[i + 1] == '!'){
                    if(i >= n - 10) return false;
                    if("<!CDATA[".equals(String.valueOf(code, i, 9))){
                        words.add(new Word("<!CDATA[", 'c'));
                        int cdataStart = i + 9, j = i + 9;
                        for(; j < n - 2; j++){
                            if(code[j] == ']' && code[j + 1] == ']' && code[j + 2] == '>'){
                                words.add(new Word(String.valueOf(code, cdataStart, j - cdataStart), 'd'));
                            }
                        }
                        if(j == n - 2) return false;
                        words.add(new Word("]]>", 'a'));
                        i = j + 3;
                    }
                    else return false;
                }
                else if(code[i + 1] == '/'){
                    int j;
                    for(j = i + 2; j < n || j <= i + 11; j++){
                        if(j == i + 2 && !isCapital(code[j])) return false;
                        if(j == i + 2 && !(isCapital(code[j]) || code[j] == '>')) return false;
                        if(code[j] == '>'){
                            words.add(new Word(String.valueOf(code, i, j - i + 1), 'e'));
                            i = j + 1;
                            break;
                        }
                    }
                    if(i != j + 1) return false;
                }
                else{
                    int j;
                    for(j = i + 1; j < n || j <= i + 10; j++){
                        if(j == i + 1 && !isCapital(code[j])) return false;
                        if(j == i + 1 && !(isCapital(code[j]) || code[j] == '>')) return false;
                        if(code[j] == '>'){
                            words.add(new Word(String.valueOf(code, i, j - i + 1), 's'));
                            i = j + 1;
                            break;
                        }
                    }
                    if(i != j + 1) return false;
                }
            }
            else{
                stringBuilder.append(code[i]);
            }
        }
        return true;
    }

    private boolean isCapital(char c){
        if(c >= 'A' && c <= 'Z') return true;
        return false;
    }

    private class Word{
        String data;
        char type;

        public Word() {
        }

        public Word(String data, char type) {
            this.data = data;
            this.type = type;
        }
    }
}*/

class Solution {
    String CDATA1 = "<![CDATA[", CDATA2 = "]]>";
    public boolean isValid(String s) {
        Deque<String> d = new ArrayDeque<>();
        int n = s.length(), i = 0;
        while (i < n) {
            if (i + 8 < n && s.substring(i, i + 9).equals(CDATA1)) {
                if (i == 0) return false;
                int j = i + 9;
                boolean ok = false;
                while (j < n && !ok) {
                    if (j + 2 < n && s.substring(j, j + 3).equals(CDATA2)) {
                        j = j + 3; ok = true;
                    } else {
                        j++;
                    }
                }
                if (!ok) return false;
                i = j;
            } else if (s.charAt(i) == '<') {
                if (i == n - 1) return false;
                boolean isEnd = s.charAt(i + 1) == '/';
                int p = isEnd ? i + 2 : i + 1, j = p;
                while (j < n && s.charAt(j) != '>') {
                    if (!Character.isUpperCase(s.charAt(j))) return false;
                    j++;
                }
                if (j == n) return false;
                int len = j - p;
                if (len < 1 || len > 9) return false;
                String tag = s.substring(p, j);
                i = j + 1;
                if (!isEnd) {
                    d.addLast(tag);
                } else {
                    if (d.isEmpty() || !d.pollLast().equals(tag)) return false;
                    if (d.isEmpty() && i < n) return false;
                }
            } else {
                if (i == 0) return false;
                i++;
            }
        }
        return d.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
