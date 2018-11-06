package leetcodecn;


public class addTwoNumbers {

    public static void main(String[] args) {
        addTwoNumbers add = new addTwoNumbers();

        ListNode l1 = add.numToListNode(9);
        add.write(l1);
        ListNode l2 = add.numToListNode(9999999992l);
        add.write(l2);

        ListNode l3 = add.addTwoNumbers(l1, l2);
        add.write(l3);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tag = 0;
        ListNode node = new ListNode(0);
        ListNode node1 = node;
        while (l1.next != null || l2.next!= null){
            int res = l1.val + l2.val + tag;
            node1.next = new ListNode(res%10);
            tag = res/10;
            node1 = node1.next;
            l1 = l1.next != null ? l1.next: new ListNode(0);
            l2 = l2.next != null ? l2.next: new ListNode(0);
        }
        int res = l1.val + l2.val + tag;
        node1.next = new ListNode(res%10);
        tag = res/10;
        node1 = node1.next;
        if (tag > 0){
            node1.next = new ListNode(1);
        }
        return node.next;
    }



    /*
        转化为数字  数字相加在转换为    listnode

        不可行 ，数字太大会溢出。
     */
   private ListNode numToListNode(long num){
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

    private long read(ListNode l1) {
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



    private void write(ListNode l){
        while (l.next != null){
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println(l.val);
    }
}


