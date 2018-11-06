package leetcodecn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(null);
        System.out.println(s.empty());
    }





    public List< Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    public List< Integer > preorderTraversal(TreeNode root) {
        Stack< Comond > stack = new Stack < > ();
        List< Integer > res = new ArrayList<>();
        stack.push(new Comond(Action.go, root));
        while ( !stack.empty()){
            Comond comond = stack.pop();
            if (comond.action == Action.print){
                res.add(comond.node.val);
            }else{
                if (comond.node.right != null){
                    stack.push(new Comond(Action.go, comond.node.right));
                }
                if (comond.node.left != null){
                    stack.push(new Comond(Action.go, comond.node.left));
                }
                stack.push(new Comond(Action.print, comond.node));
            }
        }
        return  res;
    }


}

enum Action{
    go,
    print,
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Comond {
    Action action; // go -1  print：1
    TreeNode node;

    public Comond(Action action, TreeNode node) {
        this.action = action;
        this.node = node;
    }
}
