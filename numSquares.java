package leetcodecn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class numSquares {


    //      广度优先遍历
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] visited = new int[n];
        if (n == 0) return 0;
        q.add(new Pair<>(n, 0));
        while ( !q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            if (p.getKey()==0) return p.getValue();
            int num = p.getKey();
            int step = p.getValue();
            for (int i = 1; ; i++) {
                int a = num - i*i ;
                if (a<0) break;
                if (a == 0) return step+1;
                if (visited[a] == 0){
                    q.add(new Pair<>(a, step+1));
                    visited[a] = 1;
                }
            }
        }
        return -1;
    }
}
