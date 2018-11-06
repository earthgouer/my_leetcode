package leetcodecn;

public class deleteNode {

    public static void main(String[] args) {
        ListNode ln = new ListNode();
        ListNode l1 = ln.numToListNode(4519);
        ln.write(l1);
        l1.deleteNode(new ListNode(5));
        ln.write(l1);

    }

    public void deleteNode(ListNode node) {

//        if (node.val == )
//
//        ListNode cur = node;
//        while(node.next != null){
//            if cur.val
//        }
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int x) { val = x; }

    public void deleteNode(ListNode node) {
        //如果删除的是头结点
        if (node.val == this.val) {
            this.val = next.val;
            this.next = next.next;
            return;
        }
        ListNode pre = this;
        ListNode cur = this.next;
        while(cur != null){
            //题目默认删除非尾节点
            if (cur.val == node.val ){
                pre.next = cur.next;
            }
            cur = cur.next;
            pre = pre.next;
        }
    }

    public ListNode numToListNode(long num){
        ListNode node = new ListNode(0);
        ListNode node1 = node;

        while(num/10 != 0){
            long g = num%10;
            num = num/10;
            node1.next = new ListNode((int)g);
            node1 = node1.next;
        }
        node1.next = new ListNode((int)num);
        return node.next;
    }


    public long read(ListNode l1) {
        int tag = 0;
        long sum = 0;
        while (l1.next !=null){
            sum += l1.val * Math.pow(10d, tag);
            l1 = l1.next;
            tag ++;
        }
        sum += l1.val * Math.pow(10d, tag);
        return sum;
    }



    public void write(ListNode l){
        ListNode cur = l;
        while (l != null){
            System.out.print(l.val + "->");
            l = l.next;
        }
    }

}


