package leetcodecn;

import javafx.util.Pair;

import java.util.*;

public class Ladder {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(2);
            pq.offer(num);
            System.out.println(num + "   insert");
        }
        while (!pq.isEmpty()){
            System.out.print(pq.poll() + "  ");
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }




    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] visited = new int[wordList.size()];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair<String, Integer>(beginWord, 1));
        while (!q.isEmpty()){
            Pair<String, Integer> p = q.poll();
            String s = p.getKey();
            Integer len = p.getValue();
            if (s.equals(endWord)) return len;
            for (int i = 0; i < wordList.size(); i++) {
                if (visited[i] == 0 && canConvert(s, wordList.get(i))){
                    q.add(new Pair(wordList.get(i), len+1));
                    visited[i] = 1;
                }
            }
        }
        return 0;
    }
    private boolean canConvert(String s1, String s2){
        int diffent = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffent++;
        }
        System.out.println(diffent);
        if (diffent == 1) return true;
        return false;
    }
}
