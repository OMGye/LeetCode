/**
 * Created by upupgogogo on 2018/8/24.下午4:34
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
       if (head == null)
           return null;
      ListNode dummyNode = new ListNode(-1);
      dummyNode.next = head;
      remove(dummyNode,val);
      return dummyNode.next;
    }

    private void remove(ListNode pre, int val){
        if (pre.next == null)
            return;
        if (pre.next.val == val) {
            pre.next = pre.next.next;
            removeElements(pre, val);
        }else
            remove(pre.next,val);
    }
}
