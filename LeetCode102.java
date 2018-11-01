package Leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

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
     * Description: 
     *
     * @auther: sxl_lab
     * @date: 2018/11/1 21:23
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

//        存储结点的队列
        List<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).offer(root);
        int deep = 0;
        while (queue != null){
            TreeNode node = ((LinkedList<TreeNode>) queue).poll();

//            res.add(node.val);
            if (node.left != null) ((LinkedList<TreeNode>) queue).offer(node.left);
            if (node.right != null) ((LinkedList<TreeNode>) queue).offer(node.right);
        }
        return res;
    }
}
