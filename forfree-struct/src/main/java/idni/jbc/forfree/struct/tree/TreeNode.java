package idni.jbc.forfree.struct.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import idni.jbc.forfree.struct.tree.Leaf;

/**
 * 树结构，可用来构造普通树，提供不分操作方法
 *
 * @param <T> 树节点类型
 *
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 *
 * @see idni.jbc.forfree.struct.tree.Leaf
 */
public class TreeNode<T> extends Leaf<T> {

    /** 子节点列表 */
    public List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

    /**
     * 构造树节点
     *
     * @param val 指定节点的值
     */
    public TreeNode(T val) { super(val); }

    /**
     * 构造包含子节点的树
     *
     * @param val 指定节点的值
     * @param children 指定子节点列表
     *
     * @since 1.01
     */
    @SafeVarargs
    public TreeNode(T val, TreeNode<T> ...children) {
        this(val);
        this.degree = children.length;
        for ( TreeNode<T> child : children ) {
            this.numberOfNodes += child.numberOfNodes;
            this.children.add(child);
        }
    }

    /**
     * 为当前节点添加一个节点
     *
     * @param node 将要被添加的节点
     *
     * @since 1.01
     */
    public void addNode(TreeNode<T> node) {
        this.degree++;
        this.numberOfNodes++;
        this.children.add(node);
    }

    /**
     * 为当前节点在指定位置添加一个节点
     *
     * @param node 将要被添加的节点
     * @param index 添加位置的索引
     *
     * @since 1.01
     */
    public void addNode(TreeNode<T> node, int index) {
        this.degree++;
        this.numberOfNodes++;
        this.children.add(index, node);
    }

    /**
     * 为当前节点添加一组节点
     *
     * @param nodes 包含需要被添加的节点的 {@link java.util.List}
     * @return 添加的数量
     *
     * @since 1.01
     *
     * @see java.util.List
     */
    public int addNodes(List<TreeNode<T>> nodes) {
        this.degree += nodes.size();
        this.numberOfNodes += nodes.size();
        this.children.addAll(nodes);
        return nodes.size();
    }

    /**
     * 获取剪掉当前节点形成的森林
     *
     * @return List 返回的包含当前节点所有子节点的 {@link java.util.List}
     *
     * @since 1.01
     *
     * @see java.util.List
     */
    public List<TreeNode<T>> getForest() {
        return this.children;
    }

    /**
     * 获取以当前节点为根的树的深度
     *
     * @return 树的深度
     *
     * @since 1.01
     *
     * @see #depth(TreeNode)
     */
    public int depth() {
        return depth(this);
    }

    /**
     * 获取以指定节点为根的树的深度
     *
     * @param node 指定节点
     *
     * @return 树的深度
     *
     * @since 1.01
     *
     * @see idni.jbc.forfree.struct.tree.TreeNode
     */
    @SuppressWarnings("unchecked")
    public static int depth(TreeNode node) {
        if ( node == null ) return 0;
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        int depth = 0;
        deque.push(node);
        while ( deque.size() > 0 ) {
            int nodes = deque.size();
            for (int i = 0; i < nodes; i++) {
                List<TreeNode> children = deque.pop().getForest();
                for (TreeNode child : children ) {
                    if ( child != null ) deque.push(child);
                }
            }
            depth++;
        }
        return depth;
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
        int num = this.children.size();
        for (int i = 0; i < num; i++) {
            this.numberOfNodes -= this.children.get(i).numberOfNodes;
        }
        this.children.clear();
        return num;
    }

    /**
     * 判断当前节点是否为叶子节点
     *
     * @return true - 是叶子结点 false - 不是叶子结点
     *
     * @since 1.01
     */
    public boolean ifLeaf() {
        return this.degree == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode object = (TreeNode) o;

        return !(children != null ? !children.equals(object.children) : object.children != null);
    }
}
