package idni.jbc.forfree.struct.tree;

import idni.jbc.forfree.struct.tree.nodes.TrieNode;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0, len = word.length(); i < len; i++) {
            if ( node.get(word.charAt(i)) != null ) {
                node = node.get(word.charAt(i));
                continue;
            }
            node = node.add(word.charAt(i));
        }
    }

    public Boolean search(String word) {
        TrieNode node = this.root;
        for (int i = 0, len = word.length(); i < len; i++) {
            if ( (node =  node.get(word.charAt(i))) == null )
                return false;
        }
        return node.isEnd();
    }

    public Boolean startsWith(String word) {
        TrieNode node = this.root;
        for (int i = 0, len = word.length(); i < len; i++) {
            if ( (node =  node.get(word.charAt(i))) == null )
                return false;
        }
        return !node.isEnd();
    }
}
