1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        ListNode slow=head;
15        ListNode fast=head;
16        while(fast!=null&&fast.next!=null)
17        {
18            slow=slow.next;
19            fast=fast.next.next;
20            if(slow==fast)return true;
21        }
22        return false;
23    }
24}