package idni.jbc.forfree.struct.tree;

import idni.jbc.forfree.struct.tree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

    private TreeNode<String> tree;

    @Before
    public void init() {
        TreeNode<String> 
            t1 = new TreeNode<String>("1"),
            t2 = new TreeNode<String>("2"),
            t3 = new TreeNode<String>("3"),
            t4 = new TreeNode<String>("4"),
            t5 = new TreeNode<String>("5"),
            t6 = new TreeNode<String>("6"),
            t7 = new TreeNode<String>("7"),
            t8 = new TreeNode<String>("8"),
            t9 = new TreeNode<String>("9"),
            t10 = new TreeNode<String>("10"),
            t11 = new TreeNode<String>("11"),
            t12 = new TreeNode<String>("12");

        TreeNode<String> ta = new TreeNode<String>("a", t1, t2, t3);
        TreeNode<String> tb = new TreeNode<String>("b", t4, t5, t6);
        TreeNode<String> tc = new TreeNode<String>("c", tb, t7, t8, t9);
        TreeNode<String> td = new TreeNode<String>("d", t10, t11, t12);

        TreeNode<String> te = new TreeNode<String>("e", ta, tc);
        this.tree = new TreeNode<String>("f", te, td);
    }

    @Test
    public void testConstructor() { }

    @Test
    public void testDepth() {
        Assert.assertEquals(5, this.tree.depth());
        System.out.println(tree.val);
        //Assert.assertTrue(DateTool.dateTime().matches("\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2} \\d{3}"));
    }
}
