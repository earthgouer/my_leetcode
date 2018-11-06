package leetcodecn;

import java.util.*;

public class topKelements {

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3 ,2};
        int k =2;
        System.out.println(new topKelements().topKFrequent(nums, k));

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, new java.util.Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int count = 0;
        for (Map.Entry entry:
            map.entrySet()){
            System.out.println("key: " + entry.getKey() + "value:" + entry.getValue());
            if (count < k){
                pq.offer(entry);
                count ++;
            }else {
                if ( (int)entry.getValue() > pq.peek().getValue()){
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()){
            Map.Entry en = pq.poll();

            res.add((int)en.getKey());
        }
        return  res;
    }
}
