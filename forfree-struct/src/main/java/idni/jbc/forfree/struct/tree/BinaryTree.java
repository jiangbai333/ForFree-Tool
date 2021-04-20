package idni.jbc.forfree.struct.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import idni.jbc.forfree.struct.tree.Leaf;

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
public class BinaryTree<T> extends Leaf<T>{

    /** 左子树*/
    public BinaryTree<T> left;

    /** 右子树*/
    public BinaryTree<T> right;

    public BinaryTree(T val) { super(val); }

    public BinaryTree(T val, BinaryTree<T> left, BinaryTree<T> right) { 
        super(val);
        this.numberOfNodes += 2;
        this.degree += 2;
        this.left = left;
        this.right = right;
    }

    /**
     * 为当前节点添加左子树
     *
     * @param left 左子树
     * @return 是否添加成功 当节点存在左子树时返回 false 表示添加失败
     *
     * @since 1.01
     */
    public boolean addLeft(BinaryTree<T> left) {
        if ( this.left instanceof BinaryTree ) {
            return false;
        }
        this.left = left;
        return true;
    }

    /**
     * 为当前节点添加右子树
     *
     * @param right 将要被添加的节点
     * @return 是否添加成功 当节点存在右子树时返回 false 表示添加失败
     *
     * @since 1.01
     */
    public boolean addRight(BinaryTree<T> right) {
        if ( this.left instanceof BinaryTree ) {
            return false;
        }
        this.right = right;
        return true;
    }

    /**
     * 获取剪掉当前节点形成的森林
     *
     * @return List 返回的包含当前节点子树 {@link java.util.List}
     *
     * @since 1.01
     *
     * @see java.util.List
     */
    public List<BinaryTree<T>> getForest() {
        List<BinaryTree<T>> nodes = new ArrayList<BinaryTree<T>>();
        if ( this.left != null ) nodes.add(this.left);
        if ( this.right != null ) nodes.add(this.right);
        return nodes;
    }

    /**
     * 获取当前树的深度
     *
     * @return 树的深度
     *
     * @since 1.01
     */
    public int depth() {
        return depth(this);
    }

    /**
     * 获取给定节点代表的前树的深度<br>
     * 目前以BFS计算
     *
     * @param node 指定的节点
     * @return 树的深度
     *
     * @since 1.01
     *
     * @see java.util.Deque
     * @see java.util.ArrayDeque
     */
    @SuppressWarnings("unchecked")
    public static int depth(BinaryTree node) {
        if ( node == null ) return 0;
        Deque<BinaryTree> deque = new ArrayDeque<BinaryTree>();
        int depth = 0;
        deque.add(node);
        while ( deque.size() > 0 ) {
            int nodes = deque.size();
            for ( int i = 0; i < nodes; i++ ) {
                BinaryTree<Integer> tempNode = deque.poll();
                if ( tempNode.left != null ) deque.add(tempNode.left);
                if ( tempNode.right != null ) deque.add(tempNode.right);
            }
            depth++;
        }
        return depth;
        /*while ( node != null || deque.size() > 0 ) {
            while ( node != null ) {
                System.out.println(node.val);
                deque.push(node);
                node = node.left;
            }
            depth = depth > deque.size() ? depth : deque.size();
            if ( deque.size() > 0 ) {
                node = deque.pop().right;
            }
        }
        return depth;*/
    }

    /**
     * 清空当前节点的子节点
     *
     * @return 删除的子节点个数
     *
     * @since 1.01
     */
    public int clear() {
        this.degree = 0;
        int num = 0;
        if ( this.left != null ) {
            this.numberOfNodes -= this.left.numberOfNodes;
            this.left = null;
            num++;
        }
        if ( this.right != null ) {
            this.numberOfNodes -= this.right.numberOfNodes;
            this.right = null;
            num++;
        }
        return num;
    }

    /**
     * 判断当前节点是否为叶子节点
     *
     * @return true - 是叶子结点 false - 不是叶子结点
     *
     * @since 1.01
     */
    public boolean isLeaf() {
        return this.degree == 0;
    }

    /**
     * 判断二叉树是否是满树
     *
     * <pre>
     * {@code
     * depth² == numberOfNodes + 1
     * }
     * </pre>
     *
     * @return 如果是满二叉树，则返回trun，否则返回false
     */
    public boolean isFull() {
        return this.numberOfNodes == (Math.pow(2, this.depth()) - 1);
    }

    /**
     * 判断二叉树是否是满二叉树
     *
     * <pre>
     * {@code
     * (depth - 1)² < numberOfNodes + 1
     * }
     * </pre>
     *
     * @return 如果是满二叉树，则返回trun，否则返回false
     */
    public boolean isComplete() {
        return this.numberOfNodes > (Math.pow(2, this.depth()) - 1);
    }
}
