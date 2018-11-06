package leetcodecn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return  res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()){
            int levelSum = q.size();
            for (int i = 0; i < levelSum; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                if (i == levelSum-1){
                    res.add(q.poll().val);
                }else{
                    q.poll();
                }
            }
        }
        return res;
    }
}
