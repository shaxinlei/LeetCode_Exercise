package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树层的平均值
 * 基于102题
 * @author : sxl_lab
 * @date : 2018-11-02
 * time : 10:57
 */
public class LeetCode637 {
    /**
     *
     * Description:
     * 时间复杂度O(n) n表示结点个数
     * 空间复杂度O(m) m结点最多层的结点个数
     * @author : sxl_lab
     * @date : 2018/11/2 11:06
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

//        根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
//            进入下一层
            int len = queue.size();
            int sum = 0;
//            将同一层的元素放入同一列表
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum*1.0/len);
        }
        return res;
    }
}
