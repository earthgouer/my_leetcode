package leetcodecn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagLevelOrder {

    public static void main(String[] args) {
        List l = new LinkedList();
        l.add(5);
        l.add(1,3);
        System.out.println(l);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return  res;
        Queue<TreeNode> q = new LinkedList();
        int flag = 1; // 1：正序
        q.add(root);
        while (!q.isEmpty()){
            int levelSum = q.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < levelSum; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                sub.add(flag == 1 ? sub.size():0, q.poll().val);
            }
            flag *= -1;
            res.add(sub);
        }
        return res;
    }
}
