package idni.jbc.forfree.struct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树
 *
 * @param <T> 树节点类型
 *
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 *
 * @see idni.jbc.forfree.struct.tree.BinaryTree
 */
public class TreeNode<T> {

    /** 节点值 */
    public T val;

    /** 树的度 */
    public int degree = 0;

    public int numberOfNodes = 1;

    /** 子节点列表 */
    private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

    //添加节点时需要将父节点depth更新，一直回溯到根结点
    //public int depth = 1;

    public TreeNode() { }

    /**
     * 构造树节点
     * 
     * @param val 指定节点的值
     */
    public TreeNode(T val) { this.val = val; }

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
        this.val = val;
        this.degree = children.length;
        for ( TreeNode<T> child : children ) {
            this.numberOfNodes += child.numberOfNodes;
            this.children.add(child);
        }
    }

    public void addNode(TreeNode<T> node) {
        this.degree++;
        this.numberOfNodes++;
        this.children.add(node);
    }

    public int addNodes(List<TreeNode<T>> nodes) {
        this.degree += nodes.size();
        this.numberOfNodes += nodes.size();
        this.children.addAll(nodes);
        return nodes.size();
    }

    public List<TreeNode<T>> getChildren() {
        return this.children;
    }

    public int depth() {
        return depth(this);
    }

    public static int depth(TreeNode node) {
        List<TreeNode> children = node.getChildren();
        int nodeDepth = 1,
            childrenNum = children.size();

        for ( int i = 0; i < childrenNum; i++ ) {
            int childDepth = depth(children.get(i));
            nodeDepth = nodeDepth >= childDepth ? nodeDepth : childDepth;
        }

        if ( childrenNum > 0 ) {
            nodeDepth++;
        }

        return nodeDepth;
    }

    /**
     * 清空当前节点的子节点
     *
     * @return 删除的子节点个数
     *
     * @since 1.01
     */
    public int clear() {
        int num = this.children.size();
        this.numberOfNodes -= num;
        this.children.clear();
        return num;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (val != null ? val.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (int)degree;
        result = 31 * result + (int)numberOfNodes;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode object = (TreeNode) o;

        if (val != null ? !val.equals(object.val) : object.val != null) return false;
        if (children != null ? !children.equals(object.children) : object.children != null) return false;
        if (degree != object.degree) return false;
        return !(numberOfNodes != object.numberOfNodes);
    }
}
