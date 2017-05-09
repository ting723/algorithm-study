package zhanglw.study.algorithm.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhanglianwei on 2017/5/8.
 */
public class BinaryTree {

    private TreeNode root = null;


    /**
     * 构造函数 根节点
     */
    public BinaryTree() {
        this.root = new TreeNode(1, "A");
    }

    /**
     * 创建二叉树
     * <pre>
     *          A
     *     B          C
     *  D     E            F
     *  </pre>
     */
    public void createNodeTree(TreeNode root) {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        root.leftChild.leftChild = nodeD;
        root.leftChild.rightChild = nodeE;
        root.rightChild.rightChild = nodeF;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 获取根节点
     *
     * @return
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * 获取左节点
     *
     * @param node
     * @return
     */
    public TreeNode getLeftChildNode(TreeNode node) {
        return (node != null) ? node.leftChild : null;
    }

    /**
     */

    /**
     * 获取右节点
     *
     * @param node
     * @return
     */
    public TreeNode getRightChildNode(TreeNode node) {
        return (node != null) ? node.rightChild : null;
    }


    /**
     * 删除某个节点值
     *
     * @param node
     */
    public void destroyNode(TreeNode node) {
        if (node != null) {
            destroyNode(node.leftChild);
            destroyNode(node.rightChild);
            node = null;
        }
    }

    /**
     * 计算二叉树高度
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * 计算二叉树节点数
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * 返回双亲节点
     *
     * @param node
     * @return
     */
    public TreeNode parent(TreeNode node) {
        return (root == null || root == node) ? null : parent(root, node);
    }

    /**
     * 先序遍历
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            print(node);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            print(node);
            inOrder(node.rightChild);
        }
    }


    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            print(node);
        }
    }


    public void levelOrder(TreeNode node) {
        if (node != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            // 添加到末尾
            queue.offer(node);
            TreeNode p;
            while (!queue.isEmpty()) {
                // 从头部移除
                p = queue.poll();
                print(p);
                if (p.leftChild != null) queue.offer(p.leftChild);
                if (p.rightChild != null) queue.offer(p.rightChild);
            }
        }
    }

    /**
     * 先序遍历非递归实现
     *
     * @param node
     */
    public void nonRecPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                print(p);
                if (p.rightChild != null) stack.push(p.rightChild);
                if (p.leftChild != null) stack.push(p.leftChild);
            }
        }
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.leftChild);
            int rightHeight = height(node.rightChild);
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        }
    }

    private int size(TreeNode node) {
        return node == null ? 0 : 1 + size(node.leftChild) + size(node.rightChild);
    }

    private TreeNode parent(TreeNode node, TreeNode target) {
        // 查找到末尾的条件
        if (node == null) {
            return null;
        }

        // 查找到时的条件
        if (node.leftChild == target || node.rightChild == target) {
            return node;
        }

        TreeNode p;
        // 在左子树中查找
        if ((p = parent(node.leftChild, target)) != null) return p;

        // 在右子树中查找
        return parent(node.rightChild, target);
    }

    private void print(TreeNode node) {
        System.out.println("key:" + node.key + "--name:" + node.data);
    }

    /**
     * 二叉树基本数据结构
     */
    private class TreeNode {

        /**
         * 节点编码
         */
        private int key;

        private boolean isVisited = false;

        /**
         * 数据域
         */
        private String data;

        /**
         * 左节点
         */
        private TreeNode leftChild;

        /**
         * 右节点
         */
        private TreeNode rightChild;

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createNodeTree(binaryTree.root);
        System.out.println(binaryTree.height());
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\n");
        binaryTree.nonRecPreOrder(binaryTree.root);

        System.out.println("\n");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\n");
        binaryTree.postOrder(binaryTree.root);
        System.out.println("\n");
        binaryTree.levelOrder(binaryTree.root);
    }
}
