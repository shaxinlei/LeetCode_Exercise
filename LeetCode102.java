package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树的层序遍历，要求将每一层的元素作为一个列表，最后将每层的列表组成大列表作为返回值
 * 本题的难点在于：如何将同一层的元素放入同一列表
 * 补充：这里发现静态方法中无法new内部类的实例对象，因此将levelOrder2改为非静态
 * User: sxl_lab
 * Date: 2018-11-01
 * Time: 21:22
 */

public class LeetCode102 {

    /**
     * reference (AC) 不推荐
     * https://www.jianshu.com/p/ac04abbaaf9a
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

        if (root == null) {
            return res;
        }

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

    /**
     * reference(AC) 推荐
     * Description: 基本思想是使用queue直接bfs。为了在层序遍历时实现将同一行的元素放入同一列表，
     * 这里需要使用变量len来维护每一层元素的个数，具体来说，每层开始时队列的大小就是该层元素个数
     * @auther: sxl_lab
     * @date: 2018/11/2 9:07
     */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

//        根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
//            进入下一层
            List<Integer> layer = new LinkedList<>();
            int len = queue.size();
//            将同一层的元素放入同一列表
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                layer.add(node.val);   // 当前结点值加入当前层的列表

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(layer);
        }
        return res;
    }

    /*
    * 本题还有DFS解法，暂时未看
    * */

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
        System.out.println(levelOrder(root));
    }
}
