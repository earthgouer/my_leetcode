package leetcodecn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<>(0, root));
        while ( !q.isEmpty()){
            Pair<Integer, TreeNode> p = q.poll();
            int level = p.getKey();
            TreeNode node = p.getValue();
            while (res.size() <= level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.right != null) q.offer(new Pair<>(level +1 , node.right));
            if (node.left != null) q.offer(new Pair<>(level +1 , node.left));
        }
        return res;
    }
}
