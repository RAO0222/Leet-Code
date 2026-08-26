1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeElements(ListNode head, int val) {
13        while(head!=null&&head.val==val)head=head.next;
14        ListNode current=head;
15        while(current!=null&&current.next!=null)
16        {
17           if(current.next.val==val)current.next=current.next.next;
18           else current=current.next;
19
20        }
21        return head;
22        
23    }
24}