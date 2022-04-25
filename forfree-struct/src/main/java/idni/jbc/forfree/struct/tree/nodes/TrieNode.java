package idni.jbc.forfree.struct.tree.nodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import idni.jbc.forfree.struct.tree.Leaf;
import idni.jbc.forfree.struct.tree.nodes.TrieNode;

/**
 * 树结构，可用来构造普通树，提供不分操作方法
 *
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 *
 * @see idni.jbc.forfree.struct.tree.Leaf
 */
public class TrieNode extends Leaf<Character> {

    /** 子节点列表 */
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() { super(); }

    public TrieNode add(char ch) {
        TrieNode newNode = new TrieNode();
        this.children.put(ch, newNode);
        this.degree++;
        return newNode;
    }

    public TrieNode get(char ch) {
        return this.children.get(ch);
    }

    public boolean isEnd() {
        return this.degree == 0;
    }
}
