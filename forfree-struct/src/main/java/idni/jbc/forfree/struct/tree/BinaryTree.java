package idni.jbc.forfree.struct.tree;

import idni.jbc.forfree.struct.tree.TreeNode;

/**
 * 二叉树
 *
 * @param <T> 树节点类型
 *
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 *
 * @see idni.jbc.forfree.struct.tree.TreeNode
 */
public class BinaryTree<T> extends TreeNode<T>{

    /** 左子树*/
    public BinaryTree<T> left;

    /** 右子树*/
    public BinaryTree<T> right;

    public BinaryTree() { }

    public BinaryTree(T val) { super(val); }

    /**
     * 构造包含子节点的树
     *
     * @param val 指定节点的值
     * @param left 左子树
     * @param right 右子树
     *
     * @since 1.01
     *
     * @see TreeNode#TreeNode()
     */
    public BinaryTree(T val, BinaryTree<T> left, BinaryTree<T> right) {
        super(val, left, right);
        this.left = left;
        this.right = right;
    }
}
