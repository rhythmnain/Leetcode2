// Last updated: 12/14/2025, 10:47:53 PM
1class TrieNode {
2    TrieNode[] children;
3    boolean isWordCompleted;
4
5    TrieNode() {
6        children = new TrieNode[26];
7        isWordCompleted = false;
8    }
9}
10
11class WordDictionary {
12    TrieNode root;
13
14    WordDictionary() {
15        root = new TrieNode();
16    }
17    
18    void addWord(String word) {
19        TrieNode newRoot = root;
20        for (char ch : word.toCharArray()) {
21            int alphabetIndex = ch - 'a';
22            if (newRoot.children[alphabetIndex] == null) {
23                newRoot.children[alphabetIndex] = new TrieNode();
24            }
25            newRoot = newRoot.children[alphabetIndex];
26        }
27        newRoot.isWordCompleted = true;
28    }
29    
30    boolean searchHelper(String word, int index, TrieNode newRoot) {
31        if (index == word.length())
32            return newRoot.isWordCompleted;
33        char ch = word.charAt(index);
34        if (ch == '.') {
35            for (int i = 0; i < 26; i++) {
36                if (newRoot.children[i] != null && searchHelper(word, index + 1, newRoot.children[i])) {
37                    return true;
38                }
39            }
40            return false;
41        }
42        else {
43            if (newRoot.children[ch - 'a'] == null) {
44                return false;
45            }
46            return searchHelper(word, index + 1, newRoot.children[ch - 'a']);
47        }
48    }
49
50    boolean search(String word) {
51        return searchHelper(word, 0, root);
52    }
53}