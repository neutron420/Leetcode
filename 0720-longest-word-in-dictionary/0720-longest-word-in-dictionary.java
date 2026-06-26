public class Solution {
    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }
    Node root = new Node();
    String result = "";
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    public void dfs(Node node, StringBuilder current) {
        if (current.length() > result.length()) {
            result = current.toString();
        }
        for (int i = 0; i < 26; i++) {
            Node child = node.children[i];
            if (child != null && child.isEnd) {
                current.append((char) ('a' + i));
                dfs(child, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        dfs(root, new StringBuilder());
        return result;
    }
}
