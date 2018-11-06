package leetcodecn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeLists {

    public static void main(String[] args) {

      ListNode l = new ListNode();
        ListNode l1 = l.numToListNode(125);
        ListNode l2 = l.numToListNode(644);
//        l.write(l1);

        ListNode[] lists = {l1, l2};

        l.write(new MergeLists().mergeKLists(lists));
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return - o1.val + o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                pq.offer(cur);
                cur = cur.next;
            }
        }
        ListNode res = new ListNode();
        ListNode sss = res.next;
        while ( !pq.isEmpty()){
            sss = pq.poll();
            System.out.println(sss.val);
            sss = sss.next;
        }
        return res.next;
    }
}

