package leetcodecn;

import java.util.Stack;

public class simplifyPath {

    public static void main(String[] args) {
        System.out.println(new simplifyPath().simplifyPath("/home/foo/.bashrc"));
    }

    public String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
            if (".".equals(strs[i] ) || "".equals(strs[i] )) continue;
            else if ("..".equals(strs[i] )) {
                if (stack.empty()) continue;
                else stack.pop();
            }
            else{
                stack.push(strs[i]);
            }
        }

        if (stack.empty()) return "/";
        else{
            StringBuffer res = new StringBuffer();
            int len = stack.size();
            for (int i = 0; i < len; i++) {
                res.insert(0, stack.pop());
                res.insert(0, "/");
            }
            return res.toString();
        }
    }
}
