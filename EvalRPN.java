package leetcodecn;

import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(new EvalRPN().evalRPN(tokens));
    }

//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        String operations = "+-*/";
//        for (int i=0;i<tokens.length;i++){
//            String curr = tokens[i];
//            int index = operations.indexOf(curr);
//            if (index==-1){
//                stack.push(Integer.parseInt(curr));
//            }
//            else{
//                int num1= stack.pop();
//                int num2= stack.pop();
//                int result = 0;
//                switch(index){
//                    case 0:
//                        result = num2+num1;
//                        break;
//                    case 1:
//                        result = num2-num1;
//                        break;
//                    case 2:
//                        result = num2*num1;
//                        break;
//                    case 3:
//                        result = num2/num1;
//                }
//                stack.push(result);
//            }
//        }
//        return stack.pop();
//    }



    public int evalRPN(String[] tokens){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/"){
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                switch (tokens[i]){
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1 / num2));
                        break;
                }
            }else{
                stack.push(tokens[i]);
            }

        }
        return Integer.valueOf(stack.pop());
    }
}
