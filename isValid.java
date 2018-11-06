package leetcodecn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        System.out.println(new isValid().isValid("()"));
    }

    public boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else {
                if (stack.empty() || map.get(c) != stack.pop() )  // ||前后的判别式不能换  因为有 pop操作
                    return false;
            }
        }
        if (stack.empty()) return true;
        else return false;
    }
}
