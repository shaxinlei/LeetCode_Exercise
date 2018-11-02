package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的锯齿形层次遍历
 * 与102题类似
 * User: sxl_lab
 * Date: 2018-11-01
 * Time: 13:27
 */
public class LeetCode103 {
    /**
     * my solution(AC)
     * Description: 与102题类似，但考虑到每一层存储的方向不同，改用Integer数组存储每一层结点值
     *
     * @auther: sxl_lab
     * @date: 2018/11/2 10:26
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

//        根节点入队
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
//            进入下一层
//            List<Integer> layer = new LinkedList<>();
            int len = queue.size();
            Integer[] layer = new Integer[len];

//            将同一层的元素放入同一列表
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                // 奇数层从左往右，偶数层从右往左存
                if (level%2 ==0){
                    layer[len-i-1] = node.val;
                }
                else {
                    layer[i] = node.val;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(Arrays.asList(layer));
            level++;
        }
        return res;
    }

    /**
     * my solution(AC)
     * Description: 仍然用LinkedList，但考虑到不同层的不同存储顺序，在add时，使用add(value)和add(0, value)
     *
     * @auther: sxl_lab
     * @date: 2018/11/2 10:28
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

//        根节点入队
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
//            进入下一层
            List<Integer> layer = new LinkedList<>();
            int len = queue.size();
//            将同一层的元素放入同一列表
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if (level%2==0){
                    layer.add(0,node.val);
                }else {
                    layer.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(layer);
            level++;
        }
        return res;
    }
}
