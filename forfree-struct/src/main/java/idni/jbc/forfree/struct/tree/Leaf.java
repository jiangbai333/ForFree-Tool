package idni.jbc.forfree.struct.tree;

/**
 * 树的基础节点 提供不分方法 及基础属性
 *
 * @param <T> 节点类型
 *
 * @author 姜柏超
 * @version 1.01
 *
 * @since 1.01
 */
public class Leaf<T> {

    
    /** 节点值 */
    protected T val;

    /** 节点的度 */
    protected int degree = 0;

    /** 节点数量 */
    protected int numberOfNodes = 1;

    //添加节点时需要将父节点depth更新，一直回溯到根结点
    protected int depth = 1;

    public Leaf() { }

    /**
     * 构造节点
     * 
     * @param val 指定节点的值
     */
    public Leaf(T val) { this.val = val; }

    public boolean ifLeaf() {
        return this.degree == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (val != null ? val.hashCode() : 0);
        result = 31 * result + (int)degree;
        result = 31 * result + (int)numberOfNodes;
        result = 31 * result + (int)depth;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leaf object = (Leaf) o;

        if (val != null ? !val.equals(object.val) : object.val != null) return false;
        if (degree != object.degree) return false;
        if (numberOfNodes != object.numberOfNodes) return false;
        return !(depth != object.depth);
    }
}
