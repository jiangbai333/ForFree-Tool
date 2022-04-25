package idni.jbc.forfree.struct.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import idni.jbc.forfree.struct.tree.Trie;

public class TrieTest {

    private Trie trie = new Trie();

    private String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

    @Before
    public void init() {
        for (int i = 0, len = words.length; i < len; i++) {
            trie.insert(words[i]);
        }
    }

    @Test
    public void testLongestWord() {
        String ans = "";
        for (int i = 0, len = words.length; i < len; i++) {
            String word = words[i];
            if ( trie.startsWith(word) ) continue;
            if ( word.length() == ans.length() && word.compareTo(ans) > 0 ) continue;
            if ( trie.search(word) ) ans = word;
        }

        System.out.println(ans);
    }

    @Test
    public void testSearch() {
        Assert.assertTrue(trie.search("apple"));
    }

    @Test
    public void testStartsWith() {
        //Assert.assertTrue(trie.startsWith("a"));
        //Assert.assertTrue(trie.startsWith("banan"));
        //Assert.assertTrue(trie.startsWith("app"));
        //Assert.assertTrue(trie.startsWith("apple"));
        //Assert.assertTrue(trie.startsWith("appl"));
    }

    @Test
    public void testConstructor() { }
}
