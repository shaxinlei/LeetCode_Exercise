package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树的层序遍历
 * User: sxl_lab
 * Date: 2018-11-01
 * Time: 21:22
 */
public class LeetCode102 {
    /**
     *
     * Description: 标准的层序遍历
     * 层序遍历借助了队列这种数据结构来实现
     * 深度优先则在递归实现时，借助栈结构
     * @auther: sxl
     * @date: 2018/11/2 7:43
     */
    public static List<Integer> BFS(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return res;
    }

    /**
     *
     * Description: 参照标准的BFS方法，为了实现将每层的节点分开，需再使用一个队列来维护每层的节点
     *
     * @auther: sxl_lab
     * @date: 2018/11/1 21:23
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
//        存储结果的链表
        List<List<Integer>> res = new LinkedList<>();
//        存储结点的队列
        Queue<TreeNode> queue = new LinkedList<>();
//        存储每一层的节点
        Queue<Integer> layer = new LinkedList<>();

        if (root == null) return res;

//        先把根节点压入队列
        queue.add(root);
        layer.add(root.val);

        while (!queue.isEmpty()){
            res.add(new ArrayList<>(layer));
            int len = layer.size();
            while (len > 0){
                TreeNode node = queue.poll();
                layer.poll();
                len--;
                if (node.left != null) {
                    queue.add(node.left);
                    layer.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    layer.add(node.right.val);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(BFS(root));
        System.out.println(levelOrder(root));
    }
}
