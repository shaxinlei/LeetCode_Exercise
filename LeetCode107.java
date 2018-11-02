package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的层次遍历 II 返回自底向上的层次遍历
 * 与102题类似
 * User: sxl_lab
 * Date: 2018-11-02
 * Time: 10:44
 */
public class LeetCode107 {

    /**
     * my solution(AC)
     * Description: 在将每层的结点列表插入resList时，使用add(0,layer)
     * 时间复杂度O(n) n为结点个数，每个结点只访问一次
     * 空间复杂度O(m) m为结点最多层的结点个数
     * @auther: sxl_lab
     * @date: 2018/11/2 10:50
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                layer.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0, layer);
        }
        return res;
    }
}
