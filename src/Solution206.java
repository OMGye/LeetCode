/**
 * Created by upupgogogo on 2018/8/21.下午1:14
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
      if(head == null)
          return head;
      ListNode pre = null;
      ListNode cur = head;
      ListNode next = head.next;
      while (cur != null){
          cur.next = pre;
          pre = cur;
          cur = next;
          if (cur != null)
              next = next.next;
      }
      return cur;
    }
}
