package idni.jbc.forfree.struct.tree;

import idni.jbc.forfree.struct.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

    private BinaryTree<Integer> BTree;

    @Before
    public void init() {
        BinaryTree<Integer> 
            BTree17 = new BinaryTree<Integer>(7),
            BTree16 = new BinaryTree<Integer>(6),
            BTree15 = new BinaryTree<Integer>(5),
            BTree14 = new BinaryTree<Integer>(4),
            BTree13 = new BinaryTree<Integer>(3),
            BTree12 = new BinaryTree<Integer>(2),
            BTree11 = new BinaryTree<Integer>(1),
            BTree10 = new BinaryTree<Integer>(0),
            BTree9 = new BinaryTree<Integer>(9, BTree12, BTree13),
            BTree8 = new BinaryTree<Integer>(8, BTree10, BTree11),
            BTree7 = new BinaryTree<Integer>(7, BTree8, BTree9),
            BTree6 = new BinaryTree<Integer>(6, BTree16, BTree17),
            BTree5 = new BinaryTree<Integer>(5, BTree14, BTree15),
            BTree4 = new BinaryTree<Integer>(4, BTree5, BTree6),
            BTree3 = new BinaryTree<Integer>(3, BTree4, BTree7),
            BTree2 = new BinaryTree<Integer>(2),
            BTree1 = new BinaryTree<Integer>(1, BTree2, BTree3);

        this.BTree = BTree1;
        BTree3.toString();

    }

    @Test
    public void testConstructor() { }

    @Test
    public void testDepth() {
        Assert.assertEquals(5, this.BTree.depth());
        //Assert.assertTrue(DateTool.dateTime().matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
    }
}
